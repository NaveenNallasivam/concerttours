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
import java.util.List;


import java.util.Objects;
public  class SynchronizationData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SynchronizationData.items</code> property defined at extension <code>cmsfacades</code>. */
		
	private List<ItemSynchronizationData> items;
	
	public SynchronizationData()
	{
		// default constructor
	}
	
	public void setItems(final List<ItemSynchronizationData> items)
	{
		this.items = items;
	}

	public List<ItemSynchronizationData> getItems() 
	{
		return items;
	}
	

}