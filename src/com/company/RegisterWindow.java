package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWindow extends JFrame implements ActionListener
{

    MainWinow parent;
    Repository repo;

    JLabel usernameLabel;
    JTextField usernameTextField;

    JLabel adressLabel;
    JTextField adressTexField;

    JLabel passworLabel;
    JPasswordField passwordField;

    JLabel repeatPasswordLabel;
    JPasswordField repeatPasswordField;


    JButton registerButton;

    public RegisterWindow(Repository repository, MainWinow parrentWindow)
    {
        repo = repository;
        parent = parrentWindow;

        setTitle("e-bibloteka login");
        setSize(920, 700);
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

        repeatPasswordLabel = new JLabel("powturz halo");
        repeatPasswordField = new JPasswordField();


        registerButton = new JButton();
        add(registerButton);


        usernameLabel.setBounds(1,1,200, 50);
        usernameTextField.setBounds(1, 1 + 60,200,50);

        adressLabel = new JLabel("podaj adress");
        adressLabel.setBounds(1, 1 + 2* 60 , 200, 50);
        add(adressLabel);

        adressTexField = new JTextField();
        adressTexField.setBounds(1, 1 + 3 * 60, 200, 50);
        add(adressTexField);

        passworLabel.setBounds(1, 1 + 4 * 60 , 200, 50);
        passwordField.setBounds(1, 1 + 5 * 60 , 200, 50);

        repeatPasswordLabel.setBounds(1, 1 + 6 * 60 , 200, 50);
        repeatPasswordField.setBounds(1, 1 + 7 * 60 , 200, 50);
        add(repeatPasswordLabel);
        add(repeatPasswordField);

        registerButton = new JButton("Zarejestruj sie");
        registerButton.setBounds(0,1 + 8 * 60, 150,50);
        registerButton.addActionListener(this);


        add(registerButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == registerButton)
        {
            String s1 = String.valueOf(passwordField.getPassword());
            String s2 = String.valueOf(repeatPasswordField.getPassword());

            if(s1.equals(s2))
            {
                User newUser = new User(usernameTextField.getText(), User.Type.REGULAR, String.valueOf(passwordField.getPassword()), adressTexField.getText());
                parent.currenUser = newUser;
                repo.addUser(newUser);
                parent.setVisible(true);
                parent.refreashMainWinow();
                setVisible(false);
                dispose();
            }

        }
    }
}
