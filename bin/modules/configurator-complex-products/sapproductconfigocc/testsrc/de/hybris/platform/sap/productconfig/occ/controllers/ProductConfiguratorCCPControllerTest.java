/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.occ.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercewebservicescommons.dto.product.ImageWsDTO;
import de.hybris.platform.commercewebservicescommons.dto.product.PriceWsDTO;
import de.hybris.platform.sap.productconfig.facades.ConfigurationData;
import de.hybris.platform.sap.productconfig.facades.ConfigurationFacade;
import de.hybris.platform.sap.productconfig.facades.CsticData;
import de.hybris.platform.sap.productconfig.facades.CsticValueData;
import de.hybris.platform.sap.productconfig.facades.GroupType;
import de.hybris.platform.sap.productconfig.facades.PriceDataPair;
import de.hybris.platform.sap.productconfig.facades.PriceValueUpdateData;
import de.hybris.platform.sap.productconfig.facades.UiGroupData;
import de.hybris.platform.sap.productconfig.facades.UiType;
import de.hybris.platform.sap.productconfig.occ.ConfigurationWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticValueSupplementsWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticValueWsDTO;
import de.hybris.platform.sap.productconfig.occ.CsticWsDTO;
import de.hybris.platform.sap.productconfig.occ.GroupWsDTO;
import de.hybris.platform.webservicescommons.mapping.DataMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


@UnitTest
public class ProductConfiguratorCCPControllerTest
{
	private static final String PRODUCT_CODE = "product";
	private static final String GROUP1_ID = "1-WCEM_DEPENDENCY_PC.MONITOR";
	private static final String CONFIG_ID = "configId";
	private static final String GROUP2_ID = "1-WCEM_DEPENDENCY_PC.SOFTWARE";
	private static final String GROUP3_ID = "1-WCEM_DEPENDENCY_PC.ACCESSORY";
	private static final String GROUP3_1_ID = "1-WCEM_DEPENDENCY_PC_ACCESORY.GROUP1";
	private static final String GROUP3_1_1_ID = "1-WCEM_ACCESSORYGROUP1.GROUP1";
	private static final String GROUP3_2_ID = "1-WCEM_DEPENDENCY_PC_ACCESORY.GROUP2";
	private static final String ROOT_GROUP_ID = "RootId";
	private static final String VALUE_KEY = "ValueKey";

	private final ConfigurationWsDTO updatedConfiguration = new ConfigurationWsDTO();
	private final ConfigurationData updatedConfigurationAsFacadeDTO = new ConfigurationData();

	@Mock
	ConfigurationFacade configurationFacade;

	@Mock
	DataMapper dataMapper;

	@InjectMocks
	ProductConfiguratorCCPController classUnderTest;

	private final ConfigurationData backendUpdatedConfiguration = new ConfigurationData();
	private final ConfigurationWsDTO backendUpdatedWsConfiguration = new ConfigurationWsDTO();
	private final List<ImageData> imageListCstic = new ArrayList<>();
	private final ImageData imageCstic = new ImageData();
	private final List<ImageWsDTO> imageListCsticWs = new ArrayList<>();
	private final ImageWsDTO imageWs = new ImageWsDTO();
	private CsticData cstic;
	private CsticWsDTO csticWs;
	private List<CsticWsDTO> csticWsList;
	private UiGroupData group;
	private List<GroupWsDTO> groupsWs;
	private CsticValueData csticValue;
	private CsticValueWsDTO csticValueWs;
	private final List<ImageData> imageListValue = new ArrayList<>();
	private final ImageData imageValue = new ImageData();
	private final List<CsticValueWsDTO> csticValueListWs = new ArrayList<>();
	private final PriceValueUpdateData valuePrice = new PriceValueUpdateData();
	private final CsticSupplementsWsDTO attributeSupplement = new CsticSupplementsWsDTO();
	private final Map<String, PriceDataPair> valuePrices = new HashMap<String, PriceDataPair>();
	private final PriceDataPair valuePricePair = new PriceDataPair();
	private final PriceData obsoletePriceValue = new PriceData();
	private final PriceData priceValue = new PriceData();
	private final BigDecimal priceValueAsDecimal = BigDecimal.valueOf(1234);
	private final PriceWsDTO priceWs = new PriceWsDTO();


