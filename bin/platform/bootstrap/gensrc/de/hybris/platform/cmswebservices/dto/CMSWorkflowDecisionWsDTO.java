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


import java.util.Objects;
/**
 * Specifies properties of the CMS workflow decision.
 */
@ApiModel(value="CMSWorkflowDecisionWsDTO", description="Specifies properties of the CMS workflow decision.")
public  class CMSWorkflowDecisionWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.code</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="code", example="PageTranslationSendDEForReview") 	
	private String code;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.name</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="name", example="Send for Review") 	
	private String name;

	/** <i>Generated property</i> for <code>CMSWorkflowDecisionWsDTO.description</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="description", example="Decision for sending DE language for review") 	
	private String description;
	
	public CMSWorkflowDecisionWsDTO()
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
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	

}