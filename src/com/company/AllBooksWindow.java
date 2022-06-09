package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllBooksWindow extends JFrame implements ActionListener
{
    Repository repo;
    MainWinow parent;

    JLabel label1;
    JLabel label2;

    DefaultListModel<Borrowing> allBookListModel;
    JList<Borrowing> allBooklist;

    JButton showBookDetailsButton;



    public AllBooksWindow(Repository repository, MainWinow mainWinow)
    {
        repo = repository;
        parent = mainWinow;

        setSize(1080, 720);
        setLayout(null);


        label1 = new JLabel("Ksiazka");
        label1.setBounds(100,10,250,20);
        add(label1);

        label2 = new JLabel("Wyporzyczone przez");
        label2.setBounds(100 + 250 + 10, 10, 250, 20);
        add(label2);
        allBookListModel = new DefaultListModel<Borrowing>();
        allBooklist = new JList<Borrowing>(allBookListModel);
        allBooklist.setBounds(100,  50, 500, 500);
        add(allBooklist);

        for (Borrowing borrowing : repo._borrowings)
        {
            if(!borrowing.returned)
                allBookListModel.addElement(borrowing);
        }
        for(Book book : repo._books)
        {
            Borrowing temporaryBorowing = new Borrowing(new User("", User.Type.REGULAR,"",""), book);
            allBookListModel.addElement(temporaryBorowing);
        }

        showBookDetailsButton = new JButton("Pokarz szczeguly ksiazki");
        showBookDetailsButton.setBounds(100, 50 + 500 + 10, 300, 50);
        showBookDetailsButton.addActionListener(this);
        add(showBookDetailsButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == showBookDetailsButton)
        {
            try
            {
                Book book = allBooklist.getSelectedValue()._book;
                AddBookWindow addBookWindow = new AddBookWindow(repo, parent, book, false);
            }
            catch (Exception ex)
            {

            }

        }
    }
}
