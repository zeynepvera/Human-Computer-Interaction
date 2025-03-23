
package com.mycompany.human_computer;

import java.io.Serializable;


public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String isbn;
    private String genre; 


    public Book(String title, String author, String isbn,String genre) {

        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.genre=genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {

        return author;
    }

    public String getIsbn() {

        return isbn;
    }
     public String getGenre() { 
        return genre;
    }

    public void setGenre(String genre) { 
        this.genre = genre;
    }
    
    @Override
    public String toString(){
        
        return "TITLE: "+title+ " ,AUTHOR: "+ author+ " , ISBN: "+isbn  + ", Genre: " + genre;
    }

}
