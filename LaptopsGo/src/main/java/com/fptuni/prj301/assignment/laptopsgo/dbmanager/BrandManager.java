/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.Brand;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vobao
 */
public class BrandManager {
// add brand
    public boolean insertBrand(Brand brand) {
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO ProductBrand (name, imageURL) VALUES (?,?)");
            ps.setString(1, brand.getName());
            ps.setString(2, brand.getImageURL());
            
            int res = ps.executeUpdate();
            if (res >= 0){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
// get size    

    public int getSize() {
        Brand brand = new Brand();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductBrand");
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
// get all list brand

    public ArrayList<Brand> getBrandList() {
        ArrayList<Brand> brand = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductBrand");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                brand.add(new Brand(rs.getInt("id"), rs.getString("name"), rs.getString("imageURL")));
            }
            return brand;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }
// get brand by id

    public Brand getBrand(int brandId) {
        Brand gbrand = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductBrand where id = ? ");
            ps.setInt(1, brandId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gbrand = new Brand();
                gbrand.setId(rs.getInt("id"));
                gbrand.setName(rs.getString("name"));
                gbrand.setImageURL(rs.getString("imageURL"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gbrand;
    }
// get brand by name

    public Brand getBrand(String brandName) {
        Brand gbrand = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Select * from ProductBrand where name = ? ");
            ps.setString(1, brandName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gbrand = new Brand();
                gbrand.setId(rs.getInt("id"));
                gbrand.setName(rs.getString("name"));
                gbrand.setImageURL(rs.getString("imageURL"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gbrand;
    }
// update brand
    public boolean updateBrand(Brand newBrand){
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Update ProductBrand set name = ? and set ImageURL = ? WHERE id = ?");
            ps.setString(1, newBrand.getName());
            ps.setString(2, newBrand.getImageURL());
            ps.setInt(3, newBrand.getId());
            
            int res = ps.executeUpdate();
            if (res >= 0){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
// delete brand    
    public boolean deleteBrand(int brandId){
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete from ProductBrand where id = ?");
            ps.setInt(1, brandId);
            
            int res = ps.executeUpdate();
            if (res >= 0){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }    
}
