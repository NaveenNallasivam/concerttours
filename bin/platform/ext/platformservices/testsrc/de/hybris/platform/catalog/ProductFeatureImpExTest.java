/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.enums.ClassificationAttributeTypeEnum;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.ProductFeatureModel;
import de.hybris.platform.catalog.model.classification.ClassAttributeAssignmentModel;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeModel;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeValueModel;
import de.hybris.platform.catalog.model.classification.ClassificationClassModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemModel;
import de.hybris.platform.catalog.model.classification.ClassificationSystemVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.EmployeeModel;
import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.i18n.FormatFactory;
import de.hybris.platform.servicelayer.impex.ExportConfig;
import de.hybris.platform.servicelayer.impex.ExportResult;
import de.hybris.platform.servicelayer.impex.ExportService;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.MediaBasedImpExResource;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.type.TypeService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.testframework.PropertyConfigSwitcher;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;


/**
 * created for HOR-262
 */
@IntegrationTest
public class ProductFeatureImpExTest extends ServicelayerTest
{
	@Resource
	private ModelService modelService;
	@Resource
	private ExportService exportService;
	@Resource
	private ImportService importService;
	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Resource
	private UserService userService;
	@Resource
	private TypeService typeService;
	@Resource
	private FormatFactory formatFactory;

	private CatalogVersionModel catalogVersion;
	private ClassificationSystemModel classificationSystem;
	private ClassificationSystemVersionModel classificationSystemVersion;
	private ClassificationAttributeModel classificationAttribute;
	private ClassificationAttributeValueModel classificationAttributeValue;
	private ClassAttributeAssignmentModel classAttributeAssignment;

	private final PropertyConfigSwitcher persistenceLegacyMode = new PropertyConfigSwitcher("persistence.legacy.mode");


	@Before
	public void prepare() throws ConsistencyCheckException
	{
		final CatalogModel cm1 = modelService.create(CatalogModel.class);
		cm1.setId("sl_a");
		modelService.save(cm1);

		catalogVersion = modelService.create(CatalogVersionModel.class);
		catalogVersion.setCatalog(cm1);
		catalogVersion.setVersion("v1.0");

		classificationSystem = modelService.create(ClassificationSystemModel.class);
		classificationSystem.setId("testClassificationSystem");
		classificationSystemVersion = modelService.create(ClassificationSystemVersionModel.class);
		classificationSystemVersion.setCatalog(classificationSystem);
		classificationSystemVersion.setVersion("testVersion");
		classificationAttribute = modelService.create(ClassificationAttributeModel.class);
		classificationAttribute.setCode("testClassificationAttributeCode");
		classificationAttribute.setSystemVersion(classificationSystemVersion);
		classificationAttributeValue = modelService.create(ClassificationAttributeValueModel.class);
		classificationAttributeValue.setCode("classificationAttributeValueCode");
		classificationAttributeValue.setSystemVersion(classificationSystemVersion);

		final ClassificationClassModel ccm = modelService.create(ClassificationClassModel.class);
		ccm.setCatalogVersion(classificationSystemVersion);
		ccm.setCode("fikumiku");

		classAttributeAssignment = modelService.create(ClassAttributeAssignmentModel.class);
		classAttributeAssignment.setClassificationAttribute(classificationAttribute);
		classAttributeAssignment.setClassificationClass(ccm);

		modelService.saveAll();
	}

	@After
	public void tearDown()
	{
		persistenceLegacyMode.switchBackToDefault();
	}

	@Test
	public void shouldExportAndImport_String_ProductFeatureViaImpEx() throws Exception
	{
		exportAndImportProductFeatureWithValueOf("someFooValue");
	}

	@Test
	public void shouldExportAndImport_Boolean_ProductFeatureViaImpEx() throws Exception
	{
		exportAndImportProductFeatureWithValueOf(Boolean.TRUE);
	}

