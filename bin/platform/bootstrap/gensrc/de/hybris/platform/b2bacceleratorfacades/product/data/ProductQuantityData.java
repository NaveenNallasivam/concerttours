/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.product.data;

import java.io.Serializable;


import java.util.Objects;
public  class ProductQuantityData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ProductQuantityData.sku</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private String sku;

	/** <i>Generated property</i> for <code>ProductQuantityData.quantity</code> property defined at extension <code>b2bacceleratorfacades</code>. */
		
	private Integer quantity;
	
	public ProductQuantityData()
	{
		// default constructor
	}
	
	public void setSku(final String sku)
	{
		this.sku = sku;
	}

	public String getSku() 
	{
		return sku;
	}
	
	public void setQuantity(final Integer quantity)
	{
		this.quantity = quantity;
	}

	public Integer getQuantity() 
	{
		return quantity;
	}
	

}