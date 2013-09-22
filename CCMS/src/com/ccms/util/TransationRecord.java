/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccms.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hit-acm
 */
public class TransationRecord implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String TransationID;
    private Date TransationTime;
    private String CreditCardID;
    private Date AccountTime;
    private String TransationAmount;
    private String TransationAddress;
    private String TransationType;

    /**
     * @return the TransationID
     */
    public String getTransationID() {
        return TransationID;
    }

    /**
     * @param TransationID the TransationID to set
     */
    public void setTransationID(String TransationID) {
        this.TransationID = TransationID;
    }

    /**
     * @return the TransationTime
     */
    public Date getTransationTime() {
        return TransationTime;
    }

    /**
     * @param TransationTime the TransationTime to set
     */
    public void setTransationTime(Date TransationTime) {
        this.TransationTime = TransationTime;
    }

    /**
     * @return the CreditCardID
     */
    public String getCreditCardID() {
        return CreditCardID;
    }

    /**
     * @param CreditCardID the CreditCardID to set
     */
    public void setCreditCardID(String CreditCardID) {
        this.CreditCardID = CreditCardID;
    }

    /**
     * @return the AccountTime
     */
    public Date getAccountTime() {
        return AccountTime;
    }

    /**
     * @param AccountTime the AccountTime to set
     */
    public void setAccountTime(Date AccountTime) {
        this.AccountTime = AccountTime;
    }

    /**
     * @return the TransationAmount
     */
    public String getTransationAmount() {
        return TransationAmount;
    }

    /**
     * @param TransationAmount the TransationAmount to set
     */
    public void setTransationAmount(String TransationAmount) {
        this.TransationAmount = TransationAmount;
    }

    /**
     * @return the TransationAddress
     */
    public String getTransationAddress() {
        return TransationAddress;
    }

    /**
     * @param TransationAddress the TransationAddress to set
     */
    public void setTransationAddress(String TransationAddress) {
        this.TransationAddress = TransationAddress;
    }

    /**
     * @return the TransationType
     */
    public String getTransationType() {
        return TransationType;
    }

    /**
     * @param TransationType the TransationType to set
     */
    public void setTransationType(String TransationType) {
        this.TransationType = TransationType;
    }
}