	@Test
	public void shouldExportAndImport_Date_ProductFeatureViaImpEx() throws Exception
	{
		exportAndImportProductFeatureWithValueOf(new DateTime().withMillisOfSecond(0).toDate());
	}

	@Test
	public void shouldExportAndImport_Number_ProductFeatureViaImpEx() throws Exception
	{
		exportAndImportProductFeatureWithValueOf(
				BigDecimal.valueOf(139999999, formatFactory.createNumberFormat().getMaximumFractionDigits()));
	}

	@Test
	public void shouldExportAndImport_ClassificationAttributeValue_ProductFeatureViaImpEx() throws Exception
	{
		exportAndImportProductFeatureWithValueOf(classificationAttributeValue);
	}

	@Test
	public void shouldExportAndImport_UserReferenceConfiguredToHandleSubtypes_ProductFeatureViaImpEx() throws Exception
	{
		// given
		final ProductModel productModel = aProduct();
		final EmployeeModel adminUser = userService.getAdminUser();
		final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
		classAttributeAssignment.setAttributeType(ClassificationAttributeTypeEnum.REFERENCE);
		classAttributeAssignment.setReferenceType(typeService.getComposedTypeForCode("User"));
		feature.setClassificationAttributeAssignment(classAttributeAssignment);
		feature.setValue(adminUser);
		feature.setProduct(productModel);
		modelService.save(feature);
		final ExportResult exportResult = exportData();
		modelService.remove(feature);

		// when
		importDataFrom(exportResult);

		// then
		final List<ProductFeatureModel> features = findFeaturesForProduct(productModel);
		assertThat(features).isNotEmpty().hasSize(1);
		assertThat(features.get(0).getValue()).isEqualTo(adminUser);
	}

	@Test
	public void shouldExportAndImport_UserReference_ProductFeatureViaImpEx() throws Exception
	{
		// given
		final ProductModel productModel = aProduct();
		final EmployeeModel adminUser = userService.getAdminUser();
		final ProductFeatureModel feature = modelService.create(ProductFeatureModel.class);
		classAttributeAssignment.setAttributeType(ClassificationAttributeTypeEnum.REFERENCE);
		classAttributeAssignment.setReferenceType(typeService.getComposedTypeForCode("Employee"));
		classAttributeAssignment.setReferenceIncludesSubTypes(Boolean.FALSE);
		feature.setClassificationAttributeAssignment(classAttributeAssignment);
		feature.setValue(adminUser);
		feature.setProduct(productModel);
		modelService.save(feature);
		final ExportResult exportResult = exportData();
		modelService.remove(feature);

		// when
		importDataFrom(exportResult);

		// then
		final List<ProductFeatureModel> features = findFeaturesForProduct(productModel);
		assertThat(features).isNotEmpty().hasSize(1);
		assertThat(features.get(0).getValue()).isEqualTo(adminUser);
	}

	private void exportAndImportProductFeatureWithValueOf(final Object value) throws Exception
	{
		// given
		final ProductModel productWithOneFeature = aProduct();

		final ProductFeatureModel modelItem = aProductFeature(value, productWithOneFeature);

		modelService.save(modelItem);

		final ExportResult exportResult = exportData();

		modelService.remove(modelItem);

		final List<ProductFeatureModel> resultAfterRemoval = findFeaturesForProduct(productWithOneFeature);
		assertThat(resultAfterRemoval).isEmpty();

		// when
		importDataFrom(exportResult);

		// then
		final List<ProductFeatureModel> resultAfterImport = findFeaturesForProduct(productWithOneFeature);
		assertThat(resultAfterImport).hasSize(1);

		final ProductFeatureModel importedFeature = Iterables.getOnlyElement(resultAfterImport);

		assertThat(importedFeature.getValue()).isEqualTo(value);
	}


