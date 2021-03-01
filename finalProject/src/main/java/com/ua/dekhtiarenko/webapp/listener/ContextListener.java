package com.ua.dekhtiarenko.webapp.listener;

import com.ua.dekhtiarenko.webapp.db.dao.classes.BookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionBookDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.SubscriptionDAOImpl;
import com.ua.dekhtiarenko.webapp.db.dao.classes.UserDAOImpl;
import com.ua.dekhtiarenko.webapp.services.*;
import com.ua.dekhtiarenko.webapp.validation.Validation;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Context listener.
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class ContextListener implements ServletContextListener {

    private final Logger logger = Logger.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Start ContextListener");
        ServletContext servletContext = servletContextEvent.getServletContext();
        BookDAOImpl bookDAOImpl = new BookDAOImpl();
        SubscriptionBookDAOImpl subscriptionBookDAOImpl = new SubscriptionBookDAOImpl();
        SubscriptionDAOImpl subscriptionDAOImpl = new SubscriptionDAOImpl();
        UserDAOImpl userDAOImpl = new UserDAOImpl();

        Validation validation = new Validation();

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
        ChangeBookService changeBookService = new ChangeBookService();
        MainPageService mainPageService = new MainPageService();
        LanguageService languageService = new LanguageService();

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
        servletContext.setAttribute("changeBookService", changeBookService);
        servletContext.setAttribute("languageService", languageService);

        servletContext.setAttribute("validation", validation);

        servletContext.setAttribute("bookDAO", bookDAOImpl);
        servletContext.setAttribute("subscriptionBookDAO", subscriptionBookDAOImpl);
        servletContext.setAttribute("subscriptionDAO", subscriptionDAOImpl);
        servletContext.setAttribute("userDAO", userDAOImpl);
        logger.info("Finished ContextListener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
