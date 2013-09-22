/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccms.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author magic282
 */
public class Account implements Serializable{
	
	public static enum ACCOUNTSTATE{
		normal,deleted,overdraft
		//正常状态，已经销户，透支
	};

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String AccountID;
    private Date CreateAccountTime;
    private String BankName;
    private String CostumerID;
    private String Money;
    private String CreditLine;//信用额度
    /**
	 * @return the creditLine
	 */
	public String getCreditLine() {
		return CreditLine;
	}

	/**
	 * @param creditLine the creditLine to set
	 */
	public void setCreditLine(String creditLine) {
		CreditLine = creditLine;
	}

	private ACCOUNTSTATE status;
    
    /**
	 * @return the status
	 */
	public ACCOUNTSTATE getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ACCOUNTSTATE status) {
		this.status = status;
	}

	/**
	 * @return the money
	 */
	public String getMoney() {
		return Money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(String money) {
		this.Money = money;
	}

	/**
	 * 
	 */
	public Account() {
		
	}
	
	/**
	 * @return the accountID
	 */
	public String getAccountID() {
		return AccountID;
	}
	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	/**
	 * @return the createAccountTime
	 */
	public Date getCreateAccountTime() {
		return CreateAccountTime;
	}
	/**
	 * @param createAccountTime the createAccountTime to set
	 */
	public void setCreateAccountTime(Date createAccountTime) {
		CreateAccountTime = createAccountTime;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return BankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	/**
	 * @return the costumerID
	 */
	public String getCostumerID() {
		return CostumerID;
	}
	/**
	 * @param costumerID the costumerID to set
	 */
	public void setCostumerID(String costumerID) {
		CostumerID = costumerID;
	}


}
