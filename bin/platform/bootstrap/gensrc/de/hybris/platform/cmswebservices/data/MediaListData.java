/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:23 AM
 * ----------------------------------------------------------------
 *
 * Copyright (c) 2023 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmswebservices.data;

import java.io.Serializable;
import de.hybris.platform.cmswebservices.data.MediaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;


import java.util.Objects;
/**
 * Specifies a list of available media.
 */
@ApiModel(value="MediaListData", description="Specifies a list of available media.")
public  class MediaListData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>MediaListData.media</code> property defined at extension <code>cmswebservices</code>. */
	@ApiModelProperty(name="media") 	
	private List<MediaData> media;
	
	public MediaListData()
	{
		// default constructor
	}
	
	public void setMedia(final List<MediaData> media)
	{
		this.media = media;
	}

	public List<MediaData> getMedia() 
	{
		return media;
	}
	

}