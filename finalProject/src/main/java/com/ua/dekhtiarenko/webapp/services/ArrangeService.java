package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
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

public class ArrangeService {

    private static final Logger log = Logger.getLogger(ArrangeService.class);

    public void arrange(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start ArrangeService");
        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        SubscriptionDAOImpl subscriptionDAOImpl = (SubscriptionDAOImpl) servletContext.getAttribute("subscriptionDAO");
        SubscriptionBookDAOImpl subscriptionBookDAOImpl = (SubscriptionBookDAOImpl) servletContext.getAttribute("subscriptionBookDAO");
        User user = userDAOImpl.getUserById(Integer.parseInt(req.getParameter("id")));

        int bookId = bookDAOImpl.getBookIdByName(req.getParameter("arrangeButton"));
        int subscriptionId = subscriptionDAOImpl.getSubscriptionIdByUserId(Integer.parseInt(req.getParameter("id")));
        int bookAvailability = bookDAOImpl.getAvailabilityByBookId(bookId);
        List<SubscriptionBook> subscriptionBook = subscriptionBookDAOImpl.getListSubscriptionBook(user.getId());
        boolean userHaveBook = false;

        if (bookAvailability > 0) {
            for (SubscriptionBook book : subscriptionBook) {
                if (book.getBook_id() == bookId) {
                    userHaveBook = true;
                    break;
                }
            }
            if (!userHaveBook) {
                subscriptionBookDAOImpl.insertSubscriptionBook(bookId, subscriptionId);
                bookDAOImpl.reduceBookAvailabilityById(bookId);
            }
        }

        req.setAttribute("bookAvailability", bookAvailability);
        req.setAttribute("id", req.getParameter("id"));
        req.getRequestDispatcher("ProfileServlet").forward(req, resp);
        log.info("Finished ArrangeService");
    }
}
