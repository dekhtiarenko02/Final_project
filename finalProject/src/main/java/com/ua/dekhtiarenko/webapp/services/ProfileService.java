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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class ProfileService {

    private static final Logger log = Logger.getLogger(ProfileService.class);

    public void profile(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Start ProfileService");
        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        SubscriptionBookDAOImpl subscriptionBookDAOImpl = (SubscriptionBookDAOImpl) servletContext.getAttribute("subscriptionBookDAO");
        SubscriptionDAOImpl subscriptionDAOImpl = (SubscriptionDAOImpl) servletContext.getAttribute("subscriptionDAO");
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");

        User user = userDAOImpl.getUserById(Integer.parseInt(req.getParameter("id")));
        List<SubscriptionBook> subscriptionBookList = subscriptionBookDAOImpl.getListSubscriptionBook(user.getId());
        List<String> bookList = new ArrayList<>();

        if (!subscriptionBookList.isEmpty()) {

            Date date = (Date) subscriptionBookList.get(0).getDateOfPurchase();

            for (SubscriptionBook subscriptionBook : subscriptionBookList) {
                bookList.add(bookDAOImpl.getNameOfBookById(subscriptionBook.getBook_id()));
                if (date.after(subscriptionBook.getDateOfPurchase())) {
                    date = (Date) subscriptionBook.getDateOfPurchase();
                }
            }

            Date dateNow = new Date(System.currentTimeMillis());
            date.setTime(date.getTime() + TimeUnit.DAYS.toMillis(7));

            if (dateNow.after(date)) {
                log.info("SetAttribute penalty");
                req.setAttribute("penalty", subscriptionDAOImpl.getPenaltyFromSubscriptionByUserId(user.getId()) + 3);
            } else {
                req.setAttribute("penalty", subscriptionDAOImpl.getPenaltyFromSubscriptionByUserId(user.getId()));
            }
            req.setAttribute("date", date);
            req.setAttribute("bookList", bookList);
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        log.info("Finished ProfileService");
    }
}
