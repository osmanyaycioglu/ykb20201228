package com.training.ykb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serv/test")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 2510053448632953398L;

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        respParam.getWriter()
                 .println("Test");
    }
}