	@Before
	public void initialize()
	{
		csticValue = new CsticValueData();
		csticValue.setMedia(imageListValue);
		csticValue.setKey(VALUE_KEY);

		csticValueWs = new CsticValueWsDTO();
		csticValueWs.setKey(VALUE_KEY);
		csticValueListWs.add(csticValueWs);

		imageListCstic.add(imageCstic);
		imageListValue.add(imageValue);
		imageListCsticWs.add(imageWs);

		MockitoAnnotations.initMocks(this);


		prepareUpdatedConfiguration();
		prepareBackendUpdatedConfigurationWithTwoGroups();
		prepareBackendUpdatedConfigurationWithTwoGroupsWsRepresentation();

		group = backendUpdatedConfiguration.getGroups().get(0);
		cstic = group.getCstics().get(0);

		groupsWs = backendUpdatedWsConfiguration.getGroups();
		csticWsList = groupsWs.get(0).getAttributes();
		csticWs = csticWsList.get(0);

		valuePrice.setPrices(valuePrices);
		valuePrices.put(VALUE_KEY, valuePricePair);
		valuePricePair.setObsoletePriceValue(obsoletePriceValue);
		valuePricePair.setPriceValue(priceValue);
		priceValue.setValue(priceValueAsDecimal);
		priceWs.setValue(priceValueAsDecimal);

		Mockito.when(dataMapper.map(updatedConfiguration, ConfigurationData.class)).thenReturn(updatedConfigurationAsFacadeDTO);
		Mockito.when(dataMapper.map(backendUpdatedConfiguration, ConfigurationWsDTO.class))
				.thenReturn(backendUpdatedWsConfiguration);
		Mockito.when(dataMapper.map(valuePrice, CsticSupplementsWsDTO.class)).thenReturn(attributeSupplement);
		Mockito.when(dataMapper.map(priceValue, PriceWsDTO.class)).thenReturn(priceWs);
		Mockito.when(dataMapper.map(obsoletePriceValue, PriceWsDTO.class)).thenReturn(priceWs);
		Mockito.when(dataMapper.mapAsList(imageListCstic, ImageWsDTO.class, null)).thenReturn(imageListCsticWs);
		Mockito.when(dataMapper.mapAsList(imageListValue, ImageWsDTO.class, null)).thenReturn(imageListCsticWs);
		Mockito.when(configurationFacade.getConfiguration(updatedConfigurationAsFacadeDTO)).thenReturn(backendUpdatedConfiguration);
	}

