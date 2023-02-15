package com.example.final_md3.controller;

import com.example.final_md3.Service.impl.BenhNhanService;
import com.example.final_md3.model.BenhAn;
import com.example.final_md3.model.BenhNhan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhNhanServlet", value = "/BenhNhanServlet")
public class BenhNhanServlet extends HttpServlet {
    BenhNhanService benhNhanService;

    @Override
    public void init() throws ServletException {
        benhNhanService = new BenhNhanService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action ==null){
            action = "";
        }
        switch (action){
            case"create":
                showCreate(request,response);
                break;
            case"edit":
                showEdit(request,response);
                break;
            case"delete":
                doRemove(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhNhan> benhNhanList = benhNhanService.getAll();
        request.setAttribute("benhNhanList",benhNhanList);
        request.getRequestDispatcher("/benhNhan/list.jsp").forward(request,response);
    }

    private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maBenhNhan = request.getParameter("maBenhNhan");
        String maBenhAn = request.getParameter("maBenhAn");
        benhNhanService.deleteByMaBenhNhan(maBenhNhan,maBenhAn);
        response.sendRedirect("/BenhNhanServlet");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        BenhNhan benhNhan = benhNhanService.findByMaBenhNhan(maBenhNhan,maBenhAn);
        request.setAttribute("benhNhan",benhNhan);
        request.getRequestDispatcher("/benhNhan/edit.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/benhNhan/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case"edit":
                doEdit(request,response);
                break;
        }

    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maBenhAn = request.getParameter("maBenhAn");
        String maBenhNhan = request.getParameter("maBenhNhan");
        String tenBenhNhan = request.getParameter("tenBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String liDo = request.getParameter("liDo");
        BenhNhan benhNhan = new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,liDo,maBenhAn);
        benhNhanService.updateBenhNhan(benhNhan);
        response.sendRedirect("/BenhNhanServlet");
    }
}
