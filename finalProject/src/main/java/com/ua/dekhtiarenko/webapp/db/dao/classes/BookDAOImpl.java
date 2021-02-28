package com.ua.dekhtiarenko.webapp.db.dao.classes;

import com.ua.dekhtiarenko.webapp.db.connection.DBManager;
import com.ua.dekhtiarenko.webapp.db.dao.constant.Request;
import com.ua.dekhtiarenko.webapp.db.dao.interfaces.BookDAO;
import com.ua.dekhtiarenko.webapp.db.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class BookDAOImpl implements BookDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;


    /**
     * Returns List of books by name of book or author.
     *
     * @param bookOrAuthor
     * @return List of books.
     */
    @Override
    public List<Book> getBooksByNameOrAuthor(String bookOrAuthor) {
        List<Book> book = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_BOOK_FROM_BOOK_BY_NAME_OR_AUTHOR);
            preparedStatement.setString(1, "%" + bookOrAuthor + "%");
            preparedStatement.setString(2, "%" + bookOrAuthor + "%");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                book.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return book;
    }

    /**
     * Insert book.
     *
     * @param book
     */
    @Override
    public void insertBook(Book book) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.INSERT_INTO_BOOK);
            preparedStatement.setString(1, book.getGenre());
            preparedStatement.setString(2, book.getUrlImg());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getNameOfBook());
            preparedStatement.setString(5, book.getPublisher());
            preparedStatement.setInt(6, book.getYear());
            preparedStatement.setInt(7, book.getAvailability());
            preparedStatement.setInt(8, book.getNumberOfPages());
            preparedStatement.setString(9, book.getLanguage());
            preparedStatement.setString(10, book.getPlot());
            preparedStatement.setBoolean(11, book.getIsOrder());
            preparedStatement.executeUpdate();
            book.setId(book.getId());
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    /**
     * Returns book by resultSet.
     *
     * @param resultSet
     * @return book.
     */

    @Override
    public Book readingResultSet(ResultSet resultSet) {
        Book book = new Book();
        try {
            book.setId(resultSet.getInt("id_book"));
            book.setGenre(resultSet.getString("genre"));
            book.setUrlImg(resultSet.getString("urlImg"));
            book.setAuthor(resultSet.getString("author"));
            book.setNameOfBook(resultSet.getString("nameOfBook"));
            book.setPublisher(resultSet.getString("publisher"));
            book.setYear(resultSet.getInt("year"));
            book.setAvailability(resultSet.getInt("availability"));
            book.setNumberOfPages(resultSet.getInt("numberOfPages"));
            book.setLanguage(resultSet.getString("language"));
            book.setPlot(resultSet.getString("plot"));
            book.setOrder(resultSet.getBoolean("isOrder"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return book;
    }

    /**
     * Update book.
     *
     * @param book_id
     */
    @Override
    public void updateBook(Book book, int book_id) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_BOOK);
            preparedStatement.setString(1, book.getGenre());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getNameOfBook());
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setInt(5, book.getYear());
            preparedStatement.setInt(6, book.getAvailability());
            preparedStatement.setInt(7, book.getNumberOfPages());
            preparedStatement.setString(8, book.getLanguage());
            preparedStatement.setBoolean(9, book.getIsOrder());
            preparedStatement.setInt(10, book_id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    /**
     * Return list of book by genre.
     *
     * @param genre
     * @return bookList.
     */
    @Override
    public List<Book> getListBookByGenre(String genre) {
        List<Book> bookList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_BOOK_BY_GENRE);
            preparedStatement.setString(1, genre);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                bookList.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return bookList;
    }

    /**
     * Return sorted list of book by genre.
     *
     * @param genre
     * @return bookList.
     */
    @Override
    public List<Book> getListBookByGenreSorted(String genre, String sortBy) {
        List<Book> bookList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_BOOK_BY_GENRE + " ORDER BY " + sortBy);
            preparedStatement.setString(1, genre);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                bookList.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return bookList;
    }

    /**
     * Return book id by name of book.
     *
     * @param nameOfBook
     * @return id
     */
    @Override
    public int getBookIdByName(String nameOfBook) {
        int id = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_ID_FROM_BOOK_BY_NAME);
            preparedStatement.setString(1, nameOfBook);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_book");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return id;
    }

    /**
     * Return book by name.
     *
     * @param nameOfBook
     * @return book.
     */
    @Override
    public Book getBookByName(String nameOfBook) {
        Book book = new Book();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_BOOK_FROM_BOOK_BY_NAME);
            preparedStatement.setString(1, nameOfBook);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                book = readingResultSet(rs);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return book;
    }

    /**
     * Reduce book availability by id.
     *
     * @param id_book
     */
    @Override
    public void reduceBookAvailabilityById(int id_book) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_BOOK_SET_AVAILABILITY_MINUS);
            preparedStatement.setInt(1, id_book);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    /**
     * Increase book availability by id.
     *
     * @param id_book
     */
    @Override
    public void increaseBookAvailabilityById(int id_book) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_BOOK_SET_AVAILABILITY_PLUS);
            preparedStatement.setInt(1, id_book);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    /**
     * Delete book by id.
     *
     * @param book_id
     */
    @Override
    public void deleteBook(int book_id) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.DELETE_BOOK);
            preparedStatement.setInt(1, book_id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    /**
     * Return list of book.
     *
     * @return bookList
     */
    @Override
    public List<Book> getListBook() {
        List<Book> bookList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_FROM_BOOK);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                bookList.add(readingResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return bookList;
    }

    /**
     * Return availability by book id.
     *
     * @param book_id
     * @return availability
     */
    @Override
    public int getAvailabilityByBookId(int book_id) {
        int availability = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_AVAILABILITY_FROM_BOOK_BY_ID);
            preparedStatement.setInt(1, book_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                availability = rs.getInt("availability");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return availability;
    }

    /**
     * Update book order by name of book.
     *
     * @param nameOfBook
     */
    @Override
    public void updateBookOrderByNameOfBook(String nameOfBook) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.UPDATE_BOOK_SET_ORDER_BY_NAME_OF_BOOK);
            preparedStatement.setString(1, nameOfBook);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    /**
     * Return name of book by id.
     *
     * @param bookId
     * @return Name of book
     */
    @Override
    public String getNameOfBookById(int bookId) {
        String nameOfBook = "";
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Request.SELECT_BOOK_NAME_FROM_BOOK_BY_ID);
            preparedStatement.setInt(1, bookId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                nameOfBook = rs.getString("nameOfBook");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return nameOfBook;
    }

    /**
     * Closes resources.
     */
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
