package com.example.hussam.it_ebooks.model;

import android.net.Uri;

/**
 * Created by Hussam on 8/18/2016.
 */
public class Book {
   private String ID;
    private String Title;
    private String SubTitle;
    private String Description;
    private String Image;


    public Book(String id, String title, String subTitle, String description, String image) {
        ID = id;
        Title = title;
        SubTitle = subTitle;
        Description = description;
        Image =image;
    }



    public String getId() {
        return ID;
    }

    public void setId(String id) {
        ID = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


}
