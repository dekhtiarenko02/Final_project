package com.ua.dekhtiarenko.webapp.filter;

import com.ua.dekhtiarenko.webapp.Path;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Librarian action filter filter.
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */
public class LibrarianActionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        ServletContext servletContext = req.getServletContext();
        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");

        int userId = Integer.parseInt(servletRequest.getParameter("id"));
        User user = userDAO.getUserById(userId);

        if(user.getLibrarian()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher(Path.PAGE_ERROR_PERMISSION)
                    .forward(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
