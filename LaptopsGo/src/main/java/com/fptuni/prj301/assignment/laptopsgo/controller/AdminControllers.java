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
            try {
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
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/category")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String errors = "";
                String success = "";
                String searchKey = request.getParameter("searchKey");
                ArrayList<Category> categories = new ArrayList<>();

                if (searchKey != null && !searchKey.equals("")) {
                    Category category = cateManager.getCategory(searchKey);
                    if (category != null) {
                        categories.add(category);
                    }
                } else {
                    categories = cateManager.getCategoryList();
                }
                request.setAttribute("searchKey", searchKey);

                request.setAttribute("errors", errors);
                request.setAttribute("success", success);
                request.setAttribute("categories", categories);

                request.getRequestDispatcher("/admin/categoryManagement.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/add-category")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String action = request.getParameter("action");
                String categoryIDStr = request.getParameter("categoryID");
                if (action != null && !action.equals("")) {
                    Category category = new Category();
                    if (action.equals("edit")) {
                        if (categoryIDStr != null && !categoryIDStr.equals("")) {
                            category = cateManager.getCategory(Integer.parseInt(categoryIDStr));
                        }
                    }
                    request.setAttribute("action", action);
                    request.setAttribute("category", category);
                    request.getRequestDispatcher("/admin/editCategory.jsp").forward(request, response);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/edit-category")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String action = request.getParameter("action");
                String idStr = request.getParameter("id");
                String name = request.getParameter("name");
                if (action != null && !action.equals("")) {

                    if (action.equals("create")) {
                        Category category = new Category();
                        category.setName(name);
                        cateManager.insertCategory(category);
                    } else if (action.equals("edit")) {
                        int id = Integer.parseInt(idStr);
                        Category category = cateManager.getCategory(id);
                        category.setName(name);
                        cateManager.updateCategory(category);
                    }
                    request.getRequestDispatcher("/Admin/category").forward(request, response);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/delete-category")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }

                String categoryIDStr = request.getParameter("categoryID");
                System.out.println("categoryIDStr");
                String errors = "";
                String success = "";
                if (categoryIDStr != null && !categoryIDStr.equals("")) {
                    int categoryID = Integer.parseInt(categoryIDStr);
                    if (cateManager.deleteCategory(categoryID)) {
                        success = "Delete category successfully";
                    } else {
                        errors = "Delete category fail";
                    }
                    request.setAttribute("errors", errors);
                    request.setAttribute("success", success);
                    request.getRequestDispatcher("/Admin/category").forward(request, response);

                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/product")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                
                ArrayList<Product> products = productManager.getProductList();
                HashMap<Integer, String> categories = cateManager.getCategoryListMap();
                HashMap<Integer, String> brands = brandManager.getBrandListMap();
                request.setAttribute("categories", categories);
                request.setAttribute("brands", brands);

                request.setAttribute("products", products);

                request.getRequestDispatcher("/admin/productManagement.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/delete-product")) {

            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String productIdstr = request.getParameter("productID");
                String error = "";
                String success = "";
                if (productIdstr != null && !productIdstr.equals("")) {
                    int productId = Integer.parseInt(productIdstr);
                    if (productManager.deleteProduct(productId)) {
                        success = "Delete successfully";
                    } else {
                        error = "Cant delete product";
                    }
                }
                request.setAttribute("success", success);
                request.setAttribute("error", error);

                request.getRequestDispatcher("/Admin/product").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (path.equals("/brand")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String errors = "";
                String success = "";
                String searchKey = request.getParameter("searchKey");
                ArrayList<Brand> brands = new ArrayList<>();

                if (searchKey != null && !searchKey.equals("")) {
                    Brand brand = brandManager.getBrand(searchKey);
                    if (brand != null) {
                        brands.add(brand);
                    }
                } else {
                    brands = brandManager.getBrandList();
                }
                request.setAttribute("searchKey", searchKey);

                request.setAttribute("errors", errors);
                request.setAttribute("success", success);
                request.setAttribute("brands", brands);
                request.getRequestDispatcher("/admin/brandManagement.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/add-brand")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String action = request.getParameter("action");
                String brandIDStr = request.getParameter("brandID");
                if (action != null && !action.equals("")) {
                    Brand brand = new Brand();
                    if (action.equals("edit")) {
                        if (brandIDStr != null && !brandIDStr.equals("")) {
                            brand = brandManager.getBrand(Integer.parseInt(brandIDStr));
                        }
                    }
                    request.setAttribute("action", action);
                    request.setAttribute("brand", brand);
                    request.getRequestDispatcher("/admin/editBrand.jsp").forward(request, response);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/edit-brand")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }
                String action = request.getParameter("action");
                String idStr = request.getParameter("id");
                String name = request.getParameter("name");
                String imageURL = request.getParameter("imageURL");
                if (action != null && !action.equals("")) {

                    if (action.equals("create")) {
                        Brand brand = new Brand();
                        brand.setName(name);
                        brand.setImageURL(imageURL);
                        brandManager.insertBrand(brand);
                    } else if (action.equals("edit")) {
                        int id = Integer.parseInt(idStr);
                        Brand brand = brandManager.getBrand(id);
                        brand.setImageURL(imageURL);
                        brand.setName(name);
                        brandManager.updateBrand(brand);
                    }
                    request.getRequestDispatcher("/Admin/brand").forward(request, response);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (path.equals("/delete-brand")) {
            try {
                HttpSession httpSession = request.getSession();
                User userSession = (User) httpSession.getAttribute("userSession");

                if (userSession == null || !userSession.getRole().equals("admin")) {
                    response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
                }

                String brandIDStr = request.getParameter("brandID");
                System.out.println("brandIDStr");
                String errors = "";
                String success = "";
                if (brandIDStr != null && !brandIDStr.equals("")) {
                    int brandID = Integer.parseInt(brandIDStr);
                    System.out.println(brandID);
                    if (brandManager.deleteBrand(brandID)) {
                        success = "Delete brand successfully";
                    } else {
                        errors = "Delete brand fail";
                    }
                    request.setAttribute("errors", errors);
                    request.setAttribute("success", success);
                    request.getRequestDispatcher("/Admin/brand").forward(request, response);

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
