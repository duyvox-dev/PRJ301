/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.Order;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author voduy
 */
public class OrderManager {

    public boolean addOrder(int buyerID, String address, String phone, String email, Date createdDate, double totalCost) {
        String sql = "INSERT INTO OrderHistory (buyerID, address, phone, email, createdDate, totalCost) values(?,?,?,?,?,?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, buyerID);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setDate(5, createdDate);
            ps.setDouble(6, totalCost);

            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public Order getLatestOrder(int buyerID){
        Order order = null;
        String sql = "select top 1 * from [OrderHistory] WHERE buyerID = ? order by id DESC";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, buyerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt("id"), rs.getInt("buyerId"), rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getDate("createdDate"), rs.getDouble("totalCost"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return order;
    }
    public ArrayList<Order> getOrderListByBuyer(int buyerId) {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "Select * from OrderHistory where buyerID = ? order by id DESC";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, buyerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id"), rs.getInt("buyerId"), rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getDate("createdDate"), rs.getDouble("totalCost")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }
}
