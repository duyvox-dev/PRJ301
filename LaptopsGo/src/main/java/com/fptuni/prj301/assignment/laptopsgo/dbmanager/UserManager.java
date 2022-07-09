/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.User;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author voduy
 */
public class UserManager {


    public boolean addUser(User user) {
        String sql = "INSERT INTO [Users] (username, password, email, fullname, role) VALUES(?,?,?,?,?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            ps.setString(4, user.getFullname());
            ps.setString(5, user.getRole());
            int res = ps.executeUpdate();
            if (res >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(int userID) {
        String sql = "DELETE  FROM [Users] WHERE id = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);

            int res = ps.executeUpdate();
            if (res >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateUser(User newUser) {
        String sql = "UPDATE [Users] SET  fullname = ?, password = ? WHERE id = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newUser.getFullname());
            ps.setString(2, newUser.getPassword());
            ps.setInt(3, newUser.getId());

            int res = ps.executeUpdate();
            if (res >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

    public boolean banUser(int userID) {
        String sql = "UPDATE [Users] SET  banStatus = ? WHERE id = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, userID);

            int res = ps.executeUpdate();
            if (res >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

    public User getUser(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM [Users] WHERE username = ? AND password = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setBanStatus(rs.getInt("banStatus"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public int getUserListSize() {
        int count = 0;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("select COUNT(id) AS [size] from [Users]");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("size");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public ArrayList<User> getUserList(int page, int limit) {
        int low = (page - 1) * limit;
        int high = (page) * limit;

        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM [Users] ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, low);
            ps.setInt(2, high);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setBanStatus(rs.getInt("banStatus"));
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }

}
