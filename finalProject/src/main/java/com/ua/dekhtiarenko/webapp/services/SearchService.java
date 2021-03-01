package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.controllers.SearchServlet;
import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.Book;
import com.ua.dekhtiarenko.webapp.validation.Validation;
import org.apache.log4j.Logger;

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

    private final Logger logger = Logger.getLogger(SearchService.class);

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start SearchService");
        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        String nameOfBook;
        if (req.getParameter("Search") != null) {
            nameOfBook = req.getParameter("Search");
        } else {
            nameOfBook = req.getParameter("search");
        }

        Validation validation = (Validation) servletContext.getAttribute("validation");
        List<Book> bookList = new ArrayList<>(bookDAOImpl.getBooksByNameOrAuthor(nameOfBook));
        List<Integer> pageList = new ArrayList<>();

        if (validation.isValidText(nameOfBook)) {
            if (bookList.size() % 2 == 0) {
                for (int i = 0; i < bookList.size() / 2; i++) {
                    pageList.add(i + 1);
                }
            } else {
                for (int i = 0; i < bookList.size() / 2 + 1; i++) {
                    pageList.add(i + 1);
                }
            }

            int counter = 0;
            int index = 0;

            while (true) {
                if (req.getParameter("page") == null || req.getParameter("page").equals("1")) {
                    break;
                } else if (req.getParameter("page").equals("2")) {
                    if (counter == 2) {
                        break;
                    }
                    bookList.remove(index);
                } else if (req.getParameter("page").equals("3")) {
                    if (counter == 4) {
                        break;
                    }
                    bookList.remove(index);
                }
                counter++;
            }
        }
        req.setAttribute("searchWord", nameOfBook);
        req.setAttribute("bookList", bookList);
        req.setAttribute("pageList", pageList);
        req.getRequestDispatcher("/searchBook.jsp").forward(req, resp);
        logger.info("Finished SearchService");
    }
}
