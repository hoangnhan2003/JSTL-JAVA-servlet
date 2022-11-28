package com.example.btapmvc.controller;

import com.example.btapmvc.model.Product;
import com.example.btapmvc.service.IProductService;
import com.example.btapmvc.service.Impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController" , urlPatterns = "/productS")
public class productController extends HttpServlet {
    private IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "list";
        }
        switch(action){
            case "create":
                this.showCreate(req,resp);
                break;
            case "update":
                this.showUpdate(req,resp);
                break;
            case "list":
                this.showList(req,resp);
                break;
            case "delete":
                break;
            case"search":
                this.searchById(req,resp);
                break;
            default:

        }
    }

    private void searchById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = productService.findById(id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/product/search.jsp").forward(req,resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/product/create.jsp").forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList",productService.findAll());
        req.getRequestDispatcher("/product/list.jsp").forward(req,resp);
    }




    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/product/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null ){
            resp.sendRedirect("/product?action=list");
        }
        switch(action){
            case"add":
                this.showCreate(req,resp);
                break;
            case "create":
                this.doCreate(req,resp);
                break;
            case "update":
                this.showCreate(req,resp);
            case"delete":
                doDeleteItem(req,resp);
                break;
            case "list":
                display(req,resp);
                break;
            case"search":
                this.searchById(req,resp);
                break;
            default:
                display(req,resp);

        }
    }

    private void doDeleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("deleteItem");
        productService.deleteById(id);
        req.setAttribute("productList",productService.findAll());
        req.getRequestDispatcher("/product/list.jsp").forward(req,resp);
    }

    private void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/product/list.jsp");
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        String producer = req.getParameter("producer");
        Product newProduct = new Product(id,name,price,description,producer);
        this.productService.saveOrUpdate(newProduct);
        resp.sendRedirect("/productS");



    }
}
