package com.ua.dekhtiarenko.webapp.controllers;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ArrangeServlet extends HttpServlet {

    private final BookDAO bookDAO = new BookDAO();
    private final SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
    private final SubscriptionBookDAO subscriptionBookDAO = new SubscriptionBookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int bookId = bookDAO.getBookIdByName(req.getParameter("arrangeButton"));
        int subscriptionId = subscriptionDAO.getSubscriptionIdByUserId(Integer.parseInt(req.getParameter("id")));

        subscriptionBookDAO.insertSubscriptionBook(bookId, subscriptionId);
        bookDAO.reduceBookAvailabilityById(bookId);

        req.setAttribute("id",req.getParameter("id"));
        req.getRequestDispatcher("ProfileServlet").forward(req, resp);
    }
}
