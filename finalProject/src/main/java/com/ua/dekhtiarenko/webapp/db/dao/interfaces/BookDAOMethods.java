package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface BookDAOMethods {

    void insertBook(Book book);

    List<Book> getListBook(String genre);

    Book readingResultSet(ResultSet resultSet);

    int getBookIdByName(String nameOfBook);

    String getNameOfBookById(int bookId);

    Book getBookByName(String name);

    void reduceBookAvailabilityById(int id_book);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
