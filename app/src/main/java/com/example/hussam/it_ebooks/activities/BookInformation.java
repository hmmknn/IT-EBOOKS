package com.example.hussam.it_ebooks.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hussam.it_ebooks.R;
import com.example.hussam.it_ebooks.model.BookDetails;
import com.example.hussam.it_ebooks.rest.ApiClient;
import com.example.hussam.it_ebooks.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookInformation extends AppCompatActivity {
   BookDetails  bookDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_information);


        Bundle b=getIntent().getExtras();
        final String bookID=b.getString("id");


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<BookDetails> call = apiService.getBookDetails(bookID);
        call.enqueue(new Callback<BookDetails>() {
            @Override
            public void onResponse(Call<BookDetails> call, Response<BookDetails> response) {

                int statusCode = response.code();
                bookDetails = (BookDetails) response.body();
                String msgError = "Book not found!";
                if (bookDetails.getError().equals(msgError)) {
                    Toast.makeText(getApplicationContext(), "Book Information >> " + msgError, Toast.LENGTH_LONG).show();
                } else {
                    TextView title = (TextView) findViewById(R.id.txttitle);
                    title.setText(bookDetails.getTitle());

                    TextView subtitle = (TextView) findViewById(R.id.txtsub);
                    subtitle.setText(bookDetails.getSubTitle());

                    TextView desc = (TextView) findViewById(R.id.txtdesc);
                    desc.setText(bookDetails.getDescription());

                    TextView page = (TextView) findViewById(R.id.txtpage);
                    page.setText("Number Of Pages : " + bookDetails.getPage());

                    TextView year = (TextView) findViewById(R.id.txtyear);
                    year.setText("Year : " + bookDetails.getYear());

                    TextView author = (TextView) findViewById(R.id.txtauthor);
                    author.setText("Author : " + bookDetails.getAuthor());

                    TextView isbn = (TextView) findViewById(R.id.txtisbn);
                    isbn.setText("ISBN : " + bookDetails.getISBN());

                    TextView pub = (TextView) findViewById(R.id.txtpub);
                    pub.setText("Publisher : " + bookDetails.getPublisher());

                    TextView link = (TextView) findViewById(R.id.txtdownload);
                    link.setText(bookDetails.getDownload());

                    ImageView imageView = (ImageView) findViewById(R.id.imageinfo);
                    Picasso.with(getApplicationContext()).load(bookDetails.getImage()).into(imageView);

                }
            }




            @Override
            public void onFailure(Call<BookDetails> call, Throwable t) {
                // Log error here since request failed
                Log.e(this.getClass().getSimpleName(), t.toString());
            }
        });


    }
}
