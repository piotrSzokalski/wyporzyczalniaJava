package com.company;

import java.util.ArrayList;
import java.io.Serializable;

public class User implements Serializable
{
    enum Type { REGULAR, ADMIN, EMPLOYEE }


    int             _ID;
    String          _name;
    Type            _type;
    ArrayList<Book> _books;
    String          _password;
    String          _homeAdress;

    static int lastID = 0;

    public int get_ID()                 { return _ID;   }
    public String get_name()            { return _name; }
    public Type get_type()              { return _type; }
    public ArrayList<Book> get_books()  { return _books;}

    public User(String name, Type type, String password, String homeAdress)
    {
        _name = name;
        _type = type;
        _ID = lastID + 1;
        lastID++;

        _books = new ArrayList<Book>();

        _password = password;

        _homeAdress = homeAdress;
    }

    public void requestBook(Book book, Repository repository)
    {

    }
    public void returnBook(Book book)
    {

    }

    @Override
    public String toString()
    {
        return _ID + "|\t " + _name + " |\t " + _type + " |\t " + _homeAdress + " |\n";

    }
}
