package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.UserDAOMethods;
import com.ua.dekhtiarenko.webapp.db.entity.User;

import java.sql.*;
import java.util.logging.Logger;

public class UserDAO implements UserDAOMethods {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;

    @Override
    public void insertUser(User user) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.INSERT_INTO_USER);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setBoolean(4, user.getLibrarian());
            preparedStatement.setBoolean(5, user.getAdmin());
            preparedStatement.setBoolean(6, user.getBlocked());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }


    @Override
    public User getUserById(int id) {
        User user = new User();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.GET_USER_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id_user"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLibrarian(rs.getBoolean("librarian"));
                user.setAdmin(rs.getBoolean("admin"));
                user.setBlocked(rs.getBoolean("blocked"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_USER_NAME_SURNAME_PASS);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return getUserById(user.getId());
    }

    @Override
    public int getUserIdByEmail(String email) {
        int id = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.GET_ID_BY_EMAIL);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_user");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return id;
    }

    @Override
    public boolean validate(String name, String pass) {
        boolean status = false;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.VALIDATION_OF_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pass);
            rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        }
        return status;
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
