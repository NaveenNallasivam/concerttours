/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:25 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.runtime.interf.analytics.model;

import java.io.Serializable;


import java.util.Objects;
public  class AnalyticsPopularityIndicator  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AnalyticsPopularityIndicator.type</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
		
	private String type;

	/** <i>Generated property</i> for <code>AnalyticsPopularityIndicator.value</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
		
	private Double value;
	
	public AnalyticsPopularityIndicator()
	{
		// default constructor
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setValue(final Double value)
	{
		this.value = value;
	}

	public Double getValue() 
	{
		return value;
	}
	

}