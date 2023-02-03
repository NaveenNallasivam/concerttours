/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.services.populators;

import de.hybris.eventtracking.model.events.AbstractProductAndCartAwareTrackingEvent;
import de.hybris.eventtracking.model.events.AbstractTrackingEvent;
import de.hybris.eventtracking.services.constants.TrackingEventJsonFields;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author stevo.slavic
 *
 */
public class AbstractProductAndCartAwareTrackingEventPopulator extends AbstractTrackingEventGenericPopulator
{

	/**
	 *
	 */
	public AbstractProductAndCartAwareTrackingEventPopulator(final ObjectMapper mapper)
	{
		super(mapper);
	}

	/**
	 * @see de.hybris.eventtracking.services.populators.GenericPopulator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> clazz)
	{
		return AbstractProductAndCartAwareTrackingEvent.class.isAssignableFrom(clazz);
	}

	/**
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final Map<String, Object> trackingEventData, final AbstractTrackingEvent trackingEvent)
			throws ConversionException
	{
		final String cartId = (String) trackingEventData.get(TrackingEventJsonFields.COMMERCE_ORDER_ID.getKey());

		((AbstractProductAndCartAwareTrackingEvent) trackingEvent).setCartId(cartId);
	}

}