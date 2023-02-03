/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available uuid for CMS item.
 */
@ApiModel(value="CMSItemUuidListWsDTO", description="Specifies a list of available uuid for CMS item.")
public  class CMSItemUuidListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemUuidListWsDTO.uuids</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uuids") 	
	private List<String> uuids;
	
	public CMSItemUuidListWsDTO()
	{
		// default constructor
	}
	
	public void setUuids(final List<String> uuids)
	{
		this.uuids = uuids;
	}

	public List<String> getUuids() 
	{
		return uuids;
	}
	

}