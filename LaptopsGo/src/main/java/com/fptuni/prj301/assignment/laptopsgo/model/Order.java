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
public class Order {
    private int id;
    private int buyerID;
    private String address;
    private String phone;
    private String email;
    private Date createdDate;
    private long totalCost;

    public Order() {
    }

    public Order(int id, int buyerID, String address, String phone, String email, Date createdDate, long totalCost) {
        this.id = id;
        this.buyerID = buyerID;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createdDate = createdDate;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
    
    
    
    
    
}
