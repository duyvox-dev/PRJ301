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
public class Cart {
    int buyerID;
    int productID;
    int quantity;

    public Cart(int buyerID, int productID, int quantity) {
        this.buyerID = buyerID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public Cart() {
    }

    
    
    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
