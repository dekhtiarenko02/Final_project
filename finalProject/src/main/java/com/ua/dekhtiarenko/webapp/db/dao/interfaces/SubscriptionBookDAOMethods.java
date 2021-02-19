package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.SubscriptionBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface SubscriptionBookDAOMethods {

    void insertSubscriptionBook(int bookId, int subscriptionId);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    List<SubscriptionBook> getListSubscriptionBook(int userId);

    SubscriptionBook readingResultSet(ResultSet resultSet);
}
