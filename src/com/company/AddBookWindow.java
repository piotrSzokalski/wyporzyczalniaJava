package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//  Ctrl + /


public class AddBookWindow extends JFrame implements ActionListener
{
    Repository repo;
    Boolean chaneExistingBook;
    Book book;

    JLabel titleLable;
    JLabel authorLabel;
    JLabel pubisherLabel;
    JLabel publisDateLable;
    JLabel genereLabel;
    JLabel numberOfPagesLabel;
    JLabel dimentionsLabel;
    JLabel widthLabel;
    JLabel lenghtLabel;
    JLabel heightLabel;
    JLabel descryptionLabel;


    JTextField titleTextField;
    JTextField authorTextField;
    JTextField publisherTextField;
    JTextField publisDateTextField;
    JTextField genereTextField;
    JTextField numOfPagesTextField;
    JTextField widthTextField;
    JTextField heightTextField;
    JTextField lenghtTextField;
    JTextArea descryptionTextField;


    JButton addBookToRepositoryButton;

    MainWinow parrent;

    public AddBookWindow(Repository repository, MainWinow parrentWindow)
    {
        parrent = parrentWindow;
        repo = repository;
        chaneExistingBook = false;

        setTitle("Dodaj ksiazke");
        setSize(1080, 900);
        setLayout(null);

        int x = 10;
        int y = 10;
        int w = 400;
        int h = 50;

        titleLable = new JLabel("Tytul");
        titleLable.setBounds(x, y, w, h );
        y += (h + 10);
        titleTextField = new JTextField();
        titleTextField.setBounds(x, y, w, h);
        y += (h + 1);

        authorLabel = new JLabel("Autor");
        authorLabel.setBounds(x, y, w, h);
        y += (h + 1);
        authorTextField = new JTextField();
        authorTextField.setBounds(x, y, w, h);
        y += (h + 1);

        pubisherLabel = new JLabel("Wydawca");
        pubisherLabel.setBounds(x, y, w, h);
        y += (h + 1);
        publisherTextField = new JTextField();
        publisherTextField.setBounds(x, y, w, h);
        y += (h + 1);

        publisDateLable = new JLabel("Data wydania");
        publisDateLable.setBounds(x, y, w, h);
        y += (h + 1);
        publisDateTextField = new JTextField();
        publisDateTextField.setBounds(x, y, w, h);
        y += (h + 1);

        genereLabel = new JLabel("Gatunek");
        genereLabel.setBounds(x, y, w, h);
        y += (h + 1);
        genereTextField = new JTextField();
        genereTextField.setBounds(x, y, w, h);
        y += (h + 1);

        numberOfPagesLabel = new JLabel("Ilosc stron");
        numberOfPagesLabel.setBounds(x, y, w, h);
        y += (h + 10);
        numOfPagesTextField = new JTextField();
        numOfPagesTextField.setBounds(x, y, w, h);
        y += (h + 10);

        x = h;
        dimentionsLabel = new JLabel("Wymiary");
        dimentionsLabel.setBounds(x, y, w, h);
        y += (h + 10);
        x = 0;
        lenghtLabel = new JLabel("dlugosc");
        lenghtLabel.setBounds(x, y, w, h);
        x += (100 + 10);
        widthLabel = new JLabel("szerokosc");
        widthLabel.setBounds(x, y, w, h);
        x += (100 + 10);
        heightLabel = new JLabel("wysokosc");
        heightLabel.setBounds(x, y, w, h);
        x = 0;
        y += (h/2 + 10);
        lenghtTextField = new JTextField();
        lenghtTextField.setBounds(x, y, w/3, h);
        x += (100 + 10);
        widthTextField = new JTextField();
        widthTextField.setBounds(x, y, w/3, h);
        x += (100 + 10);
        heightTextField = new JTextField();
        heightTextField.setBounds(x, y, w/3, h);

        y = 0;
        descryptionLabel = new JLabel("Opis");
        descryptionLabel.setBounds(w + 10, 0, w, h);
        descryptionTextField = new JTextArea();
        y += (h + 10);
        descryptionTextField.setBounds(w + 10, y, w, w);

        addBookToRepositoryButton = new JButton("Dodaj");
        addBookToRepositoryButton.setBounds(600,y + 400,500,200);
        addBookToRepositoryButton.addActionListener(this);

        add(titleLable);
        add(authorLabel);
        add(pubisherLabel);
        add(publisDateLable);
        add(genereLabel);
        add(numberOfPagesLabel);
        add(dimentionsLabel);
        add(widthLabel);
        add(lenghtLabel);
        add(heightLabel);
        add(descryptionLabel);

        add(titleTextField);
        add(authorTextField);
        add(publisherTextField);
        add(publisDateTextField);
        add(genereTextField);
        add(numOfPagesTextField);
        add(widthTextField);
        add(heightTextField);
        add(lenghtTextField);
        add(descryptionTextField);

        add(addBookToRepositoryButton);

        setVisible(true);
    }

