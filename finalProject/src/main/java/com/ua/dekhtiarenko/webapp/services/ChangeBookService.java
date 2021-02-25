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

public class ChangeBookService {

    public void changeBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");
        Book book = new Book();

        String genre = req.getParameter("Genre");
        String author = req.getParameter("Author");
        String nameOfBook = req.getParameter("NameOfBook");
        String publisher = req.getParameter("Publisher");
        int year = Integer.parseInt(req.getParameter("Year"));
        int availability = Integer.parseInt(req.getParameter("Availability"));
        int numberOfPages = Integer.parseInt(req.getParameter("NumberOfPages"));
        String language = req.getParameter("Language");
        boolean isOrder = Boolean.parseBoolean(req.getParameter("IsOrder"));

        book.setGenre(genre);
        book.setAuthor(author);
        book.setNameOfBook(nameOfBook);
        book.setPublisher(publisher);
        book.setYear(year);
        book.setAvailability(availability);
        book.setNumberOfPages(numberOfPages);
        book.setLanguage(language);
        book.setOrder(isOrder);


        req.setAttribute("book",book);
        int book_id = Integer.parseInt(req.getParameter("book_id"));

        bookDAO.updateBook(book,book_id);
        req.getRequestDispatcher("AdminActionsServlet").forward(req, resp);
    }
}
