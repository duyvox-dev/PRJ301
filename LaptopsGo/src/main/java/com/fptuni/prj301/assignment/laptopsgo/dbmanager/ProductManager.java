/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.dbmanager;

import com.fptuni.prj301.assignment.laptopsgo.model.Product;
import com.fptuni.prj301.assignment.laptopsgo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author voduy
 */
public class ProductManager {
//       private int id;
//   private int categoryID;
//   private int brandID;
//   private int sellerID;
//   private String name;
//   private double price;
//   private String description;
//   private String imageURL;
//   private int quantity;
//   private int soldQuantity;
//   private Date createdDate;
//   private Date lastModefiedDate;
//   private int isNew;
//   private int deleteStatus;

    public boolean addProduct(Product product) {
        String sql = "INSERT INTO [Product] (categoryID, brandID, sellerID, name, price, description, imageURL, quantity, soldQuantity, createdDate, lastModefiedDate, isNew) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, product.getCategoryID());
            ps.setInt(2, product.getBrandID());
            ps.setInt(3, product.getSellerID());
            ps.setString(4, product.getName());
            ps.setDouble(5, product.getPrice());
            ps.setString(6, product.getDescription());
            ps.setString(7, product.getImageURL());
            ps.setInt(8, product.getQuantity());
            ps.setInt(9, product.getSoldQuantity());
            ps.setDate(10, product.getCreatedDate());
            ps.setDate(11, product.getLastModefiedDate());
            ps.setInt(12, product.getIsNew());

            int res = ps.executeUpdate();
            if (res >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteProduct(int productID) {
        String sql = "UPDATE [Product] SET deleteStatus = ?, quantity = ? WHERE id = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, 0);
            ps.setInt(3, productID);

            int res = ps.executeUpdate();
            if (res >= 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateProduct(Product newProduct) {
        System.out.println(newProduct.getId());
        String sql = "UPDATE [Product] SET  categoryID = ? , brandID = ?, name = ?, price = ?, description = ? , imageURL = ? , quantity = ?, soldQuantity= ?, createdDate = ?, lastModefiedDate = ?, isNew = ? WHERE id = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, newProduct.getCategoryID());
            ps.setInt(2, newProduct.getBrandID());
            ps.setString(3, newProduct.getName());
            ps.setDouble(4, newProduct.getPrice());
            ps.setString(5, newProduct.getDescription());
            ps.setString(6, newProduct.getImageURL());
            ps.setInt(7, newProduct.getQuantity());
            ps.setInt(8, newProduct.getSoldQuantity());
            ps.setDate(9, newProduct.getCreatedDate());
            ps.setDate(10, newProduct.getLastModefiedDate());
            ps.setInt(11, newProduct.getIsNew());
            ps.setInt(12, newProduct.getId());
            int res = ps.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

    public ArrayList<Product> getProductBySellerID(int sellerID) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM [Product] WHERE sellerID = ? and deleteStatus = 0";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sellerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    public ArrayList<Product> getProductList() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM [Product] WHERE deleteStatus = 0";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    public int getProductListSizeBySellerID(int sellerID) {
        int count = 0;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("select COUNT(id) AS [size] from [Product] WHERE sellerID = ? and deleteStatus = 0");
            ps.setInt(1, sellerID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("size");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return count;
    }

    public ArrayList<Product> getProductByBrandAndCategory(int brandID, int categoryID) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM [Product] WHERE (brandID = ? OR categoryID = ?) AND deleteStatus = 0";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, brandID);
            ps.setInt(2, categoryID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    public ArrayList<Product> getProductBySearchString(String searchKey, int page, int limit) {
        int low = (page - 1) * limit;
        int high = limit;

        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM [Product] WHERE name like ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            String processedKey = "%" + searchKey + "%";
            ps.setString(1, processedKey);

            ps.setInt(2, low);
            ps.setInt(3, high);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    public ArrayList<Product> getProductList(String sql) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    public int getProductListSize() {
        int count = 0;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement("select COUNT(id) AS [size] from [Product]");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("size");
            }
        } catch (Exception e) {
            System.out.println(e);

        }

        return count;
    }

    public ArrayList<Product> getProductList(int page, int limit) {
        int low = (page - 1) * limit;
        int high = limit;

        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM [Product] ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, low);
            ps.setInt(2, high);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    public Product getProduct(int id) {
        String sql = "SELECT * FROM [Product] WHERE id = ?";
        Product product = null;
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setBrandID(rs.getInt("brandID"));
                product.setCategoryID(rs.getInt("categoryID"));
                product.setSellerID(rs.getInt("sellerID"));
                product.setPrice(rs.getDouble("price"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageURL(rs.getString("imageURL"));
                product.setQuantity(rs.getInt("quantity"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setCreatedDate(rs.getDate("createdDate"));
                product.setLastModefiedDate(rs.getDate("lastModefiedDate"));
                product.setIsNew(rs.getInt("isNew"));
                product.setDeleteStatus(rs.getInt("deleteStatus"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return product;
    }
}