    public AddBookWindow(Repository repository, MainWinow parrentWindow, Book bookToChange)
    {
        chaneExistingBook = true;
        parrent = parrentWindow;
        book = bookToChange;

        repo = repository;

        setTitle("Edytuj ksiazke");
        setSize(1600, 900);
        setLayout(null);

        int x = 10;
        int y = 10;
        int w = 400;
        int h = 50;

        titleLable = new JLabel("Tytul");
        titleLable.setBounds(x, y, w, h );
        y += (h + 10);
        titleTextField = new JTextField(book._title);
        titleTextField.setBounds(x, y, w, h);
        y += (h + 1);

        authorLabel = new JLabel("Autor");
        authorLabel.setBounds(x, y, w, h);
        y += (h + 1);
        authorTextField = new JTextField(book._author);
        authorTextField.setBounds(x, y, w, h);
        y += (h + 1);

        pubisherLabel = new JLabel("Wydawca");
        pubisherLabel.setBounds(x, y, w, h);
        y += (h + 1);
        publisherTextField = new JTextField(book._publisher);
        publisherTextField.setBounds(x, y, w, h);
        y += (h + 1);


        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(book._publishDate);
        publisDateLable = new JLabel("Data wydania");
        publisDateLable.setBounds(x, y, w, h);
        y += (h + 1);
        publisDateTextField = new JTextField(strDate);
        publisDateTextField.setBounds(x, y, w, h);
        y += (h + 1);

        genereLabel = new JLabel("Gatunek");
        genereLabel.setBounds(x, y, w, h);
        y += (h + 1);
        genereTextField = new JTextField(book._genere);
        genereTextField.setBounds(x, y, w, h);
        y += (h + 1);

        numberOfPagesLabel = new JLabel("Ilosc stron");
        numberOfPagesLabel.setBounds(x, y, w, h);
        y += (h + 10);
        numOfPagesTextField = new JTextField(String.valueOf(book._numberOfPages));
        numOfPagesTextField.setBounds(x, y, w, h);
        y += (h + 10);

        x = h;
        dimentionsLabel = new JLabel("Wymiary");
        dimentionsLabel.setBounds(x, y, w, h);
        y += (h + 10);
        x = 0;
        lenghtLabel = new JLabel("dlugosc");
        lenghtLabel.setBounds(x, y, w, h);
        x += (100 + 10);
        widthLabel = new JLabel("szerokosc");
        widthLabel.setBounds(x, y, w, h);
        x += (100 + 10);
        heightLabel = new JLabel("wysokosc");
        heightLabel.setBounds(x, y, w, h);
        x = 0;
        y += (h/2 + 10);
        lenghtTextField = new JTextField(String.valueOf(book._dimentions.l));
        lenghtTextField.setBounds(x, y, w/3, h);
        x += (100 + 10);
        widthTextField = new JTextField(String.valueOf(book._dimentions.w));
        widthTextField.setBounds(x, y, w/3, h);
        x += (100 + 10);
        heightTextField = new JTextField(String.valueOf(book._dimentions.h));
        heightTextField.setBounds(x, y, w/3, h);

        y = 0;
        descryptionLabel = new JLabel("Opis");
        descryptionLabel.setBounds(w + 10, 0, w, h);
        descryptionTextField = new JTextArea(book._description);
        y += (h + 10);
        descryptionTextField.setBounds(w + 10, y, w, w);

        addBookToRepositoryButton = new JButton("Zmien");
        addBookToRepositoryButton.setBounds(600,y + 400,500,200);
        addBookToRepositoryButton.addActionListener(this);

        add(titleLable);
        add(authorLabel);
        add(pubisherLabel);
        add(publisDateLable);
        add(genereLabel);
        add(numberOfPagesLabel);
        add(dimentionsLabel);
        add(widthLabel);
        add(lenghtLabel);
        add(heightLabel);
        add(descryptionLabel);

        add(titleTextField);
        add(authorTextField);
        add(publisherTextField);
        add(publisDateTextField);
        add(genereTextField);
        add(numOfPagesTextField);
        add(widthTextField);
        add(heightTextField);
        add(lenghtTextField);
        add(descryptionTextField);

        add(addBookToRepositoryButton);


        setVisible(true);
    }
    public AddBookWindow(Repository repository, MainWinow parrentWindow, Book bookToChange, boolean dontChange)
    {
        chaneExistingBook = true;
        parrent = parrentWindow;
        book = bookToChange;

        repo = repository;

        setTitle("Szczeguly ksiazki");
        setSize(1600, 900);
        setLayout(null);

        int x = 10;
        int y = 10;
        int w = 400;
        int h = 50;

        titleLable = new JLabel("Tytul");
        titleLable.setBounds(x, y, w, h );
        y += (h + 10);
        titleTextField = new JTextField(book._title);
        titleTextField.setBounds(x, y, w, h);
        y += (h + 1);

        authorLabel = new JLabel("Autor");
        authorLabel.setBounds(x, y, w, h);
        y += (h + 1);
        authorTextField = new JTextField(book._author);
        authorTextField.setBounds(x, y, w, h);
        y += (h + 1);

        pubisherLabel = new JLabel("Wydawca");
        pubisherLabel.setBounds(x, y, w, h);
        y += (h + 1);
        publisherTextField = new JTextField(book._publisher);
        publisherTextField.setBounds(x, y, w, h);
        y += (h + 1);


        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(book._publishDate);
        publisDateLable = new JLabel("Data wydania");
        publisDateLable.setBounds(x, y, w, h);
        y += (h + 1);
        publisDateTextField = new JTextField(strDate);
        publisDateTextField.setBounds(x, y, w, h);
        y += (h + 1);

        genereLabel = new JLabel("Gatunek");
        genereLabel.setBounds(x, y, w, h);
        y += (h + 1);
        genereTextField = new JTextField(book._genere);
        genereTextField.setBounds(x, y, w, h);
        y += (h + 1);

        numberOfPagesLabel = new JLabel("Ilosc stron");
        numberOfPagesLabel.setBounds(x, y, w, h);
        y += (h + 10);
        numOfPagesTextField = new JTextField(String.valueOf(book._numberOfPages));
        numOfPagesTextField.setBounds(x, y, w, h);
        y += (h + 10);

        x = h;
        dimentionsLabel = new JLabel("Wymiary");
        dimentionsLabel.setBounds(x, y, w, h);
        y += (h + 10);
        x = 0;
        lenghtLabel = new JLabel("dlugosc");
        lenghtLabel.setBounds(x, y, w, h);
        x += (100 + 10);
        widthLabel = new JLabel("szerokosc");
        widthLabel.setBounds(x, y, w, h);
        x += (100 + 10);
        heightLabel = new JLabel("wysokosc");
        heightLabel.setBounds(x, y, w, h);
        x = 0;
        y += (h/2 + 10);
        lenghtTextField = new JTextField(String.valueOf(book._dimentions.l));
        lenghtTextField.setBounds(x, y, w/3, h);
        x += (100 + 10);
        widthTextField = new JTextField(String.valueOf(book._dimentions.w));
        widthTextField.setBounds(x, y, w/3, h);
        x += (100 + 10);
        heightTextField = new JTextField(String.valueOf(book._dimentions.h));
        heightTextField.setBounds(x, y, w/3, h);

        y = 0;
        descryptionLabel = new JLabel("Opis");
        descryptionLabel.setBounds(w + 10, 0, w, h);
        descryptionTextField = new JTextArea(book._description);
        y += (h + 10);
        descryptionTextField.setBounds(w + 10, y, w, w);



        add(titleLable);
        add(authorLabel);
        add(pubisherLabel);
        add(publisDateLable);
        add(genereLabel);
        add(numberOfPagesLabel);
        add(dimentionsLabel);
        add(widthLabel);
        add(lenghtLabel);
        add(heightLabel);
        add(descryptionLabel);

        add(titleTextField);
        add(authorTextField);
        add(publisherTextField);
        add(publisDateTextField);
        add(genereTextField);
        add(numOfPagesTextField);
        add(widthTextField);
        add(heightTextField);
        add(lenghtTextField);
        add(descryptionTextField);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == addBookToRepositoryButton)
        {
            System.out.println("Adding book");
            try
            {
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(publisDateTextField.getText());

                int w = Integer.parseInt(widthTextField.getText());
                int l = Integer.parseInt(lenghtTextField.getText());
                int h = Integer.parseInt(heightTextField.getText());

                Book newBook = new Book
                        (
                            titleTextField.getText(),
                            authorTextField.getText(),
                            publisherTextField.getText(),
                            date,
                            genereTextField.getText(),
                            descryptionTextField.getText(),
                            Integer.parseInt(numOfPagesTextField.getText()),
                            new Dimentions(w, h, l)
                        );

                if(chaneExistingBook)
                {
                    repo.removeBook(book);
                }

                repo.addBook(newBook);
                System.out.println("Book succesfulty added");
                parrent.refreashMainWinow();
            }
            catch (Exception exception)
            {
                System.out.println("/nException enucunterd/n");
                exception.printStackTrace();
            }
        }
    }
}
