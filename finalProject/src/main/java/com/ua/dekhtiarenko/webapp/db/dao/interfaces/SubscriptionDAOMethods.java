package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface SubscriptionDAOMethods {

    void insertSubscription(User user);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    int getSubscriptionIdByUserId(int userId);

    int getPenaltyFromSubscriptionByUserId(int userId);

}
