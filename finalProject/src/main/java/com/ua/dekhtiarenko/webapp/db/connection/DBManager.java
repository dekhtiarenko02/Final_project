package com.ua.dekhtiarenko.webapp.db.connection;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class DBManager {


    private static Connection conn = null;
    private static final Properties properties = new Properties();
    private static final Logger logger = Logger.getLogger(DBManager.class);
    private static final String URL = "jdbc:mysql://localhost:3306/web_library?user=root&password=64ohelos&" +
            "serverTimezone=Europe/Kiev&useSSL=false";

    public DBManager() {

    }

    /**
     * Returns a DB connection.
     *
     * @return DB connection.
     */
    public static Connection getConnection() {
        logger.info("Start DBManager");

        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "UTF-8");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(e.getMessage());
        }
        try {
            conn = DriverManager.getConnection(URL, properties);
            logger.info("Connection DBManager");
        } catch (SQLException e) {
            Logger.getLogger(e.getMessage());
        }
        return conn;
    }
}
