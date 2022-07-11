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
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vobao
 */
public class ProductControllers extends HttpServlet {

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
        if (path.equals("/listing")) {
            try {
                String currentPageStr = request.getParameter("page");
                int currentPage = 1;
                int PRODUCT_PER_PAGE = 4;
                if (currentPageStr != null) {
                    currentPage = Integer.parseInt(currentPageStr);
                }

                ArrayList<Brand> brandList = brandManager.getBrandList();
                ArrayList<Category> categoryList = cateManager.getCategoryList();
                int productListSize = productManager.getProductListSize();
                int numberOfPages = 0;
                numberOfPages = (int) Math.ceil(productListSize * 1.0 / PRODUCT_PER_PAGE);
                ArrayList<Product> productList = productManager.getProductList(currentPage, PRODUCT_PER_PAGE);
                request.setAttribute("productListSize", productListSize);
                request.setAttribute("productList", productList);
                request.setAttribute("numberOfPages", numberOfPages);

                request.setAttribute("currentPage", currentPage);
                request.setAttribute("brandList", brandList);
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        if (path.equals("/search")) {
            try {

                String brand = request.getParameter("brand");
                String category = request.getParameter("category");
                String searchKey = request.getParameter("searchKey");

                String currentPageStr = request.getParameter("page");
                int currentPage = 1;
                int PRODUCT_PER_PAGE = 8;
                if (currentPageStr != null) {
                    currentPage = Integer.parseInt(currentPageStr);
                }

                ArrayList<Brand> brandList = brandManager.getBrandList();
                ArrayList<Category> categoryList = cateManager.getCategoryList();
                int productListSize = productManager.getProductListSize();
                int numberOfPages = 0;
                numberOfPages = (int) Math.ceil(productListSize * 1.0 / PRODUCT_PER_PAGE);
                ArrayList<Product> productList = productManager.getProductList(currentPage, PRODUCT_PER_PAGE);

                if (searchKey != null && searchKey != "") {
                    productList.clear();
                    productList = productManager.getProductBySearchString(searchKey, currentPage, PRODUCT_PER_PAGE);
                }
                if (category != null && category != "") {
                    productList.clear();
                    productList = productManager.getProductByBrandAndCategory(0, cateManager.getCategory(category).getId());
                }
                if (brand != null && brand != "") {
                    productList.clear();
                    productList = productManager.getProductByBrandAndCategory(brandManager.getBrand(brand).getId(), 0);
                }

                request.setAttribute("searchKey", searchKey);

                request.setAttribute("productListSize", productListSize);
                request.setAttribute("productList", productList);
                request.setAttribute("numberOfPages", numberOfPages);

                request.setAttribute("currentPage", currentPage);
                request.setAttribute("brandList", brandList);
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/pages/search.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }
        if (path.equals("/detail")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productManager.getProduct(id);
                ArrayList<Product> suggestList = new ArrayList<>();
                Brand productBrand = brandManager.getBrand(product.getBrandID());
                Category productCategory = cateManager.getCategory(product.getCategoryID());

                suggestList = productManager.getProductByBrandAndCategory(product.getBrandID(), product.getCategoryID());
                request.setAttribute("product", product);
                request.setAttribute("productBrand", productBrand);
                request.setAttribute("productCategory", productCategory);
                request.setAttribute("suggestList", suggestList);
                request.getRequestDispatcher("/pages/detail.jsp").forward(request, response);
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
