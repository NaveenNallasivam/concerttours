/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmssmarteditwebservices.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.util.Objects;
@ApiModel(value="CMSWorkflowAttachmentData")
public  class CMSWorkflowAttachmentData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.pageUid</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="pageUid") 	
	private String pageUid;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.pageName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="pageName") 	
	private String pageName;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogId</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogName</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="catalogName") 	
	private String catalogName;

	/** <i>Generated property</i> for <code>CMSWorkflowAttachmentData.catalogVersion</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="catalogVersion") 	
	private String catalogVersion;
	
	public CMSWorkflowAttachmentData()
	{
		// default constructor
	}
	
	public void setPageUid(final String pageUid)
	{
		this.pageUid = pageUid;
	}

	public String getPageUid() 
	{
		return pageUid;
	}
	
	public void setPageName(final String pageName)
	{
		this.pageName = pageName;
	}

	public String getPageName() 
	{
		return pageName;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogName(final String catalogName)
	{
		this.catalogName = catalogName;
	}

	public String getCatalogName() 
	{
		return catalogName;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	

}