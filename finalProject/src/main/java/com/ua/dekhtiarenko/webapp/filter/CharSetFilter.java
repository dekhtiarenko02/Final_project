package com.ua.dekhtiarenko.webapp.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Char set filter.
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */
public class CharSetFilter implements Filter {

    private final Logger logger = Logger.getLogger(CharSetFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Start CharSetFilter");
        servletRequest.setCharacterEncoding("cp1251");
        servletResponse.setContentType("text/html");

        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("Finished CharSetFilter");
    }

    @Override
    public void destroy() {
    }
}
