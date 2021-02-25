package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
import com.ua.dekhtiarenko.webapp.db.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class MainPageService {

    public void mainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");
        List<Book> bookList = bookDAO.getListBook();

        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
