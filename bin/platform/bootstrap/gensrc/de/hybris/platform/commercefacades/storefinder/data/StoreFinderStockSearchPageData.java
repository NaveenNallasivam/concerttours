/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.storefinder.data;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.storefinder.data.StoreFinderSearchPageData;


import java.util.Objects;
public  class StoreFinderStockSearchPageData<RESULT> extends StoreFinderSearchPageData<RESULT> 
{

 

	/** <i>Generated property</i> for <code>StoreFinderStockSearchPageData<RESULT>.product</code> property defined at extension <code>commercefacades</code>. */
		
	private ProductData product;
	
	public StoreFinderStockSearchPageData()
	{
		// default constructor
	}
	
	public void setProduct(final ProductData product)
	{
		this.product = product;
	}

	public ProductData getProduct() 
	{
		return product;
	}
	

}