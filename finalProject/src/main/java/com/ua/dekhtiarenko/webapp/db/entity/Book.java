package com.ua.dekhtiarenko.webapp.db.entity;

/**
 * Created by Dekhtiarenko-Daniil on 25.02.2021.
 */

public class Book {

    private int id;
    private String genre;
    private String urlImg;
    private String author;
    private String nameOfBook;
    private String publisher;
    private int year;
    private int availability;
    private int numberOfPages;
    private String language;
    private String plot;
    private boolean isOrder;

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public boolean getIsOrder() {
        return isOrder;
    }

    public void setOrder(boolean order) {
        isOrder = order;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", author='" + author + '\'' +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", availability=" + availability +
                ", numberOfPages=" + numberOfPages +
                ", language='" + language + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
