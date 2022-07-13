/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.prj301.assignment.laptopsgo.controller;

import com.fptuni.prj301.assignment.laptopsgo.dbmanager.CartManager;
import com.fptuni.prj301.assignment.laptopsgo.dbmanager.ProductManager;
import com.fptuni.prj301.assignment.laptopsgo.model.Cart;
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
public class CartControllers extends HttpServlet {

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

                request.getRequestDispatcher("/pages/cart.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (path.equals("/add")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("buyer")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }

            String productIDstr = request.getParameter("productID");
            if (productIDstr != null) {
                int productID = Integer.parseInt(productIDstr);
                Product product = productManager.getProduct(productID);
                if (product.getQuantity() > 0) {

                    // check cart and insert cart
                    if (!cartManager.checkCartItem(userSession.getId(), productID)) {
                        // insert new cart
                       cartManager.insertCartItem(userSession.getId(), productID);

                    }
                    response.sendRedirect(request.getContextPath() + "/Order/");

                } else {
                    request.setAttribute("error", "product sold out");
                    request.getRequestDispatcher(request.getContextPath() + "/Product/detail?id=" + productID).forward(request, response);;
                }
            }

        }
        if (path.equals("/delete")) {
            HttpSession httpSession = request.getSession();
            User userSession = (User) httpSession.getAttribute("userSession");

            if (userSession == null || !userSession.getRole().equals("buyer")) {
                response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
            }

            String productIDstr = request.getParameter("productID");
            if (productIDstr != null) {
                int productID = Integer.parseInt(productIDstr);
                cartManager.deleteCartByProduct(productID);

            }
            response.sendRedirect(request.getContextPath() + "/Cart/");

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
