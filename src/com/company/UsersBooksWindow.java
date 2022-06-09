package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsersBooksWindow extends JFrame implements ActionListener
{
    Repository repo;
    MainWinow parent;
    User user;


    DefaultListModel<Book> userBookListModel;
    JList<Book> userBookJlist;

    JButton showBookDetailsButton;



    public UsersBooksWindow(Repository repository, MainWinow parentWindow, User selectedUser)
    {
        repo = repository;
        parent = parentWindow;
        user = selectedUser;

        setTitle("Ksiazki urzytkoanika: " + user._name);
        setLayout(null);
        setSize(1080, 720);


        userBookListModel = new DefaultListModel<Book>();
        userBookJlist = new JList<Book>(userBookListModel);
        add(userBookJlist);

        userBookJlist.setBounds(100,  50, 500, 500);
        for(Book book : selectedUser._books)
        {
            userBookListModel.addElement(book);
        }

        showBookDetailsButton = new JButton("Pokaz szczeguly ksiazki");
        showBookDetailsButton.setBounds(600, 50, 300, 50);
        showBookDetailsButton.addActionListener(this);
        add(showBookDetailsButton);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == showBookDetailsButton)
        {
            Book book = userBookJlist.getSelectedValue();
            AddBookWindow showBookDetailsWidonw = new AddBookWindow(repo, parent, book, true);
        }
    }
}
