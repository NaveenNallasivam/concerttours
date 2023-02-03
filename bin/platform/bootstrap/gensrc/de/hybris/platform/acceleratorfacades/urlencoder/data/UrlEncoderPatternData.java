/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorfacades.urlencoder.data;

import java.io.Serializable;


import java.util.Objects;
public  class UrlEncoderPatternData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>UrlEncoderPatternData.pattern</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private String pattern;

	/** <i>Generated property</i> for <code>UrlEncoderPatternData.redirectRequired</code> property defined at extension <code>acceleratorfacades</code>. */
		
	private boolean redirectRequired;
	
	public UrlEncoderPatternData()
	{
		// default constructor
	}
	
	public void setPattern(final String pattern)
	{
		this.pattern = pattern;
	}

	public String getPattern() 
	{
		return pattern;
	}
	
	public void setRedirectRequired(final boolean redirectRequired)
	{
		this.redirectRequired = redirectRequired;
	}

	public boolean isRedirectRequired() 
	{
		return redirectRequired;
	}
	

}