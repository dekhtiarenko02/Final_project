package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.SubscriptionDAO;
import com.ua.dekhtiarenko.webapp.db.entity.Subscription;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class SubscriptionDAOImpl implements SubscriptionDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    /**
     * Insert subscription.
     *
     * @param user
     */
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

    /**
     * Return penalty from subscription by user id
     *
     * @param userId
     * @return penalty.
     */
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

    /**
     * Return subscription list.
     *
     * @return subscription list.
     */
    @Override
    public List<Subscription> getSubscriptionList() {
        List<Subscription> subscriptionList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_SUBSCRIPTION);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                subscriptionList.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return subscriptionList;
    }

    /**
     * Returns book by resultSet.
     *
     * @param resultSet
     * @return subscription book.
     */
    @Override
    public Subscription readingResultSet(ResultSet resultSet) {
        Subscription subscription = new Subscription();
        try {
            subscription.setId(resultSet.getInt("id_subscription"));
            subscription.setPenalty(resultSet.getInt("penalty"));
            subscription.setUser_id(resultSet.getInt("user_id"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return subscription;
    }

    /**
     * Return subscription id by user id.
     *
     * @param userId
     * @return subscription id.
     */
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

    /**
     * Closes resources.
     */
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
