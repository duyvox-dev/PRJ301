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
public class ProductImage {
  int id;
  int productID;
  String path;

    public ProductImage(int id, int productID, String path) {
        this.id = id;
        this.productID = productID;
        this.path = path;
    }

    public ProductImage() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
  
  
    
}
