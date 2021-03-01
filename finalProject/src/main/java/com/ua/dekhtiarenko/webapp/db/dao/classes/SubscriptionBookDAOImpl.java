package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.SubscriptionBookDAO;
import com.ua.dekhtiarenko.webapp.db.entity.SubscriptionBook;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class SubscriptionBookDAOImpl implements SubscriptionBookDAO {

    private final Logger logger = Logger.getLogger(SubscriptionBookDAOImpl.class);
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    /**
     * Insert subscription book.
     *
     * @param subscriptionId
     */
    @Override
    public void insertSubscriptionBook(int bookId, int subscriptionId) {
        logger.info("Start insertSubscriptionBook");
        Date date = new Date(System.currentTimeMillis());
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.INSERT_INTO_SUBSCRIPTION_BOOK);
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, subscriptionId);
            preparedStatement.setInt(3, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished insertSubscriptionBook");
    }

    /**
     * Delete subscription book.
     *
     * @param subscriptionId
     */
    @Override
    public void deleteSubscriptionBook(int bookId, int subscriptionId) {
        logger.info("Start deleteSubscriptionBook");
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_SUBSCRIPTION_BOOK);
            preparedStatement.setInt(1, subscriptionId);
            preparedStatement.setInt(2, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished deleteSubscriptionBook");
    }

    /**
     * Return list of subscription book.
     *
     * @return list
     */
    @Override
    public List<SubscriptionBook> getListSubscriptionBook() {
        logger.info("Start getListSubscriptionBook");
        List<SubscriptionBook> list = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_SUBSCRIPTION_BOOK);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished getListSubscriptionBook");
        return list;
    }

    /**
     * Return list of subscription book by user id.
     *
     * @param userId
     * @return list
     */
    @Override
    public List<SubscriptionBook> getListSubscriptionBook(int userId) {
        logger.info("Start getListSubscriptionBook");
        List<SubscriptionBook> list = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_SUBSCRIPTION_BOOK_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished getListSubscriptionBook");
        return list;
    }

    /**
     * Returns book by resultSet.
     *
     * @param resultSet
     * @return subscription book.
     */
    @Override
    public SubscriptionBook readingResultSet(ResultSet resultSet) {
        logger.info("Start readingResultSet");
        SubscriptionBook subscription = new SubscriptionBook();
        try {
            subscription.setId(resultSet.getInt("id_subscriptionBook"));
            subscription.setDateOfPurchase(resultSet.getDate("dateOfPurchase"));
            subscription.setSubscription_id(resultSet.getInt("subscription_id"));
            subscription.setBook_id(resultSet.getInt("book_id"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        logger.info("Finished readingResultSet");
        return subscription;
    }

    /**
     * Closes resources.
     */
    @Override
    public void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
        logger.info("Start closing");
        try {
            if (rs != null) {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        logger.info("Finished closing");
    }
}
