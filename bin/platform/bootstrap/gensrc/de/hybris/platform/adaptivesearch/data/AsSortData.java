/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.adaptivesearch.data;

import java.io.Serializable;


import java.util.Objects;
public  class AsSortData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AsSortData.code</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String code;

	/** <i>Generated property</i> for <code>AsSortData.name</code> property defined at extension <code>adaptivesearch</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>AsSortData.applyPromotedItems</code> property defined at extension <code>adaptivesearch</code>. */
		
	private boolean applyPromotedItems;

	/** <i>Generated property</i> for <code>AsSortData.highlightPromotedItems</code> property defined at extension <code>adaptivesearch</code>. */
		
	private boolean highlightPromotedItems;
	
	public AsSortData()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setApplyPromotedItems(final boolean applyPromotedItems)
	{
		this.applyPromotedItems = applyPromotedItems;
	}

	public boolean isApplyPromotedItems() 
	{
		return applyPromotedItems;
	}
	
	public void setHighlightPromotedItems(final boolean highlightPromotedItems)
	{
		this.highlightPromotedItems = highlightPromotedItems;
	}

	public boolean isHighlightPromotedItems() 
	{
		return highlightPromotedItems;
	}
	

}