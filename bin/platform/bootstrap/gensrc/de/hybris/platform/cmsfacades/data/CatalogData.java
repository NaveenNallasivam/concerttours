/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import de.hybris.platform.cmsfacades.data.CatalogVersionData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;


import java.util.Objects;
@ApiModel(value="CatalogData")
public  class CatalogData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CatalogData.catalogId</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="catalogId") 	
	private String catalogId;

	/** <i>Generated property</i> for <code>CatalogData.name</code> property defined at extension <code>cmsfacades</code>. */
	@ApiModelProperty(name="name") 	
	private Map<String, String> name;

	/** <i>Generated property</i> for <code>CatalogData.versions</code> property defined at extension <code>cmssmarteditwebservices</code>. */
	@ApiModelProperty(name="versions") 	
	private List<CatalogVersionData> versions;
	
	public CatalogData()
	{
		// default constructor
	}
	
	public void setCatalogId(final String catalogId)
	{
		this.catalogId = catalogId;
	}

	public String getCatalogId() 
	{
		return catalogId;
	}
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	
	public void setVersions(final List<CatalogVersionData> versions)
	{
		this.versions = versions;
	}

	public List<CatalogVersionData> getVersions() 
	{
		return versions;
	}
	

}