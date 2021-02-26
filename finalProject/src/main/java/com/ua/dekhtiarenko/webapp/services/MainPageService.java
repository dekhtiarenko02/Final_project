package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class MainPageService {

    public void mainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        List<Book> bookListAvailabilityLess = new ArrayList<>();
        List<Book> bookList = bookDAOImpl.getListBook();
        List<Book> bookListAvailabilityMore = new ArrayList<>();


        for (Book book : bookList) {
            if (book.getAvailability() > 0) {
                if (book.getAvailability() < 3) {
                    bookListAvailabilityLess.add(book);
                }
                if (book.getAvailability() >= 3) {
                    bookListAvailabilityMore.add(book);
                }
            }
        }

        req.setAttribute("bookListAvailabilityMore", bookListAvailabilityMore);
        req.setAttribute("bookListAvailabilityLess", bookListAvailabilityLess);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
