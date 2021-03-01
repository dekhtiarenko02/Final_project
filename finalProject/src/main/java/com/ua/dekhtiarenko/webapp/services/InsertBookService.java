package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.Book;
import com.ua.dekhtiarenko.webapp.validation.Validation;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class InsertBookService {

    private static final Logger log = Logger.getLogger(InsertBookService.class);

    public void insertBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start InsertBookService");
        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        Validation validation = (Validation) servletContext.getAttribute("validation");

        Book book = new Book();

        String genre = req.getParameter("Genre");
        String urlImg = req.getParameter("UrlImg");
        String author = req.getParameter("Author");
        String nameOfBook = req.getParameter("NameOfBook");
        String publisher = req.getParameter("Publisher");
        String language = req.getParameter("Language");
        String plot = req.getParameter("Plot");

        if (validation.isValidText(genre) && validation.isValidAuthorOrPublisher(author) &&
                validation.isValidText(nameOfBook) && validation.isValidAuthorOrPublisher(publisher) &&
                validation.isValidText(language) && validation.isValidUrlImg(urlImg) && plot.length() < 450
        ) {
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
            bookDAOImpl.insertBook(book);
            log.info("Book has been inserted");
        }

        req.getRequestDispatcher("AdminActionsServlet").forward(req, resp);
        log.info("Finished InsertBookService");
    }
}
