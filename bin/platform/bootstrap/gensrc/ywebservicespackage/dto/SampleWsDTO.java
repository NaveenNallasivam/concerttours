/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Sample DTO
 */
@ApiModel(value="sample", description="Sample DTO")
public  class SampleWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** sample value<br/><br/><i>Generated property</i> for <code>SampleWsDTO.value</code> property defined at extension <code>ywebservices</code>. */
	@ApiModelProperty(name="value", value="sample value", required=true) 	
	private String value;
	
	public SampleWsDTO()
	{
		// default constructor
	}
	
	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	

}