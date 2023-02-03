/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.punchout;

import java.io.Serializable;


import java.util.Objects;
public  class PostalAddress  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>PostalAddress.name</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>PostalAddress.deliverTo</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String deliverTo;

	/** <i>Generated property</i> for <code>PostalAddress.street</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String street;

	/** <i>Generated property</i> for <code>PostalAddress.city</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String city;

	/** <i>Generated property</i> for <code>PostalAddress.state</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String state;

	/** <i>Generated property</i> for <code>PostalAddress.postalCode</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String postalCode;

	/** <i>Generated property</i> for <code>PostalAddress.country</code> property defined at extension <code>b2bpunchout</code>. */
		
	private String country;
	
	public PostalAddress()
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
	
	public void setDeliverTo(final String deliverTo)
	{
		this.deliverTo = deliverTo;
	}

	public String getDeliverTo() 
	{
		return deliverTo;
	}
	
	public void setStreet(final String street)
	{
		this.street = street;
	}

	public String getStreet() 
	{
		return street;
	}
	
	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	
	public void setState(final String state)
	{
		this.state = state;
	}

	public String getState() 
	{
		return state;
	}
	
	public void setPostalCode(final String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getPostalCode() 
	{
		return postalCode;
	}
	
	public void setCountry(final String country)
	{
		this.country = country;
	}

	public String getCountry() 
	{
		return country;
	}
	

}