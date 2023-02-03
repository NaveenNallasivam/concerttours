/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
/**
 * Specifies properties of the workflow template.
 */
@ApiModel(value="WorkflowTemplateWsDTO", description="Specifies properties of the workflow template.")
public  class WorkflowTemplateWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>WorkflowTemplateWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="code", example="000000RS") 	
	private String code;

	/** <i>Generated property</i> for <code>WorkflowTemplateWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="name", example="Page Translation") 	
	private String name;
	
	public WorkflowTemplateWsDTO()
	{
		// default constructor
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	

}