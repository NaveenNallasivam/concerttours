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
package de.hybris.platform.ruleengineservices.compiler;
 
public enum RuleIrAttributeOperator   
{
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.EQUAL("==")</code> value defined at extension <code>ruleengineservices</code>. */
	EQUAL("==")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.NOT_EQUAL("!=")</code> value defined at extension <code>ruleengineservices</code>. */
	NOT_EQUAL("!=")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.GREATER_THAN(">")</code> value defined at extension <code>ruleengineservices</code>. */
	GREATER_THAN(">")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.GREATER_THAN_OR_EQUAL(">=")</code> value defined at extension <code>ruleengineservices</code>. */
	GREATER_THAN_OR_EQUAL(">=")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.LESS_THAN("<")</code> value defined at extension <code>ruleengineservices</code>. */
	LESS_THAN("<")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.LESS_THAN_OR_EQUAL("<=")</code> value defined at extension <code>ruleengineservices</code>. */
	LESS_THAN_OR_EQUAL("<=")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.IN("in")</code> value defined at extension <code>ruleengineservices</code>. */
	IN("in")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.NOT_IN("not in")</code> value defined at extension <code>ruleengineservices</code>. */
	NOT_IN("not in")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.CONTAINS("contains")</code> value defined at extension <code>ruleengineservices</code>. */
	CONTAINS("contains")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.NOT_CONTAINS("not contains")</code> value defined at extension <code>ruleengineservices</code>. */
	NOT_CONTAINS("not contains")  , 
	/** <i>Generated enum value</i> for <code>RuleIrAttributeOperator.MEMBER_OF("memberOf")</code> value defined at extension <code>ruleengineservices</code>. */
	MEMBER_OF("memberOf") ; 

    private final String value;

    RuleIrAttributeOperator(final String value)
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
    public static RuleIrAttributeOperator fromCode(final String code)
    {
        return fromValue(code);
    }

    public static RuleIrAttributeOperator fromValue(final String value)
    {
        for (final RuleIrAttributeOperator ev : values())
        {
            if (ev.getValue().equals(value))
            {
                return ev;
            }
        }

        throw new IllegalArgumentException("Unknown value \"" + value + "\"");
    }

}
