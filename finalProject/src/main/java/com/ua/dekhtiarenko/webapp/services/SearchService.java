package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
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

public class SearchService {

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");

        String nameOfBook = req.getParameter("Search");


        List<Book> bookList = new ArrayList<>(bookDAO.getBooksByName(nameOfBook));


        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/searchBook.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.getBookByName("The");
        System.out.println(book);
    }
}
