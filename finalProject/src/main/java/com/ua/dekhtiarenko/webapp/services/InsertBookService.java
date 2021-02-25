package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
import com.ua.dekhtiarenko.webapp.db.entity.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class InsertBookService {

    public void insertBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");

        Book book = new Book();
        book.setGenre(req.getParameter("Genre"));
        book.setUrlImg(req.getParameter("UrlImg"));
        book.setAuthor(req.getParameter("Author"));
        book.setNameOfBook(req.getParameter("NameOfBook"));
        book.setPublisher(req.getParameter("Publisher"));
        book.setLanguage(req.getParameter("Language"));
        book.setPlot(req.getParameter("Plot"));
        book.setOrder(false);
        book.setYear(Integer.parseInt(req.getParameter("year")));
        book.setAvailability(Integer.parseInt(req.getParameter("availability")));
        book.setNumberOfPages(Integer.parseInt(req.getParameter("numberOfPages")));
        bookDAO.insertBook(book);

        req.getRequestDispatcher("AdminActionsServlet").forward(req, resp);
    }
}
