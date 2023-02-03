/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package concerttours.data;

import java.io.Serializable;


import java.util.Objects;
/**
 * Data object representing Ticket Category
 */
public  class TicketCategoryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>TicketCategoryData.ticketCategory</code> property defined at extension <code>concerttours</code>. */
		
	private String ticketCategory;
	
	public TicketCategoryData()
	{
		// default constructor
	}
	
	public void setTicketCategory(final String ticketCategory)
	{
		this.ticketCategory = ticketCategory;
	}

	public String getTicketCategory() 
	{
		return ticketCategory;
	}
	

}