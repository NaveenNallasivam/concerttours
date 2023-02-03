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
 * Specifies a list of slot ids.
 */
@ApiModel(value="CMSContentSlotIdListWsDTO", description="Specifies a list of slot ids.")
public  class CMSContentSlotIdListWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSContentSlotIdListWsDTO.slotIds</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="slotIds", example="[\"Section1Slot-Homepage\", \"Section2Footer-Homepage\"]") 	
	private List<String> slotIds;
	
	public CMSContentSlotIdListWsDTO()
	{
		// default constructor
	}
	
	public void setSlotIds(final List<String> slotIds)
	{
		this.slotIds = slotIds;
	}

	public List<String> getSlotIds() 
	{
		return slotIds;
	}
	

}