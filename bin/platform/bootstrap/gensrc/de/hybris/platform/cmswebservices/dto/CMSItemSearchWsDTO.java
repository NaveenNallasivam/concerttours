/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
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
 * Specifies properties of the cms item search.
 */
@ApiModel(value="CMSItemSearchWsDTO", description="Specifies properties of the cms item search.")
public  class CMSItemSearchWsDTO  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.mask</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="mask") 	
	private String mask;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.typeCode</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="typeCode", example="CMSParagraphComponent") 	
	private String typeCode;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.typeCodes</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="typeCodes", example="[\"CMSParagraphComponent\", \"CMSLinkComponent\"]") 	
	private String typeCodes;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.catalogId</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogId", example="electronicsContentCatalog") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.catalogVersion</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="catalogVersion", example="Staged") 	
	private String catalogVersion;

	/** <i>Generated property</i> for <code>CMSItemSearchWsDTO.itemSearchParams</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="itemSearchParams") 	
	private String itemSearchParams;
	
	public CMSItemSearchWsDTO()
	{
		// default constructor
	}
	
	public void setMask(final String mask)
	{
		this.mask = mask;
	}

	public String getMask() 
	{
		return mask;
	}
	
	public void setTypeCode(final String typeCode)
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	
	public void setTypeCodes(final String typeCodes)
	{
		this.typeCodes = typeCodes;
	}

	public String getTypeCodes() 
	{
		return typeCodes;
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setCatalogVersion(final String catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	public String getCatalogVersion() 
	{
		return catalogVersion;
	}
	
	public void setItemSearchParams(final String itemSearchParams)
	{
		this.itemSearchParams = itemSearchParams;
	}

	public String getItemSearchParams() 
	{
		return itemSearchParams;
	}
	

}