package com.ua.dekhtiarenko.webapp.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */
public class LanguageService {

    public void language(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        session.setAttribute("language", req.getParameter("language"));
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
