package com.company;

import java.io.*;

public class Main
{
    static Repository  repository;
    int userId;

    public static void main(String[] args)
    {
        deSerialize();
        //repository = new Repository();
        MainWinow mainPogram = new MainWinow(repository);

    }
    public static void  deSerialize()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("repository.ser");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            repository = (Repository)inputStream.readObject();
            System.out.println("deSerialization succes");
        }
        catch (IOException e)
        {
            System.out.println("IOException is caught");
            repository = new Repository();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException is caught");
            repository = new Repository();
        }

    }


}
