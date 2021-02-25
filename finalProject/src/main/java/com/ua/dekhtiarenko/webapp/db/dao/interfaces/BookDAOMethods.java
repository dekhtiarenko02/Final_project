package com.ua.dekhtiarenko.webapp.db.dao.interfaces;

import com.ua.dekhtiarenko.webapp.db.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public interface BookDAOMethods {

    void insertBook(Book book);

    List<Book> getListBook(String genre);

    List<Book> getListBook();

    List<Book> getBooksByNameOrAuthor(String bookOrAuthor);

    Book readingResultSet(ResultSet resultSet);

    int getBookIdByName(String nameOfBook);

    String getNameOfBookById(int bookId);

    Book getBookByName(String name);

    void reduceBookAvailabilityById(int id_book);

    void updateBookOrderByNameOfBook(String nameOfBook);

    void updateBook(Book book, int book_id);

    int getAvailabilityByBookId(int book_id);

    void deleteBook(int book_id);

    void increaseBookAvailabilityById(int id_book);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
