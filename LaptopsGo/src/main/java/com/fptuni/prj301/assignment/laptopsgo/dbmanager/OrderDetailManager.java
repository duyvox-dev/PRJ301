package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.OrderDetail;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vobao
 */
public class OrderDetailManager {

    public boolean addOrderDetail(int orderID, int productID, double price) {
        String sql = "INSERT INTO OrderDetail (orderID, productID, price) values(?,?,?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            ps.setDouble(3, price);
            System.out.println(orderID + " " + productID + " " + price);
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<OrderDetail> getOrderDetail(int orderID) {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        String sql = "SELECT *  FROM OrderDetail WHERE orderID = ?";

        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderDetails.add(new OrderDetail(rs.getInt("orderID"), rs.getInt("productID"), rs.getDouble("price")));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return orderDetails;
    }
}
