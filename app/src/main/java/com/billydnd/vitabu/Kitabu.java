package com.billydnd.vitabu;

/**
 * Created by Billy on 5/27/2020.
 */
public class Kitabu {
    private String name;
   private String author;
   private int published_date;

    public Kitabu(String name, String author, int published_date) {
        this.name = name;
        this.author = author;
        this.published_date = published_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished_date() {
        return published_date;
    }

    public void setPublished_date(int published_date) {
        this.published_date = published_date;
    }
}
