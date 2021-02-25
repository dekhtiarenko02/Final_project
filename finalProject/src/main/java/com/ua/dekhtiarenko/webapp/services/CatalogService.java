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

public class CatalogService {

    public void catalog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");

        String genre = req.getParameter("genre");
        req.setAttribute("bookList", bookDAO.getListBook(genre));

        req.getRequestDispatcher("/catalogPage.jsp").forward(req, resp);
    }
}
