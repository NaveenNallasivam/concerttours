/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearch.integration.synchronization;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.adaptivesearch.model.AbstractAsBoostItemConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AbstractAsConfigurableSearchConfigurationModel;
import de.hybris.platform.adaptivesearch.model.AbstractAsSearchProfileModel;
import de.hybris.platform.adaptivesearch.model.AsPromotedItemModel;
import de.hybris.platform.adaptivesearch.services.AsConfigurationService;
import de.hybris.platform.adaptivesearch.services.AsSearchConfigurationService;
import de.hybris.platform.adaptivesearch.services.AsSearchProfileService;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.synchronization.CatalogSynchronizationService;
import de.hybris.platform.impex.jalo.ImpExException;

import java.util.Optional;

import javax.annotation.Resource;

import org.apache.commons.lang.CharEncoding;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


@IntegrationTest
public class AsPromotedItemSynchronizationTest extends AbstractAsSynchronizationTest
{
	private final static String CATALOG_ID = "hwcatalog";
	private final static String VERSION_STAGED = "Staged";
	private final static String VERSION_ONLINE = "Online";

	private static final String SEARCH_PROFILE_CODE = "searchProfile";
	private static final String SEARCH_CONFIGURATION_UID = "searchConfiguration";

	private static final String UID1 = "cde588ec-d453-48bd-a3b1-b9aa00402256";

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Resource
	private CatalogVersionService catalogVersionService;

	@Resource
	private CatalogSynchronizationService catalogSynchronizationService;

	@Resource
	private AsSearchProfileService asSearchProfileService;

	@Resource
	private AsSearchConfigurationService asSearchConfigurationService;

	@Resource
	private AsConfigurationService asConfigurationService;

	private CatalogVersionModel onlineCatalogVersion;
	private CatalogVersionModel stagedCatalogVersion;
	private AbstractAsSearchProfileModel searchProfile;
	private AbstractAsConfigurableSearchConfigurationModel searchConfiguration;

	@Before
	public void setUp() throws ImpExException
	{
		importCsv("/adaptivesearch/test/integration/asBase.impex", CharEncoding.UTF_8);
		importCsv("/adaptivesearch/test/integration/asSimpleSearchProfile.impex", CharEncoding.UTF_8);
		importCsv("/adaptivesearch/test/integration/asSimpleSearchConfiguration.impex", CharEncoding.UTF_8);

		stagedCatalogVersion = catalogVersionService.getCatalogVersion(CATALOG_ID, VERSION_STAGED);
		onlineCatalogVersion = catalogVersionService.getCatalogVersion(CATALOG_ID, VERSION_ONLINE);

		final Optional<AbstractAsSearchProfileModel> searchProfileOptional = asSearchProfileService
				.getSearchProfileForCode(stagedCatalogVersion, SEARCH_PROFILE_CODE);
		searchProfile = searchProfileOptional.get();

		final Optional<AbstractAsConfigurableSearchConfigurationModel> searchConfigurationOptional = asSearchConfigurationService
				.getSearchConfigurationForUid(stagedCatalogVersion, SEARCH_CONFIGURATION_UID);
		searchConfiguration = searchConfigurationOptional.get();
	}

	@Test
	public void promotedItemNotFoundBeforeSynchronization() throws Exception
	{
		// given
		final AsPromotedItemModel promotedItem = asConfigurationService.createConfiguration(AsPromotedItemModel.class);
		promotedItem.setCatalogVersion(stagedCatalogVersion);
		promotedItem.setUid(UID1);
		promotedItem.setSearchConfiguration(searchConfiguration);
		promotedItem.setItem(stagedCatalogVersion);

		// when
		asConfigurationService.saveConfiguration(promotedItem);

		final Optional<AsPromotedItemModel> synchronizedPromotedItemOptional = asConfigurationService
				.getConfigurationForUid(AsPromotedItemModel.class, onlineCatalogVersion, UID1);

		// then
		assertFalse(synchronizedPromotedItemOptional.isPresent());
	}

	@Test
	public void synchronizeNewPromotedItem() throws Exception
	{
		// given
		final AsPromotedItemModel promotedItem = asConfigurationService.createConfiguration(AsPromotedItemModel.class);
		promotedItem.setCatalogVersion(stagedCatalogVersion);
		promotedItem.setUid(UID1);
		promotedItem.setSearchConfiguration(searchConfiguration);
		promotedItem.setItem(stagedCatalogVersion);

		// when
		asConfigurationService.saveConfiguration(promotedItem);
		catalogSynchronizationService.synchronizeFully(stagedCatalogVersion, onlineCatalogVersion);

		final Optional<AsPromotedItemModel> synchronizedPromotedItemOptional = asConfigurationService
				.getConfigurationForUid(AsPromotedItemModel.class, onlineCatalogVersion, UID1);

		// then
		assertTrue(synchronizedPromotedItemOptional.isPresent());

		final AsPromotedItemModel synchronizedPromotedItem = synchronizedPromotedItemOptional.get();
		assertSynchronized(promotedItem, synchronizedPromotedItem, AbstractAsBoostItemConfigurationModel.UNIQUEIDX);
	}

	@Test
	public void synchronizeRemovedPromotedItem() throws Exception
	{
		// given
		final AsPromotedItemModel promotedItem = asConfigurationService.createConfiguration(AsPromotedItemModel.class);
		promotedItem.setCatalogVersion(stagedCatalogVersion);
		promotedItem.setUid(UID1);
		promotedItem.setSearchConfiguration(searchConfiguration);
		promotedItem.setItem(stagedCatalogVersion);

		// when
		asConfigurationService.saveConfiguration(promotedItem);
		catalogSynchronizationService.synchronizeFully(stagedCatalogVersion, onlineCatalogVersion);

		asConfigurationService.removeConfiguration(promotedItem);
		catalogSynchronizationService.synchronizeFully(stagedCatalogVersion, onlineCatalogVersion);

		final Optional<AsPromotedItemModel> synchronizedPromotedItemOptional = asConfigurationService
				.getConfigurationForUid(AsPromotedItemModel.class, onlineCatalogVersion, UID1);

		// then
		assertFalse(synchronizedPromotedItemOptional.isPresent());
	}
}
