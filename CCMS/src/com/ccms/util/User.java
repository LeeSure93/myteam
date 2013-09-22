/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccms.util;

import java.io.Serializable;

/**
 * 
 * @author magic282
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum USERTYPE {
		Common, Admin
	};
	
	public static enum USERSTATE{
		Online,Offline
	};

	private String UserID;
	private String UserName;
	private USERTYPE type;
	private String EmailAddress;
	private USERSTATE Status;
	private String BankID;
	private String Password;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the UserID
	 */
	public String getUserID() {
		return UserID;
	}

	/**
	 * @param UserID
	 *            the UserID to set
	 */
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

	/**
	 * @return the UserName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param UserName
	 *            the UserName to set
	 */
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}



	/**
	 * @return the EmailAddress
	 */
	public String getEmailAddress() {
		return EmailAddress;
	}

	/**
	 * @param EmailAddress
	 *            the EmailAddress to set
	 */
	public void setEmailAddress(String EmailAddress) {
		this.EmailAddress = EmailAddress;
	}

	/**
	 * @return the Status
	 */
	public USERSTATE getStatus() {
		return Status;
	}

	/**
	 * @param Status
	 *            the Status to set
	 */
	public void setStatus(USERSTATE Status) {
		this.Status = Status;
	}

	/**
	 * @return the BankID
	 */
	public String getBankID() {
		return BankID;
	}

	/**
	 * @param BankID
	 *            the BankID to set
	 */
	public void setBankID(String BankID) {
		this.BankID = BankID;
	}
	


	/**
	 * @return the type
	 */
	public USERTYPE getUserType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setUserType(USERTYPE type) {
		this.type = type;
	}

}
