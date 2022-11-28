package com.example.demo1.servlet;

import com.example.demo1.model.Customer;
import com.example.demo1.service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerListServlet", value = "/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = CustomerService.customerList;

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/customer/Display.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
