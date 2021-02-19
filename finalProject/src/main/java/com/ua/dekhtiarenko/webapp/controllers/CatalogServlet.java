package com.ua.dekhtiarenko.webapp.controllers;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("cp1251");
        resp.setContentType("text/html");

        String genre = req.getParameter("genre");
        req.setAttribute("bookList", new BookDAO().getListBook(genre));

        req.getRequestDispatcher("/catalogPage.jsp").forward(req, resp);
    }
}
