/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:25 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;


import java.util.Objects;
public  class ConsignmentEntryData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>ConsignmentEntryData.orderEntry</code> property defined at extension <code>commercefacades</code>. */
		
	private OrderEntryData orderEntry;

	/** <i>Generated property</i> for <code>ConsignmentEntryData.quantity</code> property defined at extension <code>commercefacades</code>. */
		
	private Long quantity;

	/** <i>Generated property</i> for <code>ConsignmentEntryData.shippedQuantity</code> property defined at extension <code>commercefacades</code>. */
		
	private Long shippedQuantity;
	
	public ConsignmentEntryData()
	{
		// default constructor
	}
	
	public void setOrderEntry(final OrderEntryData orderEntry)
	{
		this.orderEntry = orderEntry;
	}

	public OrderEntryData getOrderEntry() 
	{
		return orderEntry;
	}
	
	public void setQuantity(final Long quantity)
	{
		this.quantity = quantity;
	}

	public Long getQuantity() 
	{
		return quantity;
	}
	
	public void setShippedQuantity(final Long shippedQuantity)
	{
		this.shippedQuantity = shippedQuantity;
	}

	public Long getShippedQuantity() 
	{
		return shippedQuantity;
	}
	

}