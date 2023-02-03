/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.catalog.data;

import de.hybris.platform.commercefacades.catalog.data.AbstractCatalogItemData;
import de.hybris.platform.commercefacades.catalog.data.CategoryHierarchyData;
import java.util.Collection;


import java.util.Objects;
public  class CatalogVersionData extends AbstractCatalogItemData 
{

 

	/** <i>Generated property</i> for <code>CatalogVersionData.categoriesHierarchyData</code> property defined at extension <code>commercefacades</code>. */
		
	private Collection<CategoryHierarchyData> categoriesHierarchyData;
	
	public CatalogVersionData()
	{
		// default constructor
	}
	
	public void setCategoriesHierarchyData(final Collection<CategoryHierarchyData> categoriesHierarchyData)
	{
		this.categoriesHierarchyData = categoriesHierarchyData;
	}

	public Collection<CategoryHierarchyData> getCategoriesHierarchyData() 
	{
		return categoriesHierarchyData;
	}
	

}