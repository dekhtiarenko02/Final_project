package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
import com.ua.dekhtiarenko.webapp.db.entity.Book;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class AdminActionsService {

    public void adminActions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        BookDAOImpl bookDAOImpl = (BookDAOImpl) servletContext.getAttribute("bookDAO");
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        List<User> userList = userDAOImpl.getUserList();
        List<Book> bookList = bookDAOImpl.getListBook();

        req.setAttribute("bookList", bookList);
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/adminActions.jsp").forward(req,resp);
    }
}
