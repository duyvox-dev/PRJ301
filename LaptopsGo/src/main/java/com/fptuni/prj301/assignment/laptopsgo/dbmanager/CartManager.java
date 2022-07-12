/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.Cart;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author voduy
 */
public class CartManager {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public boolean insertCartItem(int buyerID, int productID) {
        try {
            String sql = "INSERT INTO [CartItem]  (buyerID, productID) VALUES(?,?)";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buyerID);
            pstm.setInt(2, productID);
            int res = pstm.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public ArrayList<Cart> getCartList(int buyerID) {
        ArrayList<Cart> carts = new ArrayList<>();
        String sql = "SELECT * from [CartItem] where buyerID  = ?";
        try {
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buyerID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setBuyerID(rs.getInt("buyerID"));
                cart.setId(rs.getInt("id"));
                cart.setProductID(rs.getInt("productID"));
                carts.add(cart);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return carts;
    }

    public boolean checkCartItem(int buyerID, int productID) {
        boolean isSucceed = false;
        try {
            String sql = "select productID from [CartItem] where buyerID = ? and productID = ?";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buyerID);
            pstm.setInt(2, productID);
            rs = pstm.executeQuery();
            if (rs.next()) {
                isSucceed = true;
            }
        } catch (Exception e) {
        }
        return isSucceed;
    }

    public boolean deleteCartItem(int buyerID, int productID) {
        boolean isSucceed = false;
        try {
            String sql = "delete from [CartItem] where buyerID = ? and productID = ?";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buyerID);
            pstm.setInt(2, productID);
            int affectedRow = pstm.executeUpdate();
            if (affectedRow != 0) {
                isSucceed = true;
            }
        } catch (Exception e) {
        }
        return isSucceed;
    }

    public boolean deleteCart(int buyerID) {
        boolean isSucceed = false;
        try {
            String sql = "delete from [CartItem] where buyerID = ?";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, buyerID);
            int affectedRow = pstm.executeUpdate();
            if (affectedRow != 0) {
                isSucceed = true;
            }
        } catch (Exception e) {
        }
        return isSucceed;
    }

    public boolean deleteCartByProduct(int productID) {
        boolean isSucceed = false;
        try {
            String sql = "delete from [CartItem] where productID = ?";
            conn = DBUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, productID);
            int affectedRow = pstm.executeUpdate();
            if (affectedRow != 0) {
                isSucceed = true;
            }
        } catch (Exception e) {
        }
        return isSucceed;
    }
}
