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

public class ChangeUserService {

    public void changeUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();

        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");
        User user = new User();

        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        boolean librarian = Boolean.parseBoolean(req.getParameter("Librarian"));
        boolean admin = Boolean.parseBoolean(req.getParameter("Admin"));
        boolean blocked = Boolean.parseBoolean(req.getParameter("Blocked"));

        user.setName(name);
        user.setSurname(surname);
        user.setLibrarian(librarian);
        user.setAdmin(admin);
        user.setBlocked(blocked);

        req.setAttribute("user",user);

        int user_id = Integer.parseInt(req.getParameter("user_id"));
        userDAO.updateUser(user, user_id);

        req.getRequestDispatcher("AdminActionsServlet").forward(req, resp);
    }
}
