/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.runtime.interf.analytics.model;

import java.io.Serializable;


import java.util.Objects;
public  class AnalyticsContextEntry  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AnalyticsContextEntry.name</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>AnalyticsContextEntry.value</code> property defined at extension <code>sapproductconfigruntimeinterface</code>. */
		
	private String value;
	
	public AnalyticsContextEntry()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	

}