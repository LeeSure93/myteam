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
public class Log implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UserID;
    private Date OperationTime;
    private String Type;
    private String IsSuccefull;
    private String XID;//根据对应的操作存储对应关键的ID
	private String Content;
	
    public String getXID() {
		return XID;
	}

	public void setXID(String xID) {
		XID = xID;
	}

    
    /**
     * @return the UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getIsSuccefull() {
		return IsSuccefull;
	}

	public void setIsSuccefull(String isSuccefull) {
		IsSuccefull = isSuccefull;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    /**
     * @return the OperationTime
     */
    public Date getOperationTime() {
        return OperationTime;
    }

    /**
     * @param OperationTime the OperationTime to set
     */
    public void setOperationTime(Date OperationTime) {
        this.OperationTime = OperationTime;
    }

    /**
     * @return the Content
     */
    public String getContent() {
        return Content;
    }

    /**
     * @param Content the Content to set
     */
    public void setContent(String Content) {
        this.Content = Content;
    }


}
