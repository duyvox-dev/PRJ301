/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.controller;

import com.fptuni.prj301.assignment.laptopsgo.dbmanager.CartManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.OrderDetailManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.OrderManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.ProductManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.UserManager;
import com.fptuni.prj301.assignment.laptopsgo.model.Order;
import com.fptuni.prj301.assignment.laptopsgo.model.OrderDetail;
import com.fptuni.prj301.assignment.laptopsgo.model.Product;
import com.fptuni.prj301.assignment.laptopsgo.model.User;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vobao
 */
public class UserControllers extends HttpServlet {

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
        if (path.equals("/login")) {
            try {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if (username != null && password != null) {
                    UserManager userManager = new UserManager();
                    User user = userManager.getUser(username.trim(), password.trim());
                    if (user == null) {
                        request.setAttribute("loginErrorMsg", "Invalid username or password");
                    } else {

                        if (user.getBanStatus() == 0) {
                            // not banned yet
                            HttpSession httpSession = request.getSession(true);
                            httpSession.setAttribute("userSession", user);
                            response.sendRedirect(request.getContextPath() + "/");
                        } else {
                            request.setAttribute("loginErrorMsg", "Your account is banned");
                        }
                    }

                }
                request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (path.equals("/logout")) {
            try {
                HttpSession httpSession = request.getSession();
                httpSession.invalidate();
                response.sendRedirect(request.getContextPath() + "/");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (path.equals("/register")) {
            try {
                HashMap<String, String> errors = new HashMap<>();
                boolean hasError = false;
                String username = (request.getParameter("username")).trim();
                String password = (request.getParameter("password"));
                String confirmPassword = request.getParameter("confirm-password");
                String email = (request.getParameter("email")).trim();
                String fullName = (request.getParameter("fullname")).trim();
                String role = request.getParameter("role");
                if (username != null && password != null && confirmPassword != null && email != null && fullName != null) {
                    UserManager userManager = new UserManager();
                    if (!password.equals(confirmPassword)) {
                        errors.put("confirm-password", "password and confirm password do not match");
                        hasError = true;
                    }
                    if (userManager.checkUserByEmail(email) != null) {

                        errors.put("email", "This email is existed, please try another.");
                        hasError = true;
                    }
                    if (userManager.checkUserByUsername(username) != null) {

                        errors.put("username", "This username is existed, please try another.");
                        hasError = true;
                    }
                    if (!hasError) {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setBanStatus(0);
                        user.setEmail(email);
                        user.setRole(role);
                        user.setFullname(fullName);
                        boolean addUserSuccess = userManager.addUser(user);
                        if (addUserSuccess) {
                            response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                        }
                    }
                    request.setAttribute("errors", errors);
                    request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (path.equals("/buyHistory")) {
            try {
                ProductManager productManager = new ProductManager();
                CartManager cartManager = new CartManager();
                OrderManager orderManager = new OrderManager();
                OrderDetailManager orderDetailManager = new OrderDetailManager();
                HttpSession httpSession = request.getSession();

                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("buyer")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                // key contain order ID, arrayList contain list of product
                HashMap<Integer, ArrayList<Product>> orderDetailList = new HashMap<>();
                ArrayList<Order> orderList = new ArrayList<>();
                orderList = orderManager.getOrderListByBuyer(userSession.getId());
                for (int i = 0; i < orderList.size(); i++) {
                    Order order = orderList.get(i);
                    ArrayList<OrderDetail> orDetails = new ArrayList<>();
                    orDetails = orderDetailManager.getOrderDetail(order.getId());
                    ArrayList<Product> products = new ArrayList<>();

                    for (int j = 0; j < orDetails.size(); j++) {
                        OrderDetail orDetail = orDetails.get(j);
                        Product product = productManager.getProductBuyHistory(orDetail.getProductID());
                        product.setPrice(orDetail.getPrice());
                        products.add(product);
                    }
                    orderDetailList.put(order.getId(), products);
                }

                request.setAttribute("orderDetailList", orderDetailList);
                request.setAttribute("orderList", orderList);

                request.getRequestDispatcher("/buyer/buyHistory.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (path.equals("/profile")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");
                if (userSession == null) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }

                UserManager userManager = new UserManager();
                User userInfo = userManager.getNormalUserInfo(userSession.getUsername());
                request.setAttribute("userInfo", userInfo);
                request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (path.equals("/edit-profile")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                boolean hasError = false;
                String password = (request.getParameter("password"));
                String confirmPassword = request.getParameter("confirm-password");
                String fullName = (request.getParameter("fullname")).trim();
                String errors = "";
                String success = "";
                if (password != null && confirmPassword != null && fullName != null) {
                    UserManager userManager = new UserManager();
                    if (!password.equals(confirmPassword)) {
                        errors = "password and confirm password do not match";
                        hasError = true;
                    }
                    if (!hasError) {
                        User user = userManager.getNormalUserInfo(userSession.getUsername());
                        user.setPassword(password);
                        user.setFullname(fullName);
                        userManager.updateUser(user);
                        success = "Update successfully";
                    }
                    request.setAttribute("errors", errors);
                    request.setAttribute("success", success);

                    request.getRequestDispatcher("/User/profile").forward(request, response);

                }
            } catch (Exception e) {
                System.out.println(e);
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
