/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.personalizationservices.trigger.expression;

import java.io.Serializable;
import java.util.Collection;


import java.util.Objects;
public  class CxExpressionContext  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CxExpressionContext.segments</code> property defined at extension <code>personalizationservices</code>. */
		
	private Collection<String> segments;
	
	public CxExpressionContext()
	{
		// default constructor
	}
	
	public void setSegments(final Collection<String> segments)
	{
		this.segments = segments;
	}

	public Collection<String> getSegments() 
	{
		return segments;
	}
	

}