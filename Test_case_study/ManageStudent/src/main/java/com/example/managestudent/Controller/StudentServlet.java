package com.example.managestudent.Controller;

import com.example.managestudent.Service.Impl.ResultService;
import com.example.managestudent.Service.Impl.StudentService;
import com.example.managestudent.model.Result;
import com.example.managestudent.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    ResultService resultService;
    StudentService studentService;

    @Override
    public void init() throws ServletException {
        resultService = new ResultService();
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case"edit":
                showEdit(request,response);
                break;
            case"delete":
                doRemove(request,response);
                break;
            case"showResult":
                showResult(request,response);
                break;
            default:
                showList(request,response);
        }

    }

    private void showResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        Student student = studentService.findbyStudentId(studentId);
        List< Result> resultList = resultService.findById(studentId);
        request.setAttribute("resultList",resultList);
        request.setAttribute("student",student);
        request.getRequestDispatcher("/student/resultList.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("/student/list.jsp").forward(request,response);
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("studentId");
        studentService.deleteById(studentId);
        response.sendRedirect("/StudentServlet");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        Student student = studentService.findbyStudentId(studentId);
        request.setAttribute("student",student);
        request.getRequestDispatcher("/student/edit.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/student/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case"create":
                doCreate(request,response);
                break;
            case"edit":
                doEdit(request,response);
                break;
            case"search":
                search(request,response);
                break;
        }


    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        List<Student> studentList = studentService.findByAddress(address);
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("/student/list.jsp").forward(request,response);
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String birthDate = request.getParameter("birthDate");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String address = request.getParameter("address");
        Student newStudent = new Student(studentId,studentName,birthDate,gender,address);
        studentService.editStudent(newStudent);
        response.sendRedirect("/StudentServlet");
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String birthDate = request.getParameter("birthDate");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String address = request.getParameter("address");
        Student newStudent = new Student(studentId,studentName,birthDate,gender,address);
        studentService.insertStudent(newStudent);
        response.sendRedirect("/StudentServlet");
    }
}
