/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:25 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.promotionengineservices.promotionengine.report.data;

import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.promotionengineservices.promotionengine.report.data.AbstractPromotionEngineResults;


import java.util.Objects;
public  class OrderLevelPromotionEngineResults extends AbstractPromotionEngineResults 
{

 

	/** <i>Generated property</i> for <code>OrderLevelPromotionEngineResults.order</code> property defined at extension <code>promotionengineservices</code>. */
		
	private AbstractOrderModel order;
	
	public OrderLevelPromotionEngineResults()
	{
		// default constructor
	}
	
	public void setOrder(final AbstractOrderModel order)
	{
		this.order = order;
	}

	public AbstractOrderModel getOrder() 
	{
		return order;
	}
	

}