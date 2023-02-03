/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.PageTypeRestrictionTypeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available restriction types for a given page type.
 */
@ApiModel(value="PageTypeRestrictionTypeListData", description="Specifies a list of available restriction types for a given page type.")
public  class PageTypeRestrictionTypeListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PageTypeRestrictionTypeListData.pageTypeRestrictionTypeList</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="pageTypeRestrictionTypeList") 	
	private List<PageTypeRestrictionTypeData> pageTypeRestrictionTypeList;
	
	public PageTypeRestrictionTypeListData()
	{
		// default constructor
	}
	
	public void setPageTypeRestrictionTypeList(final List<PageTypeRestrictionTypeData> pageTypeRestrictionTypeList)
	{
		this.pageTypeRestrictionTypeList = pageTypeRestrictionTypeList;
	}

	public List<PageTypeRestrictionTypeData> getPageTypeRestrictionTypeList() 
	{
		return pageTypeRestrictionTypeList;
	}
	

}