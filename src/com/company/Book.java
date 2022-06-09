package com.company;

import java.time.LocalTime;
import java.util.Date;
import java.io.Serializable;

class Dimentions implements Serializable
{
    public int w, h, l;
    public Dimentions(int W, int H, int L){ w = W; h = H; l = L; }
}

public class Book implements Serializable
{
    enum CoverType { PAPERBACK, HARDCOVER_CASEWRAP, HARDCOVER_DUST_JACKET }


    String      _title;
    String      _author;
    String      _publisher;
    Date        _publishDate;
    String      _genere;
    String      _description;
    int         _numberOfPages;
    Dimentions  _dimentions;

    public Book(String title, String author, String publisher, Date publishDate, String genere,
                String description, int numOfPages, Dimentions dim)
    {
        _title = title;
        _author = author;
        _publisher = publisher;
        _publishDate = publishDate;
        _genere = genere;
        _description = description;
        _numberOfPages = numOfPages;
        _dimentions = dim;
    }
    public Book(String title, String author)
    {
        _title = title;
        _author = author;
        _publisher = "unknown";
        _publishDate = new Date();
        _genere = "unknown";
        _description = "unknown";
        _numberOfPages = 0;
        _dimentions = new Dimentions(0,0,0);
    }

    @Override
    public String toString() {
        return "" +
                "'" + _title + '\'' +
                ", '" + _author + '\'';
    }
}
