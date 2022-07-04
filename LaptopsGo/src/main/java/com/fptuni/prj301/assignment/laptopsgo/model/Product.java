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
public class Product {
   int id;
   int categoryID;
   int brandID;
   int sellerID;
   String name;
   int price;
   String createdDate;
   String description;
   String lastModefiedDate;
   int quantity;
   int soldQuantity;

    public Product(int id, int categoryID, int brandID, int sellerID, String name, int price, String createdDate, String description, String lastModefiedDate, int quantity, int soldQuantity) {
        this.id = id;
        this.categoryID = categoryID;
        this.brandID = brandID;
        this.sellerID = sellerID;
        this.name = name;
        this.price = price;
        this.createdDate = createdDate;
        this.description = description;
        this.lastModefiedDate = lastModefiedDate;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
    }

    public Product() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastModefiedDate() {
        return lastModefiedDate;
    }

    public void setLastModefiedDate(String lastModefiedDate) {
        this.lastModefiedDate = lastModefiedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
   
   
}
