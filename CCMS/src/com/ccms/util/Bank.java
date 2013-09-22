/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccms.util;

import java.io.Serializable;

/**
 *
 * @author hit-acm
 */
public class Bank implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String BankID;
    private String BankName;
    private String BankAddress;
    private String TelephoneNumber;

    /**
     * @return the BankID
     */
    public String getBankID() {
        return BankID;
    }

    /**
     * @param BankID the BankID to set
     */
    public void setBankID(String BankID) {
        this.BankID = BankID;
    }

    /**
     * @return the BankName
     */
    public String getBankName() {
        return BankName;
    }

    /**
     * @param BankName the BankName to set
     */
    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    /**
     * @return the BankAddress
     */
    public String getBankAddress() {
        return BankAddress;
    }

    /**
     * @param BankAddress the BankAddress to set
     */
    public void setBankAddress(String BankAddress) {
        this.BankAddress = BankAddress;
    }

    /**
     * @return the TelephoneNumber
     */
    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    /**
     * @param TelephoneNumber the TelephoneNumber to set
     */
    public void setTelephoneNumber(String TelephoneNumber) {
        this.TelephoneNumber = TelephoneNumber;
    }
}
