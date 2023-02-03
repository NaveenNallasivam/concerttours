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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available uids.
 */
@ApiModel(value="UidListData", description="Specifies a list of available uids.")
public  class UidListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UidListData.uids</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="uids") 	
	private List<String> uids;
	
	public UidListData()
	{
		// default constructor
	}
	
	public void setUids(final List<String> uids)
	{
		this.uids = uids;
	}

	public List<String> getUids() 
	{
		return uids;
	}
	

}