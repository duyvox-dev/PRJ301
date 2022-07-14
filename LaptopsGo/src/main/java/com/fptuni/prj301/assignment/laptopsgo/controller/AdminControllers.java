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
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.UserManager;
import com.fptuni.prj301.assignment.laptopsgo.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vobao
 */
public class AdminControllers extends HttpServlet {

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
        UserManager userManager = new UserManager();
        ProductManager productManager = new ProductManager();
        CartManager cartManager = new CartManager();
        if (path.equals("/user")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("admin")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }
            String errors = "";
            String success = "";
            String searchKey = request.getParameter("searchKey");
            String action = request.getParameter("action");
            String userIdStr = request.getParameter("userID");
            ArrayList<User> users = new ArrayList<>();

            if (action != null && !action.equals("")) {
                if (action.equals("ban")) {
                    int userId = Integer.parseInt(userIdStr);

                    if (userManager.banUser(userId)) {
                        success = "Ban user successfully";
                    } else {
                        errors = "Ban user fail!";
                    }
                }
            }
            if (searchKey != null && !searchKey.equals("")) {
                User user = userManager.getNormalUserInfo(searchKey);
                if (user != null) {
                    users.add(user);
                }
            } else {
                users = userManager.getUserList();
            }
                        request.setAttribute("searchKey", searchKey);

            request.setAttribute("errors", errors);
            request.setAttribute("success", success);
            request.setAttribute("users", users);
            request.getRequestDispatcher("/admin/userManagement.jsp").forward(request, response);
        } else if (path.equals("/brand")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("admin")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }

            request.getRequestDispatcher("/admin/brandManagement.jsp").forward(request, response);
        } else if (path.equals("/category")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("admin")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }

            request.getRequestDispatcher("/admin/categoryManagement.jsp").forward(request, response);
        } else if (path.equals("/product")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("admin")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }

            request.getRequestDispatcher("/admin/productManagement.jsp").forward(request, response);
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
