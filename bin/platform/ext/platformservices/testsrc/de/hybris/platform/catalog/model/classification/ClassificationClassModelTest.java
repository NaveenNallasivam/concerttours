/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.catalog.model.classification;

import static org.fest.assertions.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.classification.ClassificationClassesResolverStrategy;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests the logic for all dynamic attributes of the model.
 */
@IntegrationTest
public class ClassificationClassModelTest extends ServicelayerTransactionalTest
{

	@Resource
	private ProductService productService;
	@Resource
	private ClassificationClassesResolverStrategy classificationClassesResolverStrategy;

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		createHardwareCatalog();
	}

	/**
	 * Test method for
	 * {@link de.hybris.platform.catalog.model.classification.ClassificationClassModel#getAllClassificationAttributeAssignments()}
	 * .
	 */
	@Test
	public void testGetAllClassificationAttributeAssignments()
	{
		// given
		final ProductModel productModel = productService.getProduct("HW2300-2356");
		final ClassificationClassModel classificationClassModel = classificationClassesResolverStrategy.resolve(productModel)
		                                                                                               .iterator().next();

		// when
		final List<ClassAttributeAssignmentModel> assignments = classificationClassModel.getAllClassificationAttributeAssignments();

		// then
		assertThat(assignments).isNotNull();
		assertThat(assignments).isNotEmpty();
		assertThat(assignments).hasSize(13);
	}

}
