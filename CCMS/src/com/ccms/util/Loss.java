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
public class Loss implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String LossID;
    private String LossCostumer;
    private String CreditCardID;
    private Date LossDate;

    /**
     * @return the LossID
     */
    public String getLossID() {
        return LossID;
    }

    /**
     * @param LossID the LossID to set
     */
    public void setLossID(String LossID) {
        this.LossID = LossID;
    }

    /**
     * @return the LossCostumer
     */
    public String getLossCostumer() {
        return LossCostumer;
    }

    /**
     * @param LossCostumer the LossCostumer to set
     */
    public void setLossCostumer(String LossCostumer) {
        this.LossCostumer = LossCostumer;
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
     * @return the LossDate
     */
    public Date getLossDate() {
        return LossDate;
    }

    /**
     * @param LossDate the LossDate to set
     */
    public void setLossDate(Date LossDate) {
        this.LossDate = LossDate;
    }
}
