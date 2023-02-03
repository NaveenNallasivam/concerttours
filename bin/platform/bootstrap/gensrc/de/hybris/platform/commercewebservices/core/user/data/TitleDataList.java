/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:26 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.user.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.user.data.TitleData;
import java.util.List;


import java.util.Objects;
public  class TitleDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TitleDataList.titles</code> property defined at extension <code>commercewebservices</code>. */
		
	private List<TitleData> titles;
	
	public TitleDataList()
	{
		// default constructor
	}
	
	public void setTitles(final List<TitleData> titles)
	{
		this.titles = titles;
	}

	public List<TitleData> getTitles() 
	{
		return titles;
	}
	

}