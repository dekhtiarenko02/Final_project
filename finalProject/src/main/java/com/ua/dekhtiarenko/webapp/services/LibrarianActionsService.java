package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.Book;
import com.ua.dekhtiarenko.webapp.db.entity.Subscription;
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

public class LibrarianActionsService {

    public void librarianActions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");
        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");
        SubscriptionDAO subscriptionDAO = (SubscriptionDAO) servletContext.getAttribute("subscriptionDAO");
        SubscriptionBookDAO subscriptionBookDAO = (SubscriptionBookDAO) servletContext.getAttribute("subscriptionBookDAO");

        List<User> userList = userDAO.getUserList();
        List<Subscription> subscriptionList = subscriptionDAO.getSubscriptionList();
        List<SubscriptionBook> subscriptionBookList = subscriptionBookDAO.getListSubscriptionBook();
        List<Book> bookList = bookDAO.getListBook();

        req.setAttribute("bookList", bookList);
        req.setAttribute("userList", userList);
        req.setAttribute("subscriptionList", subscriptionList);
        req.setAttribute("subscriptionBookList", subscriptionBookList);

        req.getRequestDispatcher("/librarianActions.jsp").forward(req,resp);
    }
}
