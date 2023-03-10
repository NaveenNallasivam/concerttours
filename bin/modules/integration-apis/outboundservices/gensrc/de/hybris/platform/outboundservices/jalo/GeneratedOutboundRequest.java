/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 04-Dec-2022, 8:03:33 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundservices.jalo;

import de.hybris.platform.integrationservices.jalo.MonitoredRequest;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.outboundservices.constants.OutboundservicesConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem OutboundRequest}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedOutboundRequest extends MonitoredRequest
{
	/** Qualifier of the <code>OutboundRequest.destination</code> attribute **/
	public static final String DESTINATION = "destination";
	/** Qualifier of the <code>OutboundRequest.error</code> attribute **/
	public static final String ERROR = "error";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(MonitoredRequest.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(DESTINATION, AttributeMode.INITIAL);
		tmp.put(ERROR, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.destination</code> attribute.
	 * @return the destination
	 */
	public String getDestination(final SessionContext ctx)
	{
		return (String)getProperty( ctx, DESTINATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.destination</code> attribute.
	 * @return the destination
	 */
	public String getDestination()
	{
		return getDestination( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OutboundRequest.destination</code> attribute. 
	 * @param value the destination
	 */
	public void setDestination(final SessionContext ctx, final String value)
	{
		setProperty(ctx, DESTINATION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OutboundRequest.destination</code> attribute. 
	 * @param value the destination
	 */
	public void setDestination(final String value)
	{
		setDestination( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.error</code> attribute.
	 * @return the error
	 */
	public String getError(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ERROR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>OutboundRequest.error</code> attribute.
	 * @return the error
	 */
	public String getError()
	{
		return getError( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OutboundRequest.error</code> attribute. 
	 * @param value the error
	 */
	public void setError(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ERROR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>OutboundRequest.error</code> attribute. 
	 * @param value the error
	 */
	public void setError(final String value)
	{
		setError( getSession().getSessionContext(), value );
	}
	
}
