/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.strategies.impl;

import de.hybris.platform.commerceservices.order.CommerceCartRestoration;
import de.hybris.platform.commerceservices.order.CommerceCartRestorationException;
import de.hybris.platform.commerceservices.order.CommerceCartRestorationStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceCartParameter;
import de.hybris.platform.sap.productconfig.services.strategies.lifecycle.intf.ConfigurationSavedCartCleanUpStrategy;

import org.springframework.beans.factory.annotation.Required;


/**
 * CPQ implementation of {@link CommerceCartRestorationStrategy}. Takes care of releasing session artifacts
 */
public class ProductConfigurationCartRestorationStrategyImpl implements CommerceCartRestorationStrategy
{

	private CommerceCartRestorationStrategy commerceCartRestorationStrategy;
	private ConfigurationSavedCartCleanUpStrategy cleanUpStrategy;

	@Override
	public CommerceCartRestoration restoreCart(final CommerceCartParameter parameters) throws CommerceCartRestorationException
	{
		getCleanUpStrategy().cleanUpCart();
		return getCommerceCartRestorationStrategy().restoreCart(parameters);
	}

	protected CommerceCartRestorationStrategy getCommerceCartRestorationStrategy()
	{
		return commerceCartRestorationStrategy;
	}

	/**
	 * @param commerceCartRestorationStrategy
	 *           the commerceCartRestorationStrategy to set
	 */
	@Required
	public void setCommerceCartRestorationStrategy(final CommerceCartRestorationStrategy commerceCartRestorationStrategy)
	{
		this.commerceCartRestorationStrategy = commerceCartRestorationStrategy;
	}

	protected ConfigurationSavedCartCleanUpStrategy getCleanUpStrategy()
	{
		return cleanUpStrategy;
	}

	@Required
	/*
	 * sets clean up strategy to release session artifacts
	 */
	public void setCleanUpStrategy(final ConfigurationSavedCartCleanUpStrategy cleanUpStrategy)
	{
		this.cleanUpStrategy = cleanUpStrategy;
	}

}
