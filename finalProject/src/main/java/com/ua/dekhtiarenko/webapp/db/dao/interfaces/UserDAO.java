package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public interface UserDAO {

    void insertUser(User user);

    User getUserById(int id);

    List<User> getUserList();

    User readingResultSet(ResultSet resultSet);

    int getUserIdByEmail(String email);

    void updateUser(User user);

    void updateUser(User user, int user_id);

    boolean exists(String name, String pass);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
