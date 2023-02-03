/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.12 at 07:19:30 PM EDT 
//



package org.cxml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "travelDetailOrFeeDetailOrLaborDetailOrExtrinsic"
})
@XmlRootElement(name = "SpendDetail")
public class SpendDetail {

    @XmlElements({
        @XmlElement(name = "TravelDetail", required = true, type = TravelDetail.class),
        @XmlElement(name = "FeeDetail", required = true, type = FeeDetail.class),
        @XmlElement(name = "LaborDetail", required = true, type = LaborDetail.class),
        @XmlElement(name = "Extrinsic", required = true, type = Extrinsic.class)
    })
    protected List<Object> travelDetailOrFeeDetailOrLaborDetailOrExtrinsic;

    /**
     * Gets the value of the travelDetailOrFeeDetailOrLaborDetailOrExtrinsic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the travelDetailOrFeeDetailOrLaborDetailOrExtrinsic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTravelDetailOrFeeDetailOrLaborDetailOrExtrinsic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TravelDetail }
     * {@link FeeDetail }
     * {@link LaborDetail }
     * {@link Extrinsic }
     * 
     * 
     */
    public List<Object> getTravelDetailOrFeeDetailOrLaborDetailOrExtrinsic() {
        if (travelDetailOrFeeDetailOrLaborDetailOrExtrinsic == null) {
            travelDetailOrFeeDetailOrLaborDetailOrExtrinsic = new ArrayList<Object>();
        }
        return this.travelDetailOrFeeDetailOrLaborDetailOrExtrinsic;
    }

}