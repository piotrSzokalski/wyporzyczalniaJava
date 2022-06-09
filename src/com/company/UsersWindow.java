package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class UsersWindow extends JFrame implements ActionListener
{
    Repository repo;
    MainWinow parent;

    JLabel userNameLabel;
    JLabel userIdLabel;
    JLabel userTypeLabel;

    JButton removeUserButton;
    JButton showUsersBooksButton;

    DefaultListModel<User> usersListModel;
    JList<User> usersList;

    public UsersWindow(Repository repository, MainWinow parrntWinow)
    {
        repo = repository;
        parent = parrntWinow;
        setLayout(null);
        setTitle("Urzytkownicy");
        setSize(1080, 720);


        int x = 0;
        int y = 0;
        int w = 300;
        int h = 50;

        userIdLabel = new JLabel("ID");
        userIdLabel.setBounds(x, y, w, h);
        add(userIdLabel);
        x += 350;
        userNameLabel = new JLabel("Nazwa");
        userNameLabel.setBounds(x, y, w, h);
        add(userNameLabel);
        x += 350;
        userTypeLabel = new JLabel("Typ");
        userTypeLabel.setBounds(x, y, w, h);
        add(userTypeLabel);
        x = 0;
        y += 200;

        usersListModel = new DefaultListModel<User>();
        usersList = new JList<>(usersListModel);
        usersList.setBounds(x, 100, 800, 500);
        add(usersList);
        x += 800;


        showUsersBooksButton = new JButton("Pokaz ksiazki");
        showUsersBooksButton.setBounds(x, y, w, h);
        showUsersBooksButton.addActionListener(this);
        add(showUsersBooksButton);

        y += h + 10;

        removeUserButton = new JButton("Usun");
        removeUserButton.setBounds(x, y, w, h);
        removeUserButton.addActionListener(this);
        add(removeUserButton);


        setVisible(true);
        refreash();
    }
    public void refreash()
    {
        usersListModel.clear();
        for(User user : repo._users)
        {
            usersListModel.addElement(user);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == removeUserButton)
        {
            try
            {
                User selectedUser = usersList.getSelectedValue();
                repo.removeUser(selectedUser);
                refreash();
                parent.refreashMainWinow();
            }
            catch (Exception ex)
            {

            }

        }
        else if(e.getSource() == showUsersBooksButton)
        {
            try
            {
                User user = usersList.getSelectedValue();
                UsersBooksWindow usersBooksWindow = new UsersBooksWindow(repo, parent, user);
            }
           catch (Exception ex)
           {

           }
        }
    }
}
