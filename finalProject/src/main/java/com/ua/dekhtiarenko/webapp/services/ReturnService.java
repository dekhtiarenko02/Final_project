package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.SubscriptionBook;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class ReturnService {

    public void returnService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");
        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");
        SubscriptionDAO subscriptionDAO = (SubscriptionDAO) servletContext.getAttribute("subscriptionDAO");
        SubscriptionBookDAO subscriptionBookDAO = (SubscriptionBookDAO) servletContext.getAttribute("subscriptionBookDAO");


        User user = userDAO.getUserById(Integer.parseInt(req.getParameter("id")));

        int bookIdReturn = bookDAO.getBookIdByName(req.getParameter("returnButton"));
        int subscriptionId = subscriptionDAO.getSubscriptionIdByUserId(Integer.parseInt(req.getParameter("id")));
        int bookAvailability = bookDAO.getAvailabilityByBookId(bookIdReturn);

        List<SubscriptionBook> subscriptionBook = subscriptionBookDAO.getListSubscriptionBook(user.getId());

        boolean userHaveBook = false;

        if (bookAvailability >= 0) {
            for (SubscriptionBook book : subscriptionBook) {
                if (book.getBook_id() == bookIdReturn) {
                    userHaveBook = true;
                    break;
                }
            }
            if(userHaveBook){
                subscriptionBookDAO.deleteSubscriptionBook(bookIdReturn, subscriptionId);
                bookDAO.increaseBookAvailabilityById(bookIdReturn);
            }
        }

        req.setAttribute("bookAvailability",bookAvailability);
        req.setAttribute("id",req.getParameter("id"));
        req.getRequestDispatcher("ProfileServlet").forward(req, resp);
    }
}
