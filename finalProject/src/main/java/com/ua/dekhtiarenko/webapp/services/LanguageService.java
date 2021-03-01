package com.ua.dekhtiarenko.webapp.services;

import com.ua.dekhtiarenko.webapp.controllers.LanguageServlet;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */
public class LanguageService {

    private static final Logger log = Logger.getLogger(LanguageService.class);

    public void language(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("Start LanguageService");
        HttpSession session = req.getSession();
        session.setAttribute("language", req.getParameter("language"));
        resp.sendRedirect(req.getHeader("Referer"));
        log.info("Finished LanguageService");
    }
}
