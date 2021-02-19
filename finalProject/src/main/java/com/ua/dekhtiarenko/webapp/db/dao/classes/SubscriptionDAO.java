package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.SubscriptionDAOMethods;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SubscriptionDAO implements SubscriptionDAOMethods {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public void insertSubscription(User user) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.INSERT_INTO_SUBSCRIPTION);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    @Override
    public int getPenaltyFromSubscriptionByUserId(int userId) {
        int penalty = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_PENALTY_FROM_SUBSCRIPTION_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                penalty = rs.getInt("penalty");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return penalty;
    }

    @Override
    public int getSubscriptionIdByUserId(int userId) {
        int id = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_ID_SUBSCRIPTION_BY_BOOK_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_subscription");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return id;
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
