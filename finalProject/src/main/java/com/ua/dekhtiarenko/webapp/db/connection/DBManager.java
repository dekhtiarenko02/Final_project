package com.ua.dekhtiarenko.webapp.db.connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DBManager {
    private static Connection conn = null;
    private static final Properties properties = new Properties();
    private static final String URL = "jdbc:mysql://localhost:3306/web_library?user=root&password=64ohelos&" +
            "serverTimezone=Europe/Kiev&useSSL=false";

    public DBManager() {

    }

    public static Connection getConnection() {
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
        } catch (SQLException e) {
            Logger.getLogger(e.getMessage());
        }
        return conn;
    }
}
