/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package ywebservicespackage.data;

import java.io.Serializable;
import java.util.List;
import ywebservicespackage.data.AddressData;


import java.util.Objects;
public  class AddressDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>AddressDataList.addresses</code> property defined at extension <code>ywebservices</code>. */
		
	private List<AddressData> addresses;
	
	public AddressDataList()
	{
		// default constructor
	}
	
	public void setAddresses(final List<AddressData> addresses)
	{
		this.addresses = addresses;
	}

	public List<AddressData> getAddresses() 
	{
		return addresses;
	}
	

}