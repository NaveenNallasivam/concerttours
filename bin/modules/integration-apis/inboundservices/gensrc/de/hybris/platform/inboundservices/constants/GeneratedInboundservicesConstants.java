/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 04-Dec-2022, 8:03:33 PM                     ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.inboundservices.constants;

/**
 * @deprecated since ages - use constants in Model classes instead
 */
@Deprecated(since = "ages", forRemoval = false)
@SuppressWarnings({"unused","cast"})
public class GeneratedInboundservicesConstants
{
	public static final String EXTENSIONNAME = "inboundservices";
	public static class TC
	{
		public static final String AUTHENTICATIONTYPE = "AuthenticationType".intern();
		public static final String INBOUNDCHANNELCONFIGURATION = "InboundChannelConfiguration".intern();
		public static final String INBOUNDREQUEST = "InboundRequest".intern();
		public static final String INBOUNDREQUESTERROR = "InboundRequestError".intern();
		public static final String INBOUNDREQUESTMEDIA = "InboundRequestMedia".intern();
		public static final String INTEGRATIONCLIENTCREDENTIALSDETAILS = "IntegrationClientCredentialsDetails".intern();
	}
	public static class Attributes
	{
		// no constants defined.
	}
	public static class Enumerations
	{
		public static class AuthenticationType
		{
			public static final String BASIC = "BASIC".intern();
			public static final String OAUTH = "OAUTH".intern();
		}
	}
	public static class Relations
	{
		public static final String INBOUNDREQUEST2INBOUNDREQUESTERROR = "InboundRequest2InboundRequestError".intern();
	}
	
	protected GeneratedInboundservicesConstants()
	{
		// private constructor
	}
	
	
}
