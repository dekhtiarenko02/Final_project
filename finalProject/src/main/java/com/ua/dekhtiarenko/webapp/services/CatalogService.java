package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.Book;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class CatalogService {

    private static final Logger log = Logger.getLogger(CatalogService.class);

    public void catalog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start CatalogService");
        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        String genre = req.getParameter("genre");
        String sort = req.getParameter("Sort");
        List<Book> bookList = bookDAOImpl.getListBookByGenre(genre);
        log.info("Catalog was sorted by " + sort);
        if (Objects.equals(sort, "-")) {
            bookList = bookDAOImpl.getListBookByGenre(genre);
        } else if (Objects.equals(sort, "Title") || Objects.equals(sort, "Названию")) {
            bookList = bookDAOImpl.getListBookByGenreSorted(genre, "nameOfBook");
        } else if (Objects.equals(sort, "Author") || Objects.equals(sort, "Автору")) {
            bookList = bookDAOImpl.getListBookByGenreSorted(genre, "author");
        } else if (Objects.equals(sort, "Year of issue") || Objects.equals(sort, "Году выпуска")) {
            bookList = bookDAOImpl.getListBookByGenreSorted(genre, "year");
        } else if (Objects.equals(sort, "Publisher") || Objects.equals(sort, "Изданию")) {
            bookList = bookDAOImpl.getListBookByGenreSorted(genre, "publisher");
        }

        List<Integer> pageList = new ArrayList<>();

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

        req.setAttribute("pageList", pageList);
        req.setAttribute("bookList", bookList);
        req.setAttribute("genre", genre);
        req.getRequestDispatcher("/catalogPage.jsp").forward(req, resp);
        log.info("Finished CatalogService");
    }
}
