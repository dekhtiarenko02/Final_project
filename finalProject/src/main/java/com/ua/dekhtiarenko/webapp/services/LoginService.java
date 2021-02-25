package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;

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
        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");

        String email = req.getParameter("Email");
        String password = req.getParameter("Password");



        if (userDAO.exists(email, password) && !userDAO.getUserById(userDAO.getUserIdByEmail(email)).getBlocked()) {
            req.setAttribute("id", userDAO.getUserIdByEmail(email));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
