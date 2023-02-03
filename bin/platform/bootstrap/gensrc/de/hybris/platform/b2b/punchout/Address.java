/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:25 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout;

import java.io.Serializable;
import de.hybris.platform.b2b.punchout.PostalAddress;


import java.util.Objects;
public  class Address  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>Address.id</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>Address.name</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>Address.email</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String email;

	/** <i>Generated property</i> for <code>Address.phone</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String phone;

	/** <i>Generated property</i> for <code>Address.fax</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String fax;

	/** <i>Generated property</i> for <code>Address.postalAddress</code> property defined at extension <code>b2bpunchout</code>. */
		
	private PostalAddress postalAddress;
	
	public Address()
	{
		// default constructor
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
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
	
	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	
	public void setFax(final String fax)
	{
		this.fax = fax;
	}

	public String getFax() 
	{
		return fax;
	}
	
	public void setPostalAddress(final PostalAddress postalAddress)
	{
		this.postalAddress = postalAddress;
	}

	public PostalAddress getPostalAddress() 
	{
		return postalAddress;
	}
	

}