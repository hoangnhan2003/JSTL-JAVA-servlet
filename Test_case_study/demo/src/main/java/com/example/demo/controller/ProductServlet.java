package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepo;
import com.example.demo.service.IProductService;
import com.example.demo.service.impl.CategoryService;
import com.example.demo.service.impl.ProductService;
import com.mysql.cj.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService;
    CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "list";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case"edit":
                showEdit(request,response);
                break;
            case"delete":
                removeProduct(request, response);
                break;
            default:
                showList(request,response);

        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);

    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productName = request.getParameter("productName");
        productService.deleteByProductName(productName);
        response.sendRedirect("/ProductServlet");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        Product product = productService.findByProductName(productName);
        List<Category> categoryList = categoryService.getAll();
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("product",product);
        request.getRequestDispatcher("/product/edit.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Category> categoryList = categoryService.getAll();
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case"create":
                doCreate(request,response);
                break;
            case"edit":
                doEdit(request,response);
                break;
            case"search":
                doSearch(request,response);
                break;

        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        List<Product> productList = productService.findAllProductName(productName);
        request.setAttribute("productList",productList);
        request.getRequestDispatcher("/product/list.jsp").forward(request,response);
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(productName,price,quantity,color,category);
        productService.updateProduct(product);
        response.sendRedirect("/ProductServlet");
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nameProduct = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String sCateId = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(sCateId);
        Category category = categoryService.findById(categoryId);
        Product product = new Product(nameProduct,price,quantity,color,category);
        String message = validate(nameProduct);
        Map<String, List<String>> mapErrors = new HashMap<>();
        if (!StringUtils.isNullOrEmpty(message)){

        }else {
            productService.insertProduct(product);
        }

        response.sendRedirect("/ProductServlet");

    }

    String validate(String name) {
        if (StringUtils.isNullOrEmpty(name)){
            return "Username required";
        }
        if (name.length() < 8){
            return "Name length must have 8 characters";
        }
        return "";
    }
}
