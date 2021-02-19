package com.ua.dekhtiarenko.webapp.controllers;

import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProfileServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("cp1251");
        resp.setContentType("text/html");

        User user = userDAO.getUserById(Integer.parseInt(req.getParameter("id")));

        String name = req.getParameter("Name");
        String surname = req.getParameter("Surname");
        String password = req.getParameter("Password");

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);

        userDAO.updateUser(user);
        req.getRequestDispatcher("ProfileServlet.jsp").forward(req, resp);
    }
}
