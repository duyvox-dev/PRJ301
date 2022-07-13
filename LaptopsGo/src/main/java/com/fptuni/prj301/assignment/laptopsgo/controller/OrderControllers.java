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
import com.fptuni.prj301.assignment.laptopsgo.model.Cart;
import com.fptuni.prj301.assignment.laptopsgo.model.Order;
import com.fptuni.prj301.assignment.laptopsgo.model.Product;
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
public class OrderControllers extends HttpServlet {

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
        ProductManager productManager = new ProductManager();
        CartManager cartManager = new CartManager();
        OrderManager orderManager = new OrderManager();
        OrderDetailManager orderDetailManager = new OrderDetailManager();
        if (path.equals("/")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("buyer")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                ArrayList<Cart> carts = cartManager.getCartList(userSession.getId());
                ArrayList<Product> products = new ArrayList<>();
                double totalCost = 0;
                for (int i = 0; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    Product product = productManager.getProduct(cart.getProductID());
                    products.add(product);
                    totalCost += product.getPrice();
                }

                request.setAttribute("productList", products);
                request.setAttribute("totalCost", totalCost);
                request.getRequestDispatcher("/pages/checkout.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (path.equals("/purchase")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("buyer")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            ArrayList<Cart> carts = cartManager.getCartList(userSession.getId());
            ArrayList<Product> products = new ArrayList<>();
            double totalCost = 0;
            for (int i = 0; i < carts.size(); i++) {
                Cart cart = carts.get(i);
                Product product = productManager.getProduct(cart.getProductID());
                products.add(product);
                totalCost += product.getPrice();

            }
            if (address != null && email != null && phone != null) {
                orderManager.addOrder(userSession.getId(), address, phone, email, date, totalCost);
                Order order = orderManager.getLatestOrder(userSession.getId());
                for (int i = 0; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    Product product = productManager.getProduct(cart.getProductID());
                    orderDetailManager.addOrderDetail(order.getId(), product.getId(), product.getPrice());
                    product.setQuantity(product.getQuantity() - 1);
                    product.setSoldQuantity(product.getSoldQuantity() + 1);
                    productManager.updateProduct(product);

                }
                cartManager.deleteCart(userSession.getId());
            }

            request.getRequestDispatcher("/pages/checkout.jsp").forward(request, response);

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