	@Test
	@Ignore("this will not work on SLD as even if no fields have change there always will be an update during save")
	public void exportAndImportProductFeatureWithSameBigDecimalValueShouldNotIncrementThePersistenceVersion_SLD() throws Exception
	{
		persistenceLegacyMode.switchToValue("false");
		exportAndImportProductFeatureWithSameBigDecimalValueShouldNotIncrementThePersistenceVersion();
	}

	@Test
	public void exportAndImportProductFeatureWithSameBigDecimalValueShouldNotIncrementThePersistenceVersion_JALO()
			throws Exception
	{
		persistenceLegacyMode.switchToValue("true");
		exportAndImportProductFeatureWithSameBigDecimalValueShouldNotIncrementThePersistenceVersion();
	}

	private void exportAndImportProductFeatureWithSameBigDecimalValueShouldNotIncrementThePersistenceVersion() throws Exception
	{

		// given
		final ProductModel productWithOneFeature = aProduct();

		final BigDecimal bigDecimal = new BigDecimal("13.99900000");
		final ProductFeatureModel modelItem = aProductFeature(bigDecimal, productWithOneFeature);

		modelService.save(modelItem);

		final ExportResult exportResult = exportData();

		final long persistenceVersion = modelItem.getItemModelContext().getPersistenceVersion();

		// when
		importDataFrom(exportResult);

		// then
		final List<ProductFeatureModel> resultAfterImport = findFeaturesForProduct(productWithOneFeature);
		assertThat(resultAfterImport).hasSize(1);

		final ProductFeatureModel importedFeature = Iterables.getOnlyElement(resultAfterImport);

		assertThat((BigDecimal) importedFeature.getValue()).isEqualByComparingTo(bigDecimal);
		assertThat(importedFeature.getItemModelContext().getPersistenceVersion()).isEqualTo(persistenceVersion);
	}

	private ProductFeatureModel aProductFeature(final Object value, final ProductModel productWithOneFeature)
	{
		final ProductFeatureModel modelItem = modelService.create(ProductFeatureModel.class);
		modelItem.setProduct(productWithOneFeature);
		modelItem.setValue(value);
		modelItem.setQualifier("someBarQual");
		return modelItem;
	}

	private ProductModel aProduct()
	{
		final ProductModel productWithOneFeature = modelService.create(ProductModel.class);
		productWithOneFeature.setCatalogVersion(catalogVersion);
		productWithOneFeature.setCode("someFooCode12345");
		modelService.save(productWithOneFeature);
		return productWithOneFeature;
	}

	private ExportResult exportData() throws Exception
	{

		final ByteArrayInputStream baos = new ByteArrayInputStream(
				"INSERT_UPDATE ProductFeature;product[unique=true];qualifier[unique=true];classificationAttributeAssignment;value[translator=de.hybris.platform.catalog.jalo.classification.impex.ProductFeatureValueTranslator]"
						.getBytes(StandardCharsets.UTF_8));

		final ExportConfig config = new ExportConfig();
		config.setScript(new StreamBasedImpExResource(baos, "UTF-8"));
		config.setValidationMode(ExportConfig.ValidationMode.STRICT);
		config.setEncoding("UTF-8");
		return exportService.exportData(config);
	}

	private void importDataFrom(final ExportResult exportResult)
	{
		final ImportConfig importConfig = new ImportConfig();
		importConfig.setScript(new MediaBasedImpExResource(exportResult.getExportedData()));
		importConfig.setMainScriptWithinArchive("importscript.impex");
		importConfig.setSynchronous(true);

		importService.importData(importConfig);
	}

	private List<ProductFeatureModel> findFeaturesForProduct(final ProductModel productWithOneFeature)
	{
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"select {" + Item.PK + "} from {" + ProductFeatureModel._TYPECODE
						+ "} where {product} = ?product");
		query.addQueryParameter("product", productWithOneFeature);
		final SearchResult<ProductFeatureModel> searchResult = flexibleSearchService.search(query);
		return searchResult.getResult();
	}

}
