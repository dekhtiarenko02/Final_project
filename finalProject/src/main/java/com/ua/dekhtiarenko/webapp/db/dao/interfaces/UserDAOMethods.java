package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface UserDAOMethods {

    void insertUser(User user);

    User getUserById(int id);

    int getUserIdByEmail(String email);

    User updateUser(User user);

    boolean validate(String name, String pass);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
