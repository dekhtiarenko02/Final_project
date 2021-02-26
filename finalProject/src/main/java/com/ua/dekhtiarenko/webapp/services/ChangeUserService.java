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

public class ChangeUserService {

    public void changeUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        User user = new User();
        Validation validation = (Validation) servletContext.getAttribute("validation");

        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String librarianL = req.getParameter("Librarian");
        String adminA = req.getParameter("Admin");
        String blockedB = req.getParameter("Blocked");

        if (validation.isValidText(name) && validation.isValidText(surname) && validation.isValidBool(librarianL) &&
                validation.isValidBool(adminA) && validation.isValidBool(blockedB)) {
            boolean librarian = Boolean.parseBoolean(req.getParameter("Librarian"));
            boolean admin = Boolean.parseBoolean(req.getParameter("Admin"));
            boolean blocked = Boolean.parseBoolean(req.getParameter("Blocked"));
            user.setName(name);
            user.setSurname(surname);
            user.setLibrarian(librarian);
            user.setAdmin(admin);
            user.setBlocked(blocked);
            int user_id = Integer.parseInt(req.getParameter("user_id"));
            userDAOImpl.updateUser(user, user_id);
            req.setAttribute("user", user);
        }

        req.getRequestDispatcher("AdminActionsServlet").forward(req, resp);
    }
}
