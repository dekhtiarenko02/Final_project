package com.ua.dekhtiarenko.webapp.services;

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

public class EditProfileService {

    public void editProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");
        User user = userDAO.getUserById(Integer.parseInt(req.getParameter("id")));

        user.setName(req.getParameter("Name"));
        user.setSurname(req.getParameter("Surname"));
        user.setPassword(req.getParameter("Password"));
        userDAO.updateUser(user);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
