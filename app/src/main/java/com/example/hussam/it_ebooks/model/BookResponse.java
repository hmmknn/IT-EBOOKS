package com.example.hussam.it_ebooks.model;
import com.example.hussam.it_ebooks.model.Book;

import java.util.List;

/**
 * Created by Hussam on 9/3/2016.
 */
public class BookResponse {

   private String	Error ;

    private  String  Time	;

    private  int Total	;

    private  int Page	;

    private  List<Book> Books;

    public BookResponse(String error, String time, int total, int page, List<Book> books) {

        Error = error;
        Time = time;
        Total = total;
        Page = page;
        Books = books;
    }



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

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int page) {
        Page = page;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }





}
