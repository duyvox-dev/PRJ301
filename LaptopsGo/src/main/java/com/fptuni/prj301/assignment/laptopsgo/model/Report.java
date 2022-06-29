/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.model;

import java.sql.Date;

/**
 *
 * @author voduy
 */
public class Report {
    int id;
    int reportedID;
    int productID;
    String content;

    public Report(int id, int reportedID, int productID, String content) {
        this.id = id;
        this.reportedID = reportedID;
        this.productID = productID;
        this.content = content;
    }

    public Report() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportedID() {
        return reportedID;
    }

    public void setReportedID(int reportedID) {
        this.reportedID = reportedID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
   
   
}
