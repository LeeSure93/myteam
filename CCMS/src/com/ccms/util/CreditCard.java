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
public class CreditCard implements Serializable {

	/**
	 * 
	 */
	public static enum CREDITCARDSTATE {
		unActive, Active, lost, deleted
		// 未激活，已经激活，挂失，删除
	};

	private static final long serialVersionUID = 1L;
	private String CreditCardID;
	private String BankName;
	private Date CreateCreditCardTime;
	private String Password;
	private Date Deadline;
	private CREDITCARDSTATE Status;
	private String AccountID;

	/**
	 * 用来把信用卡从未激活状态转成激活状态
	 * 
	 * 其他情况一律返回false
	 * 
	 * @return
	 */
	public boolean Active() {
		if (Status == CREDITCARDSTATE.unActive) {
			setStatus(CREDITCARDSTATE.Active);
			return true;
		}

		return false;

	}

	/**
	 * 用来把信用卡从激活状态转成未激活，
	 * 
	 * 其余情况一律返回错误
	 * 
	 * @return
	 */
	public boolean Freeze() {
		if (Status == CREDITCARDSTATE.Active) {
			setStatus(CREDITCARDSTATE.unActive);
			return true;
		}
		return false;

	}

	/**
	 * 用来把信用从激活状态转成挂失态
	 * 
	 * 其他情况一律错误
	 * 
	 * @return
	 */
	public boolean Loss() {
		if (Status == CREDITCARDSTATE.Active) {
			setStatus(CREDITCARDSTATE.lost);
			return true;
		}
		return false;

	}

	/**
	 * 用来把信用从挂失状态转成激活
	 * 
	 * 其他情况一律错误
	 * 
	 * @return
	 */
	public boolean Find() {
		if (Status == CREDITCARDSTATE.lost) {
			setStatus(CREDITCARDSTATE.Active);
			return true;
		}
		return false;

	}

	/**
	 * 用来把信用卡从激活状态删除
	 * 
	 * @return
	 */
	public boolean Delete() {
		if (Status == CREDITCARDSTATE.Active) {
			setStatus(CREDITCARDSTATE.deleted);
			return true;
		}
		return false;

	}

	/**
	 * @return the CreditCardID
	 */
	public String getCreditCardID() {
		return CreditCardID;
	}

	/**
	 * @param CreditCardID
	 *            the CreditCardID to set
	 */
	public void setCreditCardID(String CreditCardID) {
		this.CreditCardID = CreditCardID;
	}

	/**
	 * @return the BankName
	 */
	public String getBankName() {
		return BankName;
	}

	/**
	 * @param BankName
	 *            the BankName to set
	 */
	public void setBankName(String BankName) {
		this.BankName = BankName;
	}

	/**
	 * @return the CreateCreditCardTime
	 */
	public Date getCreateCreditCardTime() {
		return CreateCreditCardTime;
	}

	/**
	 * @param CreateCreditCardTime
	 *            the CreateCreditCardTime to set
	 */
	public void setCreateCreditCardTime(Date CreateCreditCardTime) {
		this.CreateCreditCardTime = CreateCreditCardTime;
	}

	/**
	 * @return the Password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param Password
	 *            the Password to set
	 */
	public void setPassword(String Password) {
		this.Password = Password;
	}

	/**
	 * @return the Deadline
	 */
	public Date getDeadline() {
		return Deadline;
	}

	/**
	 * @param Deadline
	 *            the Deadline to set
	 */
	public void setDeadline(Date Deadline) {
		this.Deadline = Deadline;
	}

	/**
	 * @return the Status
	 */
	public CREDITCARDSTATE getStatus() {
		return Status;
	}

	/**
	 * @param Status
	 *            the Status to set
	 */
	public void setStatus(CREDITCARDSTATE Status) {
		this.Status = Status;
	}

	/**
	 * @return the AccountID
	 */
	public String getAccountID() {
		return AccountID;
	}

	/**
	 * @param AccountID
	 *            the AccountID to set
	 */
	public void setAccountID(String AccountID) {
		this.AccountID = AccountID;
	}
}
