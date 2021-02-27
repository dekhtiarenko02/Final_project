package com.ua.dekhtiarenko.webapp.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Char set filter.
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */
public class CharSetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("cp1251");
        servletResponse.setContentType("text/html");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
