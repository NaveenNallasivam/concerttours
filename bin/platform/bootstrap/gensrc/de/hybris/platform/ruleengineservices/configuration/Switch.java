/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at 03-Feb-2023, 10:59:22 AM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.ruleengineservices.configuration;
 
public enum Switch   
{
	/** <i>Generated enum value</i> for <code>Switch.CONSUMPTION("ruleengineservices.consumption.enabled")</code> value defined at extension <code>ruleengineservices</code>. */
	CONSUMPTION("ruleengineservices.consumption.enabled")  , 
	/** <i>Generated enum value</i> for <code>Switch.GENERATOR_WEBSITEGROUP("promotionengineservices.generator.websitegroup.enabled")</code> value defined at extension <code>promotionengineservices</code>. */
	GENERATOR_WEBSITEGROUP("promotionengineservices.generator.websitegroup.enabled") ; 

    private final String value;

    Switch(final String value)
    {
        this.value = value;
    }

    /**
     * @deprecated since 1905
     */
    @Deprecated(since = "1905", forRemoval = true)
    public String getCode()
    {
        return toString();
    }

    public String getValue()
    {
        return value;
    }

    /**
     * @deprecated since 1905
     */
    @Deprecated(since = "1905", forRemoval = true)
    public String getOriginalCode()
    {
        return getValue();
    }

    /**
     * @deprecated since 1905
     */
    @Deprecated(since = "1905", forRemoval = true)
    public static Switch fromCode(final String code)
    {
        return fromValue(code);
    }

    public static Switch fromValue(final String value)
    {
        for (final Switch ev : values())
        {
            if (ev.getValue().equals(value))
            {
                return ev;
            }
        }

        throw new IllegalArgumentException("Unknown value \"" + value + "\"");
    }

}
