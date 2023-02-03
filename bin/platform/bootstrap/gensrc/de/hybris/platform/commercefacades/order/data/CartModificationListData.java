/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import java.util.List;


import java.util.Objects;
public  class CartModificationListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CartModificationListData.cartModifications</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private List<CartModificationData> cartModifications;
	
	public CartModificationListData()
	{
		// default constructor
	}
	
	public void setCartModifications(final List<CartModificationData> cartModifications)
	{
		this.cartModifications = cartModifications;
	}

	public List<CartModificationData> getCartModifications() 
	{
		return cartModifications;
	}
	

}