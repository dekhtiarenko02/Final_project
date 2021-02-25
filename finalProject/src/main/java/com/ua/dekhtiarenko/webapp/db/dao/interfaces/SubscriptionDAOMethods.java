package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.Subscription;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public interface SubscriptionDAOMethods {

    void insertSubscription(User user);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    int getSubscriptionIdByUserId(int userId);

    int getPenaltyFromSubscriptionByUserId(int userId);

    List<Subscription> getSubscriptionList();

    Subscription readingResultSet(ResultSet resultSet);

}
