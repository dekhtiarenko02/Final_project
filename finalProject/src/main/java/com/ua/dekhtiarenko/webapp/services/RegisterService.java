package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.User;
import com.ua.dekhtiarenko.webapp.validation.Validation;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class RegisterService {

    private static final Logger log = Logger.getLogger(RegisterService.class);

    public void registration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start RegisterService");

        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        SubscriptionDAOImpl subscriptionDAOImpl = (SubscriptionDAOImpl) servletContext.getAttribute("subscriptionDAO");

        User user = new User();
        String email = req.getParameter("Email");
        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String password = req.getParameter("Password");

        Validation validation = (Validation) servletContext.getAttribute("validation");

        if (validation.isValidText(name) && validation.isValidText(surname)
                && validation.isValidPassword(password) && validation.isValidEmail(email)) {
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);
            user.setLibrarian(false);
            user.setAdmin(false);
            user.setBlocked(false);
            user.setPassword(password);
            userDAOImpl.insertUser(user);
            user.setId(userDAOImpl.getUserIdByEmail(user.getEmail()));
            subscriptionDAOImpl.insertSubscription(user);
            req.getRequestDispatcher("MainPageServlet").forward(req, resp);

            log.info("User's email==> " + email + " name==> " + name + " surname==> "
                    + surname + " password==> " + password);

        } else {
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        log.info("RegisterService finished");
    }
}
