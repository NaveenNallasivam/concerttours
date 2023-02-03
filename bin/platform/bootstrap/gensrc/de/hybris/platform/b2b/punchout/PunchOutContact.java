/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout;

import java.io.Serializable;


import java.util.Objects;
public  class PunchOutContact  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PunchOutContact.name</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>PunchOutContact.email</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String email;

	/** <i>Generated property</i> for <code>PunchOutContact.role</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String role;
	
	public PunchOutContact()
	{
		// default constructor
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setRole(final String role)
	{
		this.role = role;
	}

	public String getRole() 
	{
		return role;
	}
	

}