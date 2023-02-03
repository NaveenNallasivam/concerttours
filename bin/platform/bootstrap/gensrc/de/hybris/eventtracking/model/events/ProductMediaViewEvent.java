/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.eventtracking.model.events;

import java.io.Serializable;

import de.hybris.eventtracking.model.events.AbstractProductAwareTrackingEvent;

public  class ProductMediaViewEvent extends AbstractProductAwareTrackingEvent {


	/** <i>Generated property</i> for <code>ProductMediaViewEvent.productMediaType</code> property defined at extension <code>eventtrackingmodel</code>. */
		
	private String productMediaType;
	
	public ProductMediaViewEvent()
	{
		super();
	}

	public ProductMediaViewEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setProductMediaType(final String productMediaType)
	{
		this.productMediaType = productMediaType;
	}

	public String getProductMediaType() 
	{
		return productMediaType;
	}
	


}
