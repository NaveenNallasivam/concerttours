/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.interceptors;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.servicelayer.i18n.L10NService;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import org.fest.assertions.Fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@UnitTest
public class DefaultCatalogRemoveInterceptorTest
{
	private DefaultCatalogRemoveInterceptor defaultCatalogRemoveCatalogRemoveInterceptor;

	@Mock
	private L10NService l10nService;

	private CatalogModel catalog;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		defaultCatalogRemoveCatalogRemoveInterceptor = new DefaultCatalogRemoveInterceptor();
		defaultCatalogRemoveCatalogRemoveInterceptor.setL10nService(l10nService);

		catalog = new CatalogModel();

	}

	@Test
	public void revomeTest()
	{

		catalog.setDefaultCatalog(Boolean.FALSE);

		try
		{
			defaultCatalogRemoveCatalogRemoveInterceptor.onRemove(catalog, null);
		}
		catch (final InterceptorException e)
		{
			Fail.fail();

		}
	}

	@Test
	public void revomeDefaultTest()
	{
		catalog.setDefaultCatalog(Boolean.TRUE);
		Mockito.when(l10nService.getLocalizedString("error.catalog.removing_default_catalog")).thenReturn("Error.");
		try
		{
			defaultCatalogRemoveCatalogRemoveInterceptor.onRemove(catalog, null);
			Fail.fail();
		}
		catch (final InterceptorException e)
		{
			// nothing to do

		}
	}

}
