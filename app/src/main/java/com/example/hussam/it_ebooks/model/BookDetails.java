package com.example.hussam.it_ebooks.model;

import com.example.hussam.it_ebooks.model.Book;

/**
 * Created by Hussam on 8/18/2016.
 */
public class BookDetails extends Book {


    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    private String Error;
    private String Time;
    private String Author;
    private String ISBN;
    private String Page;
    private String Year;
    private String Publisher;
    private String Download;

    public BookDetails(String id, String title, String subTitle, String description, String image, String error, String time, String author, String ISBN, String page, String  year, String publisher, String download) {
        super(id, title, subTitle, description, image);
        Error = error;
        Time = time;
        Author = author;
        this.ISBN = ISBN;
        Page = page;
        Year = year;
        Publisher = publisher;
        Download = download;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getDownload() {
        return Download;
    }

    public void setDownload(String download) {
        Download = download;
    }



}
