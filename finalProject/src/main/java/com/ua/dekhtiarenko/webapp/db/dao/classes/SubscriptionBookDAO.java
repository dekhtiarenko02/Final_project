package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.SubscriptionBookDAOMethods;
import com.ua.dekhtiarenko.webapp.db.entity.SubscriptionBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SubscriptionBookDAO implements SubscriptionBookDAOMethods {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        date.setTime(date.getTime() + TimeUnit.DAYS.toMillis(7));
        System.out.println(date);
    }

    @Override
    public void insertSubscriptionBook(int bookId, int subscriptionId) {
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
    }

    @Override
    public List<SubscriptionBook> getListSubscriptionBook(int userId) {
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

        return list;
    }

    @Override
    public SubscriptionBook readingResultSet(ResultSet resultSet) {
        SubscriptionBook subscription = new SubscriptionBook();
        try {
            subscription.setId(resultSet.getInt("id_subscriptionBook"));
            subscription.setDateOfPurchase(resultSet.getDate("dateOfPurchase"));
            subscription.setSubscription_id(resultSet.getInt("subscription_id"));
            subscription.setBook_id(resultSet.getInt("book_id"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return subscription;
    }

    @Override
    public void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
    }
}
