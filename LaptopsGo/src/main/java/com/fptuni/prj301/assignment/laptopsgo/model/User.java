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
public class User {
   private int id;
   private String username;
   private String password;
   private String email;
   private String fullname;
   private String role;
   private int banStatus;

    public User() {
    }

    public User(int id, String username, String password, String email, String fullname, String role, int banStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.banStatus = banStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getBanStatus() {
        return banStatus;
    }

    public void setBanStatus(int banStatus) {
        this.banStatus = banStatus;
    }
   
   

   

    
   
   
    
}
