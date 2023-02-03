/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.sap.productconfig.frontend;

import java.io.Serializable;
import de.hybris.platform.sap.productconfig.frontend.UiPromoMessageStatus;
import java.util.List;


import java.util.Objects;
public  class UiCsticValueStatus  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UiCsticValueStatus.id</code> property defined at extension <code>ysapproductconfigaddon</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>UiCsticValueStatus.promoMessages</code> property defined at extension <code>ysapproductconfigaddon</code>. */
		
	private List<UiPromoMessageStatus> promoMessages;
	
	public UiCsticValueStatus()
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
	
	public void setPromoMessages(final List<UiPromoMessageStatus> promoMessages)
	{
		this.promoMessages = promoMessages;
	}

	public List<UiPromoMessageStatus> getPromoMessages() 
	{
		return promoMessages;
	}
	

}