/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.basesite.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.basesite.data.BaseSiteData;
import java.util.List;


import java.util.Objects;
public  class BaseSiteDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BaseSiteDataList.baseSites</code> property defined at extension <code>commercewebservices</code>. */
		
	private List<BaseSiteData> baseSites;
	
	public BaseSiteDataList()
	{
		// default constructor
	}
	
	public void setBaseSites(final List<BaseSiteData> baseSites)
	{
		this.baseSites = baseSites;
	}

	public List<BaseSiteData> getBaseSites() 
	{
		return baseSites;
	}
	

}