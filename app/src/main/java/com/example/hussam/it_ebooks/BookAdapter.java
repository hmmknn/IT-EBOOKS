package com.example.hussam.it_ebooks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hussam.it_ebooks.model.Book;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Hussam on 8/18/2016.
 */
public class BookAdapter extends ArrayAdapter {
     List<Book> books;

    public BookAdapter(Context context, List<Book> objects) {
        super(context, 0, objects);
        books=objects;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

   @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Book book= (Book) getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.booktitle);
        title.setText(book.getTitle());
        ImageView imageView=(ImageView)listItemView.findViewById(R.id.bookimage);
        Picasso.with(getContext()).load(book.getImage()).into(imageView);
        return listItemView;
    }
}
