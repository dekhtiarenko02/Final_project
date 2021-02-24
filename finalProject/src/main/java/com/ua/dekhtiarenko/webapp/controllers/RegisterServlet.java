package com.ua.dekhtiarenko.webapp.controllers;

import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class RegisterServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();
    private final SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
    private final User user = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("cp1251");
        resp.setContentType("text/html");

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
