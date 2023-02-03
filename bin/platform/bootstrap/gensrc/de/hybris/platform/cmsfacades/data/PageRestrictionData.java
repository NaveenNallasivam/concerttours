/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;


import java.util.Objects;
public  class PageRestrictionData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageRestrictionData.pageId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String pageId;

	/** <i>Generated property</i> for <code>PageRestrictionData.restrictionId</code> property defined at extension <code>cmsfacades</code>. */
		
	private String restrictionId;
	
	public PageRestrictionData()
	{
		// default constructor
	}
	
	public void setPageId(final String pageId)
	{
		this.pageId = pageId;
	}

	public String getPageId() 
	{
		return pageId;
	}
	
	public void setRestrictionId(final String restrictionId)
	{
		this.restrictionId = restrictionId;
	}

	public String getRestrictionId() 
	{
		return restrictionId;
	}
	

}