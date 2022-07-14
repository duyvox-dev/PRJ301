/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.Category;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author voduy
 */
public class CategoryManager {

    public boolean insertCategory(Category cate) {
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO ProductCategory (name) VALUES ( ? )");
            ps.setString(1, cate.getName());
            
            int res = ps.executeUpdate();
            if (res >=0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int getSize() {
        Category cate = new Category();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductCategory");
            int count = 0;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            return count;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public ArrayList<Category> getCategoryList() {
        ArrayList<Category> cates = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductCategory");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cates.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
            return cates;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cates;
    }
    public HashMap<Integer, String> getCategoryListMap() {
        HashMap<Integer, String> categories = new HashMap<>();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductCategory");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.put(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
    public Category getCategory(int cateId) {
        Category gcate = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductCategory where id = ? ");
            ps.setInt(1, cateId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gcate = new Category();
                gcate.setId(rs.getInt("id"));
                gcate.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gcate;
    }

    public Category getCategory(String cateName) {
        Category gcate = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductCategory where name = ? ");
            ps.setString(1, cateName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gcate = new Category();
                gcate.setId(rs.getInt("id"));
                gcate.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gcate;
    }

    public boolean updateCategory(Category newCate) {
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Update ProductCategory Set name = ? where id = ?");
            ps.setString(1, newCate.getName());
            ps.setInt(2, newCate.getId());
            
            int res = ps.executeUpdate();
            if (res >= 0){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteCategory(int cateId) {
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete from ProductCategory where id = ?");
            ps.setInt(1, cateId);
            
            int res =ps.executeUpdate();
            if (res >= 0){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
