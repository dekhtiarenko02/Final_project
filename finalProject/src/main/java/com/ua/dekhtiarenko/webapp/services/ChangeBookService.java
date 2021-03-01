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

public class ChangeBookService {

    private static final Logger log = Logger.getLogger(ChangeBookService.class);

    public void changeBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start ChangeBookService");
        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        Book book = new Book();
        Validation validation = (Validation) servletContext.getAttribute("validation");

        String genre = req.getParameter("Genre");
        String author = req.getParameter("Author");
        String nameOfBook = req.getParameter("NameOfBook");
        String publisher = req.getParameter("Publisher");
        String yearY = req.getParameter("Year");
        String availabilityA = req.getParameter("Availability");
        String numberOfPagesN = req.getParameter("NumberOfPages");
        String language = req.getParameter("Language");
        String isOrderI = req.getParameter("IsOrder");


        if (validation.isValidText(genre) && validation.isValidAuthorOrPublisher(author) &&
                validation.isValidText(nameOfBook) && validation.isValidAuthorOrPublisher(publisher) &&
                validation.isValidText(language) && validation.isValidNumbers(yearY) &&
                validation.isValidNumbers(availabilityA) && validation.isValidNumbers(numberOfPagesN) &&
                validation.isValidBool(isOrderI)
        ) {
            boolean isOrder = Boolean.parseBoolean(req.getParameter("IsOrder"));
            int year = Integer.parseInt(req.getParameter("Year"));
            int availability = Integer.parseInt(req.getParameter("Availability"));
            int numberOfPages = Integer.parseInt(req.getParameter("NumberOfPages"));

            book.setGenre(genre);
            book.setAuthor(author);
            book.setNameOfBook(nameOfBook);
            book.setPublisher(publisher);
            book.setYear(year);
            book.setAvailability(availability);
            book.setNumberOfPages(numberOfPages);
            book.setLanguage(language);
            book.setOrder(isOrder);
            int book_id = Integer.parseInt(req.getParameter("book_id"));
            bookDAOImpl.updateBook(book, book_id);
            log.info("Book has been updated");
            req.setAttribute("book", book);
        }

        req.getRequestDispatcher("AdminActionsServlet").forward(req, resp);
        log.info("Finished ChangeBookService");
    }
}
