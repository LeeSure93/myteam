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
public class OperationList implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UserID;
    private String CostumerID;
    private Date OperationTime;
    private String Content;

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

    /**
     * @return the CostumerID
     */
    public String getCostumerID() {
        return CostumerID;
    }

    /**
     * @param CostumerID the CostumerID to set
     */
    public void setCostumerID(String CostumerID) {
        this.CostumerID = CostumerID;
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
