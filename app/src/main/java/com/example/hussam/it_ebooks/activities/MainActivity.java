package com.example.hussam.it_ebooks.activities;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import com.example.hussam.it_ebooks.R;
import com.example.hussam.it_ebooks.activities.ResultsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isOnline()) {
            Toast.makeText(this, "Please check your Internet Connection !", Toast.LENGTH_LONG).show();
        }


    }

    public void search(View view) {
        EditText query = (EditText) findViewById(R.id.querytext);
        String searchQuery = query.getText().toString();
        if (!searchQuery.isEmpty()) {
            Intent i = new Intent(view.getContext(), ResultsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("query", searchQuery);
            i.putExtras(bundle);
            startActivity(i);
        } else
            Toast.makeText(this, "Make sure you enter valid query!", Toast.LENGTH_LONG).show();


    }

    private boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }


}