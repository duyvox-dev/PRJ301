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
public class Product {

    private int id;
    private int categoryID;
    private int brandID;
    private int sellerID;
    private String name;
    private int price;
    private int description;
    private String imageURL;
    private int quantity;
    private int soldQuantity;
    private Date createdDate;
    private Date lastModefiedDate;

    public Product() {
    }

    public Product(int id, int categoryID, int brandID, int sellerID, String name, int price, int description, String imageURL, int quantity, int soldQuantity, Date createdDate, Date lastModefiedDate) {
        this.id = id;
        this.categoryID = categoryID;
        this.brandID = brandID;
        this.sellerID = sellerID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.createdDate = createdDate;
        this.lastModefiedDate = lastModefiedDate;
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

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModefiedDate() {
        return lastModefiedDate;
    }

    public void setLastModefiedDate(Date lastModefiedDate) {
        this.lastModefiedDate = lastModefiedDate;
    }

}
