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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class ProfileService {

    public void profile(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ServletContext servletContext = req.getServletContext();

        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");
        SubscriptionBookDAO subscriptionBookDAO = (SubscriptionBookDAO) servletContext.getAttribute("subscriptionBookDAO");
        SubscriptionDAO subscriptionDAO = (SubscriptionDAO) servletContext.getAttribute("subscriptionDAO");
        BookDAO bookDAO = (BookDAO) servletContext.getAttribute("bookDAO");

        User user = userDAO.getUserById(Integer.parseInt(req.getParameter("id")));
        List<SubscriptionBook> subscriptionBookList = subscriptionBookDAO.getListSubscriptionBook(user.getId());
        List<String> bookList = new ArrayList<>();

        if (!subscriptionBookList.isEmpty()) {

            Date date = (Date) subscriptionBookList.get(0).getDateOfPurchase();

            for (SubscriptionBook subscriptionBook : subscriptionBookList) {
                bookList.add(bookDAO.getNameOfBookById(subscriptionBook.getBook_id()));
                if (date.after(subscriptionBook.getDateOfPurchase())) {
                    date = (Date) subscriptionBook.getDateOfPurchase();
                }
            }

            Date dateNow = new Date(System.currentTimeMillis());
            date.setTime(date.getTime() + TimeUnit.DAYS.toMillis(7));

            if (dateNow.after(date)) {
                req.setAttribute("penalty", subscriptionDAO.getPenaltyFromSubscriptionByUserId(user.getId()) + 3);
            } else {
                req.setAttribute("penalty", subscriptionDAO.getPenaltyFromSubscriptionByUserId(user.getId()));
            }
            req.setAttribute("date", date);
            req.setAttribute("bookList", bookList);
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }
}
