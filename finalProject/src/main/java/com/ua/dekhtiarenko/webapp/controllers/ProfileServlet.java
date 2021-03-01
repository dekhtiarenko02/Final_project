package com.ua.dekhtiarenko.webapp.controllers;

import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.services.ProfileService;
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

public class ProfileServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ProfileServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Start ProfileServlet");
        req.setCharacterEncoding(Request.CP_1251);
        resp.setContentType(Request.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();

        ProfileService profileService = (ProfileService) servletContext.getAttribute("profileService");
        profileService.profile(req, resp);
        log.info("Finished ProfileServlet");
    }
}

