package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.User;
import com.ua.dekhtiarenko.webapp.validation.Validation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class EditProfileService {

    public void editProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        User user = userDAOImpl.getUserById(Integer.parseInt(req.getParameter("id")));
        Validation validation = (Validation) servletContext.getAttribute("validation");

        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String password = req.getParameter("Password");

        if (validation.isValidText(name) && validation.isValidText(surname) && validation.isValidPassword(password)) {
            user.setName(req.getParameter("Name"));
            user.setSurname(req.getParameter("Surname"));
            user.setPassword(req.getParameter("Password"));
            userDAOImpl.updateUser(user);
        }

        req.getRequestDispatcher("MainPageServlet").forward(req, resp);
    }
}
