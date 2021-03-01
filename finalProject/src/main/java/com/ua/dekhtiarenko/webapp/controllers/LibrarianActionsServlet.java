package com.ua.dekhtiarenko.webapp.controllers;

import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.services.LanguageService;
import com.ua.dekhtiarenko.webapp.services.LibrarianActionsService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class LibrarianActionsServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(LibrarianActionsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start LibrarianActionsServlet");
        req.setCharacterEncoding(Request.CP_1251);
        resp.setContentType(Request.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();

        LibrarianActionsService librarianActionsService = (LibrarianActionsService) servletContext.getAttribute("librarianActionsService");
        librarianActionsService.librarianActions(req, resp);
        log.info("Finished LibrarianActionsServlet");
    }
}
