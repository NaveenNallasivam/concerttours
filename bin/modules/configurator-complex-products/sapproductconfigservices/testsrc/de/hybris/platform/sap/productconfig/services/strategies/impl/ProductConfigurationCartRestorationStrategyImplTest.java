/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.strategies.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commerceservices.order.CommerceCartRestorationException;
import de.hybris.platform.commerceservices.order.CommerceCartRestorationStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.sap.productconfig.services.strategies.lifecycle.intf.ConfigurationSavedCartCleanUpStrategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ProductConfigurationCartRestorationStrategyImplTest
{

	@Mock
	private CommerceCartRestorationStrategy commerceCartRestorationStrategy;
	@Mock
	private ConfigurationSavedCartCleanUpStrategy cleanUpStrategy;

	@InjectMocks
	private ProductConfigurationCartRestorationStrategyImpl classUnderTest;

	private final CommerceCartParameter parameters = new CommerceCartParameter();


	@Test
	public void testRestoreCart() throws CommerceCartRestorationException
	{
		classUnderTest.restoreCart(parameters);
		verify(cleanUpStrategy).cleanUpCart();
		verify(commerceCartRestorationStrategy).restoreCart(parameters);
	}
}
