/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:24 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercewebservices.core.product.data;

import java.io.Serializable;
import de.hybris.platform.commercefacades.product.data.SuggestionData;
import java.util.List;


import java.util.Objects;
public  class SuggestionDataList  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SuggestionDataList.suggestions</code> property defined at extension <code>commercewebservices</code>. */
		
	private List<SuggestionData> suggestions;
	
	public SuggestionDataList()
	{
		// default constructor
	}
	
	public void setSuggestions(final List<SuggestionData> suggestions)
	{
		this.suggestions = suggestions;
	}

	public List<SuggestionData> getSuggestions() 
	{
		return suggestions;
	}
	

}