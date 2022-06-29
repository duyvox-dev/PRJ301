/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.model;



/**
 *
 * @author voduy
 */
public class Order {
    int ProductID;
    int quantity;
    int sellerID;
    int buyerID;

    public Order() {
    }

    
    
    public Order(int ProductID, int quantity, int sellerID, int buyerID) {
        this.ProductID = ProductID;
        this.quantity = quantity;
        this.sellerID = sellerID;
        this.buyerID = buyerID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }
    
    
}
