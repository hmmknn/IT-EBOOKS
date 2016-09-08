package com.example.hussam.it_ebooks.rest;


import com.example.hussam.it_ebooks.model.BookDetails;
import com.example.hussam.it_ebooks.model.BookResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiInterface {

    @GET("search/{query}")
    Call<BookResponse> getBooksResponse(@Path("query") String query);

    @GET("/search/{query}/page/{number}")
    Call<BookResponse> getMoreBooksResponse(@Path("query") String query,@Path("number") String number);

    @GET("book/{id}")
    Call<BookDetails> getBookDetails(@Path("id") String bookID);
}