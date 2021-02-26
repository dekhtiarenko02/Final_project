package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
import com.ua.dekhtiarenko.webapp.validation.Validation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class LoginService {

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        Validation validation = (Validation) servletContext.getAttribute("validation");

        String email = req.getParameter("Email");
        String password = req.getParameter("Password");

        if (userDAOImpl.exists(email, password) && !userDAOImpl.getUserById(userDAOImpl.getUserIdByEmail(email)).getBlocked()
                && validation.isValidEmail(email) && validation.isValidPassword(password)) {
            req.setAttribute("id", userDAOImpl.getUserIdByEmail(email));
            req.getRequestDispatcher("MainPageServlet").forward(req, resp);
        }
    }
}
