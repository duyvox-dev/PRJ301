/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.controller;

import com.fptuni.prj301.assignment.laptopsgo.dbmanager.BrandManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.CartManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.CategoryManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.ProductManager;
import com.fptuni.prj301.assignment.laptopsgo.model.Brand;
import com.fptuni.prj301.assignment.laptopsgo.model.Category;
import com.fptuni.prj301.assignment.laptopsgo.model.Product;
import com.fptuni.prj301.assignment.laptopsgo.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vobao
 */
public class SellerControllers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        BrandManager brandManager = new BrandManager();
        CategoryManager cateManager = new CategoryManager();
        ProductManager productManager = new ProductManager();
        CartManager cartManager = new CartManager();
        if (path.equals("/dashboard")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("seller")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                ArrayList<Product> products = productManager.getProductBySellerID(userSession.getId());
                HashMap<Integer, String> categories = cateManager.getCategoryListMap();
                HashMap<Integer, String> brands = brandManager.getBrandListMap();
                request.setAttribute("categories", categories);
                request.setAttribute("brands", brands);

                request.setAttribute("products", products);

                request.getRequestDispatcher("/seller/sellerDashboard.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (path.equals("/delete")) {
            String productIdstr = request.getParameter("productID");
            String error = "";
            String success = "";

            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");
                if (userSession == null || !userSession.getRole().equals("seller")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                if (productIdstr != null && !productIdstr.equals("")) {
                    int productId = Integer.parseInt(productIdstr);
                    Product product = productManager.getProduct(productId);
                    if (userSession.getId() != (product.getSellerID())) {
                        error = "You are trying to delete other seller's product";
                    } else if (productManager.deleteProduct(productId)) {
                        success = "Delete successfully";
                    } else {
                        error = "Cant delete product";
                    }
                }
                request.setAttribute("success", success);
                request.setAttribute("error", error);

                request.getRequestDispatcher("/Seller/dashboard").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (path.equals("/add")) {
            //            check role, only seller can add 
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");
            if (userSession == null || !userSession.getRole().equals("seller")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }
            String action = request.getParameter("action");
            String idStr = request.getParameter("productID");
            ArrayList<Category> categoryList = cateManager.getCategoryList();
            ArrayList<Brand> brandList = brandManager.getBrandList();

            if (action != null && !action.equals("")) {
                Product product = new Product();
                if (action.equals("edit")) {
                    if (idStr != null && !idStr.equals("")) {
                        product = productManager.getProduct(Integer.parseInt(idStr));
                    }
                }
                request.setAttribute("action", action);
                request.setAttribute("product", product);
                request.setAttribute("categoryList", categoryList);
                request.setAttribute("brandList", brandList);
                request.getRequestDispatcher("/seller/editProduct.jsp").forward(request, response);

            }
            response.sendRedirect("/Seller/dashboard");

        } else if (path.equals("/edit")) {
            try {
                //            check role, only seller can add 
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");
                if (userSession == null || !userSession.getRole().equals("seller")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);

                String action = request.getParameter("action");
                String idStr = request.getParameter("productID");
                String categoryIDStr = request.getParameter("categoryID");
                String name = request.getParameter("name");
                String brandIDStr = request.getParameter("brandID");
                String quantityStr = request.getParameter("quantity");
                String imageURL = request.getParameter("imageURL");
                String description = request.getParameter("description");
                String isNewStr = request.getParameter("isNew");
                String priceStr = request.getParameter("price");
                if (action != null && !action.equals("")
                        && categoryIDStr != null && !categoryIDStr.equals("")
                        && brandIDStr != null && !brandIDStr.equals("")
                        && quantityStr != null && !quantityStr.equals("")
                        && imageURL != null && !imageURL.equals("")
                        && description != null && !description.equals("")
                        && isNewStr != null && !isNewStr.equals("")
                        && priceStr != null && !priceStr.equals("")) {

                    int isNew = Integer.parseInt(isNewStr);
                    int categoryID = Integer.parseInt(categoryIDStr);

                    int brandID = Integer.parseInt(brandIDStr);

                    int quantity = Integer.parseInt(quantityStr);
                    double price = Double.parseDouble(priceStr);
                    String success = "";
                    String error = "";

                    if (action.equals("create")) {
                        Product product = new Product();
                        product.setName(name);
                        product.setSellerID(userSession.getId());
                        product.setCategoryID(categoryID);
                        product.setBrandID(brandID);
                        product.setQuantity(quantity);
                        product.setSoldQuantity(0);
                        product.setDescription(description);
                        product.setIsNew(isNew);
                        product.setDeleteStatus(0);
                        product.setPrice(price);
                        product.setImageURL(imageURL);

                        product.setCreatedDate(date);
                        product.setLastModefiedDate(date);
                        if (productManager.addProduct(product)) {
                            success = "Create product successfully";
                        } else {
                            error = "Fail to create product";
                        }

                    } else if (action.equals("edit")) {
                        int id = Integer.parseInt(idStr);
                        Product product = productManager.getProduct(id);
                        product.setName(name);
                        product.setCategoryID(categoryID);
                        product.setBrandID(brandID);
                        product.setQuantity(quantity);
                        product.setDescription(description);
                        product.setIsNew(isNew);
                        product.setImageURL(imageURL);
                        product.setLastModefiedDate(date);
                        product.setPrice(price);

                        if (productManager.updateProduct(product)) {
                            success = "Update product successfully";
                        } else {
                            error = "Fail to update product";
                        }
                    }
                    request.setAttribute("error", error);
                    request.setAttribute("success", success);
                    response.sendRedirect(request.getContextPath() + "/Seller/dashboard");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
