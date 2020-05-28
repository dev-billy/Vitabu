package com.billydnd.vitabu;

/**
 * Created by Billy on 5/27/2020.
 */
public class Kitabu {
    private String name;
   private String author;
   private String published_date;
   private String descrption;

    public Kitabu(String name, String author, String published_date, String descrption) {
        this.name = name;
        this.author = author;
        this.published_date = published_date;
        this.descrption = descrption;
    }

    public String getName() {
        return name;
    }

    public String getDescrption(){
        return descrption;
    }



    public String getAuthor() {
        return author;
    }



    public String getPublished_date() {
        return published_date;
    }


}