	private void prepareBackendUpdatedConfigurationWithTwoGroupsWsRepresentation()
	{
		final List<GroupWsDTO> groups = new ArrayList();
		groups.add(createWsGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"));
		groups.add(createWsGroupWithOneCstic(GROUP2_ID, "CSTIC2", "VALUE2"));
		backendUpdatedConfiguration.setConfigId(CONFIG_ID);
		backendUpdatedWsConfiguration.setGroups(groups);

	}

	@Test
	public void testUpdateConfiguration()
	{
		final ConfigurationWsDTO configurationAfterUpdate = classUnderTest.updateConfiguration(updatedConfiguration.getConfigId(),
				updatedConfiguration);
		assertEquals(backendUpdatedWsConfiguration, configurationAfterUpdate);
	}

	@Test
	public void testFilterGroups()
	{
		final String requestedGroupId = GROUP2_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(2, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsRequestedGroupIdNull()
	{
		final String requestedGroupId = null;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(2, groups.size());
		assertEquals(1, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsWithListRequestedGroupIdNull()
	{
		final String requestedGroupId = null;
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		classUnderTest.filterGroups(groups, requestedGroupId);
		assertEquals(2, groups.size());
		assertEquals(1, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
	}


	@Test
	public void testFilterGroupsMultilevelRequestedSubSubGroup()
	{
		prepareBackendUpdatedConfigurationMultiLevel();
		final String requestedGroupId = GROUP3_1_1_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(3, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(0, groups.get(1).getCstics().size());
		final List<UiGroupData> subGroups = groups.get(2).getSubGroups();
		assertEquals(2, subGroups.size());
		assertEquals(1, subGroups.get(0).getSubGroups().size());
		assertEquals(1, subGroups.get(0).getSubGroups().get(0).getCstics().size());
		assertEquals(0, subGroups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsMultilevelRequestedSubGroup()
	{
		prepareBackendUpdatedConfigurationMultiLevel();
		final String requestedGroupId = GROUP3_2_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(3, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(0, groups.get(1).getCstics().size());
		final List<UiGroupData> subGroups = groups.get(2).getSubGroups();
		assertEquals(2, subGroups.size());
		assertEquals(1, subGroups.get(0).getSubGroups().size());
		assertEquals(0, subGroups.get(0).getSubGroups().get(0).getCstics().size());
		assertEquals(1, subGroups.get(1).getCstics().size());
	}

	@Test
	public void testFilterGroupsMultilevelRequestedRootLevelGroup()
	{
		prepareBackendUpdatedConfigurationMultiLevel();
		final String requestedGroupId = GROUP2_ID;
		classUnderTest.filterGroups(backendUpdatedConfiguration, requestedGroupId);
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		assertEquals(3, groups.size());
		assertEquals(0, groups.get(0).getCstics().size());
		assertEquals(1, groups.get(1).getCstics().size());
		final List<UiGroupData> subGroups = groups.get(2).getSubGroups();
		assertEquals(2, subGroups.size());
		assertEquals(1, subGroups.get(0).getSubGroups().size());
		assertEquals(0, subGroups.get(0).getSubGroups().get(0).getCstics().size());
		assertEquals(0, subGroups.get(1).getCstics().size());
	}

	@Test
	public void testHasSubGroups()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		final List<UiGroupData> subGroups = new ArrayList();
		instanceGroup.setSubGroups(subGroups);
		final UiGroupData subInstanceGroup = createInstanceGroup(GROUP3_1_ID);
		subGroups.add(subInstanceGroup);
		assertTrue(classUnderTest.hasSubGroups(instanceGroup));
	}

	@Test
	public void testHasSubGroupsEmpyList()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		final List<UiGroupData> subGroups = new ArrayList();
		instanceGroup.setSubGroups(subGroups);
		assertFalse(classUnderTest.hasSubGroups(instanceGroup));
	}

	@Test
	public void testHasSubGroupsFalse()
	{
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		assertFalse(classUnderTest.hasSubGroups(instanceGroup));
	}

	@Test
	public void testDeleteCstics()
	{
		final UiGroupData group = createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1");
		classUnderTest.deleteCstics(group);
		assertEquals(0, group.getCstics().size());
	}

	@Test
	public void testIsNotRequestedGroup()
	{
		final String requestedGroupId = GROUP2_ID;
		assertTrue(classUnderTest.isNotRequestedGroup(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"), requestedGroupId));
	}

	@Test
	public void testIsNotRequestedGroupFalse()
	{
		final String requestedGroupId = GROUP1_ID;
		assertFalse(classUnderTest.isNotRequestedGroup(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"), requestedGroupId));
	}

	@Test
	public void testIsNotRequestedGroupNull()
	{
		final String requestedGroupId = null;
		assertFalse(classUnderTest.isNotRequestedGroup(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"), requestedGroupId));
	}

	@Test
	public void testDetermineFirstGroupIdWithEmptyGroups()
	{
		updatedConfigurationAsFacadeDTO.setGroups(Collections.emptyList());
		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNull(result);
	}

	@Test
	public void testDetermineFirstGroupIdWithEmptySubGroups()
	{
		final List<UiGroupData> groups = new ArrayList<>();
		final UiGroupData group = new UiGroupData();
		group.setSubGroups(null);
		groups.add(group);
		updatedConfigurationAsFacadeDTO.setGroups(groups);
		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNull(result);
	}

	@Test
	public void testDetermineFirstGroupIdWithSubGroups()
	{
		final List<UiGroupData> groups = new ArrayList<>();
		final UiGroupData group = new UiGroupData();
		final List<UiGroupData> subGroups = new ArrayList<>();
		final UiGroupData subGroup = new UiGroupData();
		final String subGroupId = "subGroup_1";
		subGroup.setId(subGroupId);
		final List<CsticData> cstics = new ArrayList<>();
		for (int i = 1; i <= 5; i++)
		{
			final CsticData cstic = new CsticData();
			cstic.setName("cstic_" + i);
			cstics.add(cstic);
		}
		subGroup.setCstics(cstics);
		subGroups.add(subGroup);
		group.setSubGroups(subGroups);
		groups.add(group);
		updatedConfigurationAsFacadeDTO.setGroups(groups);

		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNotNull(result);
		assertEquals(subGroupId, result);
	}

	@Test
	public void testDetermineFirstGroupIdWithEmptyCstics()
	{
		final List<UiGroupData> groups = new ArrayList<>();
		final UiGroupData group = new UiGroupData();
		final List<UiGroupData> subGroups = new ArrayList<>();
		final UiGroupData subGroup = new UiGroupData();
		final String subGroupId = "subGroup_1";
		subGroup.setId(subGroupId);
		final List<CsticData> cstics = new ArrayList<>();
		subGroups.add(subGroup);
		group.setSubGroups(subGroups);
		groups.add(group);
		updatedConfigurationAsFacadeDTO.setGroups(groups);

		final String result = classUnderTest.determineFirstGroupId(updatedConfigurationAsFacadeDTO.getGroups());
		assertNull(result);
	}

	@Test
	public void testConvertImages()
	{
		final ConfigurationWsDTO configurationWs = new ConfigurationWsDTO();
		classUnderTest.convertImages(updatedConfigurationAsFacadeDTO, backendUpdatedWsConfiguration);
		final List<ImageWsDTO> images = csticWs.getImages();
		assertNotNull(images);
		assertEquals(1, images.size());
	}

	@Test
	public void testConvertImagesInCstic()
	{
		classUnderTest.convertImagesInCstic(cstic, csticWs);
		final List<ImageWsDTO> images = csticWs.getImages();
		assertNotNull(images);
	}

	@Test(expected = IllegalStateException.class)
	public void testConvertImagesInCsticListNoMatchFound()
	{
		csticWs.setName("Unknown");
		classUnderTest.convertImagesInCstic(cstic, csticWsList);
	}

	@Test
	public void testConvertImagesInGroup()
	{
		classUnderTest.convertImagesInGroup(group, groupsWs);
		final List<ImageWsDTO> images = csticWs.getImages();
		assertNotNull(images);
	}

	@Test
	public void testConvertImagesInGroupCheckSubGroups()
	{
		final UiGroupData rootGroup = new UiGroupData();
		rootGroup.setId(ROOT_GROUP_ID);
		rootGroup.setSubGroups(Arrays.asList(group));
		final GroupWsDTO rootWsGroup = new GroupWsDTO();
		rootWsGroup.setSubGroups(groupsWs);
		rootWsGroup.setId(ROOT_GROUP_ID);
		classUnderTest.convertImagesInGroup(rootGroup, Arrays.asList(rootWsGroup));
		final List<ImageWsDTO> images = csticWs.getImages();
		assertNotNull(images);
	}

	@Test(expected = IllegalStateException.class)
	public void testConvertImagesInGroupNoMatchFound()
	{
		group.setId("Unknown");
		classUnderTest.convertImagesInGroup(group, groupsWs);
	}

	@Test
	public void testConvertImagesInValue()
	{
		classUnderTest.convertImagesInValue(csticValue, csticValueWs);
		final List<ImageWsDTO> images = csticValueWs.getImages();
		assertNotNull(images);
		assertEquals(1, images.size());
	}

	@Test
	public void testConvertImagesInValueList()
	{
		classUnderTest.convertImagesInValue(csticValue, csticValueListWs);
		final List<ImageWsDTO> images = csticValueWs.getImages();
		assertNotNull(images);
	}

	@Test(expected = IllegalStateException.class)
	public void testConvertImagesInValueListNoMatch()
	{
		csticValueWs.setKey("Unknown");
		classUnderTest.convertImagesInValue(csticValue, csticValueListWs);
	}

	@Test
	public void testCreateAttributeSupplementDTO()
	{
		final CsticSupplementsWsDTO attributeSupplementDTO = classUnderTest.createAttributeSupplementDTO(valuePrice);
		assertNotNull(attributeSupplementDTO);
		final List<CsticValueSupplementsWsDTO> priceSupplements = attributeSupplementDTO.getPriceSupplements();
		assertNotNull(priceSupplements);
	}

	@Test
	public void testCreateAttributeSupplementDTOCoversNullPriceSupplements()
	{
		valuePrice.setPrices(null);
		final CsticSupplementsWsDTO attributeSupplementDTO = classUnderTest.createAttributeSupplementDTO(valuePrice);
		assertNotNull(attributeSupplementDTO);
		assertNotNull(attributeSupplementDTO.getPriceSupplements());
	}

	@Test
	public void testCreatePriceSupplements()
	{
		final List<CsticValueSupplementsWsDTO> priceSupplements = classUnderTest.createPriceSupplements(valuePrice.getPrices());
		assertNotNull(priceSupplements);
	}

	@Test
	public void testConvertEntrytoWsDTO()
	{
		final CsticValueSupplementsWsDTO valueSupplementsWsDTO = classUnderTest
				.convertEntrytoWsDTO(valuePrice.getPrices().entrySet().iterator().next());
		assertNotNull(valueSupplementsWsDTO);
		assertEquals(VALUE_KEY, valueSupplementsWsDTO.getAttributeValueKey());
		final PriceWsDTO priceWsDTO = valueSupplementsWsDTO.getPriceValue();
		assertNotNull(priceWsDTO);
		assertEquals(priceValueAsDecimal, priceWsDTO.getValue());
	}

	@Test(expected = NullPointerException.class)
	public void testConvertEntrytoWsDTONullNotAllowed()
	{
		classUnderTest.convertEntrytoWsDTO(null);
	}

	@Test
	public void testConvertEntrytoWsDTOObsoletePrice()
	{
		final CsticValueSupplementsWsDTO valueSupplementsWsDTO = classUnderTest
				.convertEntrytoWsDTO(valuePrice.getPrices().entrySet().iterator().next());
		assertEquals(priceValueAsDecimal, valueSupplementsWsDTO.getObsoletePriceValue().getValue());
	}

	private void prepareBackendUpdatedConfigurationWithTwoGroups()
	{
		final List<UiGroupData> groups = new ArrayList();
		groups.add(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"));
		groups.add(createGroupWithOneCstic(GROUP2_ID, "CSTIC2", "VALUE2"));
		backendUpdatedConfiguration.setConfigId(CONFIG_ID);
		backendUpdatedConfiguration.setGroups(groups);
	}

	private void prepareBackendUpdatedConfigurationMultiLevel()
	{
		final List<UiGroupData> groups = backendUpdatedConfiguration.getGroups();
		final UiGroupData instanceGroup = createInstanceGroup(GROUP3_ID);
		groups.add(instanceGroup);
		final List<UiGroupData> subGroups = new ArrayList();
		instanceGroup.setSubGroups(subGroups);
		final UiGroupData subInstanceGroup = createInstanceGroup(GROUP3_1_ID);
		subGroups.add(subInstanceGroup);
		subGroups.add(createGroupWithOneCstic(GROUP3_2_ID, "CSTIC3", "VALUE3"));
		final List<UiGroupData> subSubGroups = new ArrayList();
		subInstanceGroup.setSubGroups(subSubGroups);
		subSubGroups.add(createGroupWithOneCstic(GROUP3_1_1_ID, "CSTIC4", "VALUE4"));
	}

	private void prepareUpdatedConfiguration()
	{
		final List<UiGroupData> groups = new ArrayList();
		groups.add(createGroupWithOneCstic(GROUP1_ID, "CSTIC1", "VALUE1"));
		updatedConfigurationAsFacadeDTO.setConfigId(CONFIG_ID);
		updatedConfigurationAsFacadeDTO.setGroups(groups);
	}

	private UiGroupData createGroupWithOneCstic(final String groupId, final String csticName, final String valueName)
	{
		final UiGroupData group = new UiGroupData();
		group.setGroupType(GroupType.CSTIC_GROUP);
		group.setId(groupId);
		final List<CsticData> cstics = new ArrayList();
		cstics.add(createCsticData(csticName, UiType.RADIO_BUTTON, valueName));
		group.setCstics(cstics);
		return group;
	}

	private GroupWsDTO createWsGroupWithOneCstic(final String groupId, final String csticName, final String valueName)
	{
		final GroupWsDTO group = new GroupWsDTO();
		group.setId(groupId);
		final List<CsticWsDTO> cstics = new ArrayList();
		cstics.add(createCsticWsData(csticName, UiType.RADIO_BUTTON, valueName));
		group.setAttributes(cstics);
		return group;
	}

	private UiGroupData createInstanceGroup(final String groupId)
	{
		final UiGroupData group = new UiGroupData();
		group.setGroupType(GroupType.INSTANCE);
		group.setId(groupId);
		return group;
	}

	private CsticData createCsticData(final String name, final UiType type, final String value)
	{
		final CsticData cstic = new CsticData();
		cstic.setName(name);
		cstic.setType(type);
		cstic.setValue(value);
		cstic.setMedia(imageListCstic);
		cstic.setDomainvalues(Arrays.asList(csticValue));
		return cstic;
	}

	private CsticWsDTO createCsticWsData(final String name, final UiType type, final String value)
	{
		final CsticWsDTO cstic = new CsticWsDTO();
		cstic.setName(name);
		cstic.setType(type);
		cstic.setValue(value);
		cstic.setDomainValues(Arrays.asList(csticValueWs));
		return cstic;
	}
}
