package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.controllers.OrderServlet;
import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class OrderService {

    private static final Logger log = Logger.getLogger(OrderService.class);

    public void order(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start OrderService");
        ServletContext servletContext = req.getServletContext();
        String bookIdReturn = req.getParameter("orderButton");
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        bookDAOImpl.updateBookOrderByNameOfBook(bookIdReturn);

        log.info("Book has been ordered");
        req.setAttribute("id", req.getParameter("id"));
        req.getRequestDispatcher("ProfileServlet").forward(req, resp);
        log.info("Finished OrderService");
    }
}
