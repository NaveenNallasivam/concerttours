/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:25 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.accountsummaryaddon.document.data;

import java.io.Serializable;


import java.util.Objects;
public  class MediaData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaData.realFileName</code> property defined at extension <code>accountsummaryaddon</code>. */
		
	private String realFileName;

	/** <i>Generated property</i> for <code>MediaData.downloadURL</code> property defined at extension <code>accountsummaryaddon</code>. */
		
	private String downloadURL;
	
	public MediaData()
	{
		// default constructor
	}
	
	public void setRealFileName(final String realFileName)
	{
		this.realFileName = realFileName;
	}

	public String getRealFileName() 
	{
		return realFileName;
	}
	
	public void setDownloadURL(final String downloadURL)
	{
		this.downloadURL = downloadURL;
	}

	public String getDownloadURL() 
	{
		return downloadURL;
	}
	

}