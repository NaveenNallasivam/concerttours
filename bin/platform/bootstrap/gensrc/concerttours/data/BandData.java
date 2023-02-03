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
import concerttours.data.TourSummaryData;
import java.util.List;


import java.util.Objects;
/**
 * Data object representing a Band
 */
public  class BandData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>BandData.id</code> property defined at extension <code>concerttours</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>BandData.name</code> property defined at extension <code>concerttours</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>BandData.description</code> property defined at extension <code>concerttours</code>. */
		
	private String description;

	/** <i>Generated property</i> for <code>BandData.albumsSold</code> property defined at extension <code>concerttours</code>. */
		
	private Long albumsSold;

	/** <i>Generated property</i> for <code>BandData.genres</code> property defined at extension <code>concerttours</code>. */
		
	private List<String> genres;

	/** <i>Generated property</i> for <code>BandData.tours</code> property defined at extension <code>concerttours</code>. */
		
	private List<TourSummaryData> tours;
	
	public BandData()
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
	
	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void setAlbumsSold(final Long albumsSold)
	{
		this.albumsSold = albumsSold;
	}

	public Long getAlbumsSold() 
	{
		return albumsSold;
	}
	
	public void setGenres(final List<String> genres)
	{
		this.genres = genres;
	}

	public List<String> getGenres() 
	{
		return genres;
	}
	
	public void setTours(final List<TourSummaryData> tours)
	{
		this.tours = tours;
	}

	public List<TourSummaryData> getTours() 
	{
		return tours;
	}
	

}