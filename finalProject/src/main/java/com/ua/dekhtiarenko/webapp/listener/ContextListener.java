package com.ua.dekhtiarenko.webapp.listener;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAO;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAO;
import com.ua.dekhtiarenko.webapp.services.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        BookDAO bookDAO = new BookDAO();
        SubscriptionBookDAO subscriptionBookDAO = new SubscriptionBookDAO();
        SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
        UserDAO userDAO = new UserDAO();

        AdminActionsService adminActionsService = new AdminActionsService();
        ArrangeService arrangeService = new ArrangeService();
        CatalogService catalogService = new CatalogService();
        EditProfileService editProfileService = new EditProfileService();
        LibrarianActionsService librarianActionsService = new LibrarianActionsService();
        LoginService loginService = new LoginService();
        OrderService orderService = new OrderService();
        ProfileService profileService = new ProfileService();
        RegisterService registerService = new RegisterService();
        ReturnService returnService = new ReturnService();
        SearchService searchService = new SearchService();
        InsertBookService insertBookService = new InsertBookService();
        DeleteBookService deleteBookService = new DeleteBookService();
        ChangeUserService changeUserService = new ChangeUserService();
        MainPageService mainPageService = new MainPageService();



        servletContext.setAttribute("changeUserService", changeUserService);
        servletContext.setAttribute("deleteBookService", deleteBookService);
        servletContext.setAttribute("adminActionsService", adminActionsService);
        servletContext.setAttribute("arrangeService", arrangeService);
        servletContext.setAttribute("catalogService", catalogService);
        servletContext.setAttribute("editProfileService", editProfileService);
        servletContext.setAttribute("librarianActionsService", librarianActionsService);
        servletContext.setAttribute("loginService", loginService);
        servletContext.setAttribute("orderService", orderService);
        servletContext.setAttribute("profileService", profileService);
        servletContext.setAttribute("registerService", registerService);
        servletContext.setAttribute("returnService", returnService);
        servletContext.setAttribute("searchService", searchService);
        servletContext.setAttribute("insertBookService", insertBookService);
        servletContext.setAttribute("mainPageService", mainPageService);



        servletContext.setAttribute("bookDAO", bookDAO);
        servletContext.setAttribute("subscriptionBookDAO", subscriptionBookDAO);
        servletContext.setAttribute("subscriptionDAO", subscriptionDAO);
        servletContext.setAttribute("userDAO", userDAO);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
