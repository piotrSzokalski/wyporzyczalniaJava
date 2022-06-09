package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener
{
    Repository repo;

    MainWinow parent;

    JLabel headerlabel;

    JLabel usernameLabel;
    JTextField usernameTextField;

    JLabel passworLabel;
    JPasswordField passwordField;

    JButton loginButton;
    JButton registerButton;


    public LoginWindow(Repository repository, MainWinow parentGui)
    {
        repo = repository;
        parent = parentGui;

        setTitle("e-bibloteka login");
        setSize(720, 480);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //headerlabel.setBounds(1,1);

        usernameLabel = new JLabel("Nazwa urzytkowanika:");

        usernameTextField = new JTextField();
        add(usernameLabel);
        add(usernameTextField);

        passworLabel = new JLabel("haslo");
        passwordField = new JPasswordField();
        add(passworLabel);
        add(passwordField);

        loginButton = new JButton();
        add(loginButton);


        usernameLabel.setBounds(1,1,200, 50);
        usernameTextField.setBounds(1, 1 + 60,200,50);

        passworLabel.setBounds(1, 1 + 60 + 60 , 200, 50);
        passwordField.setBounds(1, 1 + 60 + 60 + 60, 200, 50);

        loginButton.setText("Zaloguj");
        loginButton.setBounds(300, 1 + 60 + 60 + 60 + 60, 100, 50);
        loginButton.addActionListener(this);

        registerButton = new JButton("Zarejestruj sie");
        registerButton.setBounds(0,1 + 5 * 60, 150,50);
        registerButton.addActionListener(this);
        add(registerButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == loginButton)
        {
            for(User user : repo._users)
            {
                if(user._name.equals(usernameTextField.getText()) )
                {
                    if(user._password.equals(String.valueOf(passwordField.getPassword())))
                    {
                        System.out.println("\nLOGIN SUCCESS user: " + user._name);
                        parent.currenUser = user;
                        //parent.setUserData();
                        parent.setVisible(true);
                        parent.refreashMainWinow();
                        setVisible(false);
                        dispose();
                    }
                }
            }

        }
        else if(e.getSource() == registerButton)
        {
            RegisterWindow registerWindow = new RegisterWindow(repo, parent);
            setVisible(false);
            dispose();
        }
    }

}
