package com.example.hussam.it_ebooks.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hussam.it_ebooks.model.Book;
import com.example.hussam.it_ebooks.BookAdapter;
import com.example.hussam.it_ebooks.model.BookResponse;
import com.example.hussam.it_ebooks.R;
import com.example.hussam.it_ebooks.rest.ApiClient;
import com.example.hussam.it_ebooks.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultsActivity extends AppCompatActivity {

    private static final String TAG = ResultsActivity.class.getSimpleName();
    BookResponse bookResponse;
    List<Book> books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        final Bundle bundle=getIntent().getExtras();
        String query=bundle.getString("query");

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<BookResponse> call = apiService.getBooksResponse(query);

        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {

                int statusCode = response.code();

                    bookResponse=response.body();
                    books=bookResponse.getBooks();
                if(books!=null) {
                    BookAdapter bookAdapter = new BookAdapter(getApplicationContext(), books);
                    ListView listView = (ListView) findViewById(R.id.booksList);
                    listView.setAdapter(bookAdapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            String bookID = books.get(position).getId();

                            Bundle b = new Bundle();

                            b.putString("id", bookID);
                            Intent intent = new Intent(view.getContext(), BookInformation.class);
                            intent.putExtras(b);

                            startActivity(intent);
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"We are sorry , No Books were found !",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });




    }


}
