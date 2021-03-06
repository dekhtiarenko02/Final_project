package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.UserDAO;
import com.ua.dekhtiarenko.webapp.db.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class UserDAOImpl implements UserDAO {

    private final Logger logger = Logger.getLogger(UserDAOImpl.class);
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;

    /**
     * Insert user.
     *
     * @param user
     */
    @Override
    public void insertUser(User user) {
        logger.info("Start insertUser");
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
        logger.info("Finished insertUser");
    }

    /**
     * Return user by id.
     *
     * @param id
     * @return user.
     */
    @Override
    public User getUserById(int id) {
        logger.info("Start getUserById");
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
        logger.info("Finished getUserById");
        return user;
    }

    /**
     * Update user.
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        logger.info("Start updateUser");
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_USER_NAME_SURNAME_PASS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished updateUser");
    }

    /**
     * Update user.
     *
     * @param user_id
     */
    @Override
    public void updateUser(User user, int user_id) {
        logger.info("Start updateUser");
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setBoolean(3, user.getLibrarian());
            preparedStatement.setBoolean(4, user.getAdmin());
            preparedStatement.setBoolean(5, user.getBlocked());
            preparedStatement.setInt(6, user_id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished updateUser");
    }

    /**
     * Return list of user.
     *
     * @return userList.
     */
    @Override
    public List<User> getUserList() {
        logger.info("Start getUserList");
        List<User> userList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_USER);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userList.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Finished getUserList");
        return userList;
    }

    /**
     * Returns book by resultSet.
     *
     * @param resultSet
     * @return subscription book.
     */
    @Override
    public User readingResultSet(ResultSet resultSet) {
        logger.info("Start readingResultSet");
        User user = new User();
        try {
            user.setId(resultSet.getInt("id_user"));
            user.setEmail(resultSet.getString("email"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setLibrarian(resultSet.getBoolean("librarian"));
            user.setAdmin(resultSet.getBoolean("admin"));
            user.setBlocked(resultSet.getBoolean("blocked"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        logger.info("Finished readingResultSet");
        return user;
    }

    /**
     * Return user id by email.
     *
     * @param email
     * @return id
     */
    @Override
    public int getUserIdByEmail(String email) {
        logger.info("Start getUserIdByEmail");
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
        logger.info("Finished getUserIdByEmail");
        return id;
    }

    /**
     * Return true or false auntification.
     *
     * @param name
     * @return status
     */
    @Override
    public boolean exists(String name, String pass) {
        logger.info("Start exists");
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
        logger.info("Finished exists");
        return status;
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
