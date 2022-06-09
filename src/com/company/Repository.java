package com.company;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Scanner;

class Penalty implements Serializable
{
    User _userP;
    int _penalty;

    public Penalty(User u, int p)
    {
        _userP = u;
        _penalty = p;
    }
}

public class Repository implements Serializable
{
    ArrayList<User>  _users;

    ArrayList<Book> _books;

    ArrayList<Borrowing> _borrowings;

    ArrayList<Penalty> _penalties;


    public  Repository()
    {
        _users = new ArrayList<>();
        _books = new ArrayList<>();
        _borrowings = new ArrayList<>();
        _penalties = new ArrayList<>();


        // do poprawy
        _users.add(new User("maciej", User.Type.ADMIN, "abc", "Slupsk Arciszewskigo 25"));
        _users.add(new User("Marcin Kowalski", User.Type.REGULAR, "kot", "Slupsk Arciszewskigo 15"));
        _users.add(new User("Andzjek Kwiatwoski", User.Type.REGULAR, "krowa", "Slupsk Arciszewskigo 65"));
        _users.add(new User("Grzegorz Brzeczyszczykiewicz", User.Type.REGULAR, "krowa", "Slupsk Slowackma 56"));
        _users.add(new User("Grzegorz Brzeczyszczykiewicz", User.Type.REGULAR, "dom", "Slupsk Domowskigo 265"));
        _users.add(new User("Grzegorz", User.Type.REGULAR, "1234", "a a a"));
        _users.add(new User("a", User.Type.ADMIN,"a", "a a a"));

        _books.add(new Book("Nad niebem", "Adam Mickeczicz"));
        _books.add(new Book("W pustyni i w paszcz", "Adam Mickeczicz"));
        _books.add(new Book("Pan Mateusz", "Ernest He-ming-way"));
        _books.add(new Book("Dewizon303", "Adam Mickeicicz"));
        _books.add(new Book("Lalka", "Boleslaw Prus"));
        _books.add(new Book("Jagnie i wilcy", "Grzegorz Brzeczymucha"));
    }

    //  adding books
    void addBook(Book book)
    {
        _books.add(book);
    }
    void removeBook(Book book)
    {
        _books.remove(book);
    }

    void addBooks(ArrayList<Book> books)
    {
        for(Book book : books)
        {
            _books.add(book);
        }
    }
    void addBookFromFile(String absoluteFilepath)
    {
        ArrayList<String> lines = readFileLines(absoluteFilepath);
        for(String line : lines)
        {
            String[] words =  line.split(";");
            if(words.length == 10)
            {
                Dimentions dim = new Dimentions(Integer.parseInt(words[7]), Integer.parseInt(words[8]), Integer.parseInt(words[9]));
                try
                {
                    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = formatter.parse(words[3]);

                    _books.add(new Book(words[0], words[1], words[2], date, words[4], words[5], Integer.parseInt(words[6]), dim));
                    System.out.println("Book succfully added");
                }
                catch (Exception ex)
                {

                }



            }
        }

    }

    //  tracking borrowings
    void addBorrowing(User user, Book book)
    {
        _borrowings.add(new Borrowing(user, book));
    }
    void changeStateOfBorrowings(User user, Book book)
    {
        System.out.println("here1");
        for(Borrowing borrowing : _borrowings)
        {
            System.out.println("here2");
            if(borrowing._book.equals(book) && borrowing._user.equals(user))
            {
                if(_penalties.size() == 0)
                    _penalties.add(new Penalty(user, borrowing.changeStateToReturned()));
                for(Penalty i : _penalties)
                {
                    if(i._userP == user)
                        i._penalty += borrowing.changeStateToReturned();
                    else
                        _penalties.add(new Penalty(user, borrowing.changeStateToReturned()));
                }
            }
            System.out.println("here4");
        }
        System.out.println("here5");
    }
    //  adding users
    void addUser(User user)
    {
        if(!_users.contains(user))
            _users.add(user);
    }
    void addUsers(ArrayList<User> users)
    {
        for(User user : users)
            if(!_users.contains(user))
                _users.add(user);
    }
    void addUserFromFile(String absoluteFilepath)
    {
        ArrayList<String> lines = readFileLines(absoluteFilepath);
        for(String line : lines)
        {
            String[] words =  line.split(";");
            if(words.length == 4)
            {
                User.Type userType;
                if(words[1] == "EMPLOYEE")
                    userType = User.Type.EMPLOYEE;
                else if(words[1] == "ADMIN")
                    userType = User.Type.ADMIN;
                else
                    userType = User.Type.REGULAR;

                _users.add(new User(words[0], userType, words[2], words[3]));
            }
        }
    }
    void removeUser(User user)
    {
        if(_users.contains(user))
            _users.remove(user);
    }

    //  providing books

    public void provideBook(User user, Book requestedBook)
    {

    }

    // private
    private static ArrayList<String> readFileLines(String path)
    {
        try
        {
            ArrayList<String> lines = new ArrayList<String>();
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                lines.add(scanner.nextLine());
            }
            return lines;
        }
        catch (Exception e)
        {
            System.out.println("Error reading file into lines");
            e.getStackTrace();
            return null;
        }
    }
}



