package com.example.simplecaculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CaculatorServlet", urlPatterns = "/caculator")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
        String operator = request.getParameter("operator");
        request.setAttribute("num1",number1);
        request.setAttribute("num2",number2);
        request.setAttribute("operator",operator);
        request.setAttribute("sum",number1+number2);
        request.setAttribute("tru",number1-number2);
        request.getRequestDispatcher("/Caculator/display.jsp").forward(request,response);
    }
}
