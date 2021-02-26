package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.validation.Validation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class DeleteBookService {

    public void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        Validation validation = (Validation) servletContext.getAttribute("validation");

        String id = req.getParameter("book_id");
        if (validation.isValidNumbers(id)) {
            int book_id = Integer.parseInt(req.getParameter("book_id"));
            bookDAOImpl.deleteBook(book_id);
        }

        req.getRequestDispatcher("MainPageServlet").forward(req, resp);
    }
}
