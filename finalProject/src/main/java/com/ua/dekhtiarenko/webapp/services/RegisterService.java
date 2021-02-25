package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class RegisterService {

    public void registration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");
        SubscriptionDAO subscriptionDAO = (SubscriptionDAO) servletContext.getAttribute("subscriptionDAO");

        User user = new User();
        String email = req.getParameter("Email");
        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String password = req.getParameter("Password");

        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setLibrarian(false);
        user.setAdmin(false);
        user.setBlocked(false);
        user.setPassword(password);
        userDAO.insertUser(user);
        user.setId(userDAO.getUserIdByEmail(user.getEmail()));

        subscriptionDAO.insertSubscription(user);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
