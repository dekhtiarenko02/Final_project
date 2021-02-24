package com.ua.dekhtiarenko.webapp.db.dao.constant;

public class Request {

    public static final String INSERT_INTO_USER = "INSERT INTO user(email, name, surname, librarian, admin, blocked, password) VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String VALIDATION_OF_USER = "SELECT * FROM user WHERE email = ? AND password = ?";
    public static final String SELECT_FROM_USER = "SELECT* FROM user";
    public static final String GET_USER_BY_ID = "SELECT* FROM user WHERE id_user = ?";
    public static final String GET_ID_BY_EMAIL = "SELECT id_user FROM user WHERE email = ?";
    public static final String UPDATE_USER_NAME_SURNAME_PASS = "UPDATE user SET name = ?, surname= ?, password= ? WHERE id_user = ?";


    public static final String INSERT_INTO_BOOK = "INSERT INTO book (genre, author, nameOfBook, publishingHouse, year, quantity, amountOfPages, language) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SELECT_FROM_BOOK_BY_GENRE = "SELECT* FROM book WHERE genre = ?";
    public static final String SELECT_ID_FROM_BOOK_BY_NAME = "SELECT id_book FROM book WHERE nameOfBook = ?";
    public static final String SELECT_BOOK_NAME_FROM_BOOK_BY_ID = "SELECT nameOfBook FROM book WHERE id_book = ?";
    public static final String SELECT_BOOK_FROM_BOOK_BY_NAME = "SELECT* FROM book WHERE nameOfBook = ?";
    public static final String UPDATE_BOOK_SET_AVAILABILITY = "UPDATE book SET availability = availability - 1 WHERE id_book = ?";


    public static final String INSERT_INTO_SUBSCRIPTION = "INSERT INTO subscription (penalty, user_id) VALUES (?, ?)";
    public static final String SELECT_ID_SUBSCRIPTION_BY_BOOK_ID = "SELECT id_subscription FROM subscription WHERE user_id = ?";
    public static final String SELECT_PENALTY_FROM_SUBSCRIPTION_BY_USER_ID = "SELECT penalty FROM subscription WHERE user_id = ?";


    public static final String INSERT_INTO_SUBSCRIPTION_BOOK = "INSERT INTO subscriptionBook (dateOfPurchase, subscription_id, book_id) VALUES (?, ?, ?)";
    public static final String SELECT_FROM_SUBSCRIPTION_BOOK_BY_USER_ID = "SELECT* FROM subscriptionBook WHERE subscription_id = (SELECT id_subscription FROM subscription WHERE user_id = ?);";

    public Request() {

    }
}
