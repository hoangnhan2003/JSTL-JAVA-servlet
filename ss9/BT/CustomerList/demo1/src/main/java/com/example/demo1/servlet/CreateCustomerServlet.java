package com.example.demo1.servlet;

import com.example.demo1.model.Customer;
import com.example.demo1.service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "create",value = "/customer/create")

public class CreateCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/customer/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name  = request.getParameter("name");
        String bornDate = request.getParameter("bornDate");
        String address = request.getParameter("address");
        String imgUrl = request.getParameter("imgUrl");
        Customer customer = new Customer(name,bornDate,address,imgUrl);
        CustomerService.customerList.add(customer);
        request.setAttribute("customer",customer);
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h2>Test</h2>");
//        writer.println("</html>");
        request.getRequestDispatcher("/customer/create.jsp").forward(request,response);
    }
}

