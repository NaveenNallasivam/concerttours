/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.servicelayer.event.events;

import java.io.Serializable;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;

public  class AfterSessionUserChangeEvent  extends AbstractEvent {


	/** <i>Generated property</i> for <code>AfterSessionUserChangeEvent.previousUserUID</code> property defined at extension <code>core</code>. */
		
	private String previousUserUID;
	
	public AfterSessionUserChangeEvent()
	{
		super();
	}

	public AfterSessionUserChangeEvent(final Serializable source)
	{
		super(source);
	}
	
	public void setPreviousUserUID(final String previousUserUID)
	{
		this.previousUserUID = previousUserUID;
	}

	public String getPreviousUserUID() 
	{
		return previousUserUID;
	}
	


}
