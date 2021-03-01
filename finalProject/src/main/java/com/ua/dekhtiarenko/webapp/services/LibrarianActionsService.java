package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.controllers.LibrarianActionsServlet;
import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.Book;
import com.ua.dekhtiarenko.webapp.db.entity.Subscription;
import com.ua.dekhtiarenko.webapp.db.entity.SubscriptionBook;
import com.ua.dekhtiarenko.webapp.db.entity.User;
import org.apache.log4j.Logger;

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

    private static final Logger log = Logger.getLogger(LibrarianActionsService.class);

    public void librarianActions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start LibrarianActionsService");
        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        SubscriptionDAOImpl subscriptionDAOImpl = (SubscriptionDAOImpl) servletContext.getAttribute("subscriptionDAO");
        SubscriptionBookDAOImpl subscriptionBookDAOImpl = (SubscriptionBookDAOImpl) servletContext.getAttribute("subscriptionBookDAO");

        List<User> userList = userDAOImpl.getUserList();
        List<Subscription> subscriptionList = subscriptionDAOImpl.getSubscriptionList();
        List<SubscriptionBook> subscriptionBookList = subscriptionBookDAOImpl.getListSubscriptionBook();
        List<Book> bookList = bookDAOImpl.getListBook();

        req.setAttribute("bookList", bookList);
        req.setAttribute("userList", userList);
        req.setAttribute("subscriptionList", subscriptionList);
        req.setAttribute("subscriptionBookList", subscriptionBookList);
        req.getRequestDispatcher("/librarianActions.jsp").forward(req, resp);
        log.info("Finished LibrarianActionsService");
    }
}
