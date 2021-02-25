package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class OrderService {

    public void order(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        String bookIdReturn = req.getParameter("orderButton");
        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");
        bookDAO.updateBookOrderByNameOfBook(bookIdReturn);

        req.setAttribute("id",req.getParameter("id"));
        req.getRequestDispatcher("ProfileServlet").forward(req, resp);
    }
}
