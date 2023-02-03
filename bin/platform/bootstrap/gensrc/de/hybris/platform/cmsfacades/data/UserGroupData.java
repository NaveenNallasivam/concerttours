/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.data;

import java.io.Serializable;
import java.util.Map;


import java.util.Objects;
public  class UserGroupData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UserGroupData.uid</code> property defined at extension <code>cmsfacades</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>UserGroupData.name</code> property defined at extension <code>cmsfacades</code>. */
		
	private Map<String, String> name;
	
	public UserGroupData()
	{
		// default constructor
	}
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	
	public void setName(final Map<String, String> name)
	{
		this.name = name;
	}

	public Map<String, String> getName() 
	{
		return name;
	}
	

}