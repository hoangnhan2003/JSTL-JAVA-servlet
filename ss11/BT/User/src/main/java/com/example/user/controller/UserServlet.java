package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case"create":
                showCreate(request,response);
                break;
            case"update":
                showUpdate(request,response);
                break;
            case"delete":
                deleteUser(request,response);
                break;
            case"sort":
                sortList(request,response);
                break;
            case"permission":
                addUserPermission(request,response);
                break;
            case"test-without-tran":
                testWithoutTran(request,response);
                break;
            case"test-with-tran":
                testWithTran(request,response);
                break;
            case"display-by-procedure":
                displayWithProcedure(request,response);
                break;
            case"delete-by-procedure":
                deleteByProcedure(request,response);
                break;

            default:
                showList(request,response);
        }
    }

    private void updateByProcedure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        userService.updateUserByProcedure(user);
        response.sendRedirect("/UserServlet");
    }

    private void deleteByProcedure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUserByProcedure(id);
        response.sendRedirect("/UserServlet");
    }

    private void displayWithProcedure(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList =userService.displayUsersByProcedure();
        request.setAttribute("userList",userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void testWithTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithTransaction();
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user =new User(7,"quan","quannguyen@codegym.vn","vn");
        int [] permission= {1,2,4};
         userService.addUserTransaction(user,permission);
    }

    private void findByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<User> userList = new ArrayList<>();
        userList = userService.findByCountry(country);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
    }

    private void sortList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.sortByName();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/user/list.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAll();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/user/list.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUserById(id);
        List<User> userList = userService.getAll();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("user/list.jsp").forward(request,response);
//        response.sendRedirect("/UserServlet");
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUserById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/user/edit.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                doCreate(request,response);
                break;
            case"update":
                doEdit(request,response);
                break;
            case "find":
                findByCountry(request,response);
                break;
            case"update-by-procedure":
                updateByProcedure(request,response);
                break;

        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        userService.updateUser(user);
        response.sendRedirect("/UserServlet");

    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(id,name,email,country);
        userService.addUser(newUser);
        List<User> userList = userService.getAll();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/user/list.jsp").forward(request,response);
    }
}
