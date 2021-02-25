package com.ua.dekhtiarenko.webapp.db.dao.constant;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class Request {

    public static final String CP_1251 = "cp1251";
    public static final String TEXT_HTML = "text/html";

    public static final String INSERT_INTO_USER = "INSERT INTO user(email, name, surname, librarian, admin, blocked, password) VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String VALIDATION_OF_USER = "SELECT * FROM user WHERE email = ? AND password = ?";
    public static final String SELECT_FROM_USER = "SELECT* FROM user";
    public static final String GET_USER_BY_ID = "SELECT* FROM user WHERE id_user = ?";
    public static final String GET_ID_BY_EMAIL = "SELECT id_user FROM user WHERE email = ?";
    public static final String UPDATE_USER_NAME_SURNAME_PASS = "UPDATE user SET name = ?, surname= ?, password= ? WHERE id_user = ?";
    public static final String UPDATE_USER = "UPDATE user SET name = ?, surname= ?, librarian=?, admin=?, blocked=? WHERE id_user = ?";


    public static final String INSERT_INTO_BOOK = "INSERT INTO book (genre, urlImg, author, nameOfBook, publisher, year, availability, numberOfPages, language, plot, isOrder) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_FROM_BOOK_BY_GENRE = "SELECT* FROM book WHERE genre = ?";
    public static final String SELECT_FROM_BOOK = "SELECT* FROM book";
    public static final String SELECT_ID_FROM_BOOK_BY_NAME = "SELECT id_book FROM book WHERE nameOfBook = ?";
    public static final String SELECT_BOOK_NAME_FROM_BOOK_BY_ID = "SELECT nameOfBook FROM book WHERE id_book = ?";
    public static final String SELECT_BOOK_FROM_BOOK_BY_NAME = "SELECT* FROM book WHERE nameOfBook LIKE ?";
    public static final String SELECT_BOOK_FROM_BOOK_BY_AUTHOR = "SELECT* FROM book WHERE author LIKE ?";
    public static final String UPDATE_BOOK_SET_AVAILABILITY_PLUS = "UPDATE book SET availability = availability + 1 WHERE id_book = ?";
    public static final String UPDATE_BOOK_SET_AVAILABILITY_MINUS = "UPDATE book SET availability = availability - 1 WHERE id_book = ?";
    public static final String UPDATE_BOOK_SET_ORDER_BY_NAME_OF_BOOK = "UPDATE book SET isOrder = true WHERE nameOfBook = ?";
    public static final String SELECT_AVAILABILITY_FROM_BOOK_BY_ID = "SELECT availability FROM book WHERE id_book = ?";
    public static final String UPDATE_BOOK = "UPDATE book SET genre = ?, author= ?, nameOfBook=?, publisher=?, year=?, availability=?, numberOfPages=?, language=?, isOrder=? WHERE id_book = ?";
    public static final String DELETE_BOOK = "DELETE FROM book WHERE id_book = ?";


    public static final String INSERT_INTO_SUBSCRIPTION = "INSERT INTO subscription (penalty, user_id) VALUES (?, ?)";
    public static final String SELECT_ID_SUBSCRIPTION_BY_BOOK_ID = "SELECT id_subscription FROM subscription WHERE user_id = ?";
    public static final String SELECT_PENALTY_FROM_SUBSCRIPTION_BY_USER_ID = "SELECT penalty FROM subscription WHERE user_id = ?";
    public static final String SELECT_FROM_SUBSCRIPTION = "SELECT* FROM subscription";


    public static final String INSERT_INTO_SUBSCRIPTION_BOOK = "INSERT INTO subscriptionBook (dateOfPurchase, subscription_id, book_id) VALUES (?, ?, ?)";
    public static final String DELETE_FROM_SUBSCRIPTION_BOOK = "DELETE FROM subscriptionBook WHERE subscription_id = ? AND  book_id = ?";
    public static final String SELECT_FROM_SUBSCRIPTION_BOOK_BY_USER_ID = "SELECT* FROM subscriptionBook WHERE subscription_id = (SELECT id_subscription FROM subscription WHERE user_id = ?);";
    public static final String SELECT_FROM_SUBSCRIPTION_BOOK = "SELECT* FROM subscriptionBook";


    public Request() {

    }
}
