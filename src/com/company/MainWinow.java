package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainWinow extends JFrame
{

    //
    Repository repo;
    User currenUser;

    // UI components

    // lists
    DefaultListModel<Book> repoBookListModel;
    DefaultListModel<Book> userBookListModel;

    JList<Book> repoBookJList;
    JList<Book> userBookJlist;

    // buttons
    JButton borrowBookButton;
    JButton returnBookButton;
    JButton showBookDetailsButton;

    JButton addBookButton;
    JButton addBooksFromFileButton;
    JButton changeBookDataButton;
    JButton removeBookButton;

    JButton manageUsersButton;
    JButton addUsersFromFileButton;

    JButton showAllBooksButton;

    JButton changeUserButton;

    JButton debugButton;

    //labels
    JLabel usernameLabel;




    public MainWinow(Repository repository)
    {
        repo = repository;


        currenUser = new User("", User.Type.REGULAR,"", "");
        //openLoginWindow(repository);


        repoBookListModel = new DefaultListModel<Book>();
        userBookListModel = new DefaultListModel<Book>();

        borrowBookButton = new JButton("wyporzycz");
        returnBookButton = new JButton("zwruc");
        debugButton = new JButton("debug");

        addBookButton = new JButton("dodaj ksiazke");
        removeBookButton = new JButton("usun ksiazke");

        usernameLabel = new JLabel();

        setTitle("e-bibloteka");
        setSize(1750, 720);
        setLayout(null);
        //
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Closed");
                serialize();
                //e.getWindow().dispose();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        changeUserButton =  new JButton("zmien urzytkowanika");


        int buttonWidth = 200;
        int butttoHeight =30;

        // buttons

        //  change user
        changeUserButton.setBounds(10,20,300,30);
        changeUserButton.addActionListener(new changeUserActionListener());
        add(changeUserButton);

        //  borrow
        borrowBookButton.setBounds(10,1 + 30 + 30,buttonWidth,30);
        borrowBookButton.addActionListener(new buttonBorrowActionListener());
        add(borrowBookButton);

        //  show book deatils
        showBookDetailsButton = new JButton("Pokaz szczeguly");
        showBookDetailsButton.setBounds(700, 650, buttonWidth, 30);
        showBookDetailsButton.addActionListener(new showBookDetailActionListener());
        add(showBookDetailsButton);


        //  return
        returnBookButton.setBounds(10 + 1 * buttonWidth + 10,1 + 30 + 30,buttonWidth,30);
        returnBookButton.addActionListener(new buttonReturnActionListener());
        add(returnBookButton);

        // remove book
        removeBookButton.setBounds(10 + 3 * buttonWidth + 10, 1 + 30, buttonWidth, 30);
        removeBookButton.addActionListener(new removeBookActionListener());
        add(removeBookButton);

        //  add book
        addBookButton.setBounds(10 + 4 * buttonWidth + 10, 1 + 30, buttonWidth, 30);
        addBookButton.addActionListener(new addBookActionListener());
        add(addBookButton);

        //add book from file
        addBooksFromFileButton = new JButton("Dodaj ksiazki z pilku");
        addBooksFromFileButton.setBounds(10 + 4 * buttonWidth + 10, 1 + 30 + 40, buttonWidth, 30);
        addBooksFromFileButton.addActionListener(new addBookFromFileActionListener());
        add(addBooksFromFileButton);

        //  change book
        changeBookDataButton = new JButton("Zmien dane o ksiazce");
        changeBookDataButton.setBounds(10 + 5 * buttonWidth + 10, 1 + 30, buttonWidth, 30);
        changeBookDataButton.addActionListener(new changeBookDataActionListener());
        add(changeBookDataButton);

        //  show all books and who is borrowing them
        showAllBooksButton = new JButton("Pokaz wszystkie ksiazki");
        showAllBooksButton.setBounds(10 + 5 * buttonWidth + 10, 1 + 30 + 40, buttonWidth, 30);
        showAllBooksButton.addActionListener(new showAllBooksActionListener());
        add(showAllBooksButton);

        //  manage users
        manageUsersButton = new JButton("Zarzadzaj urzytkowaniakmi");
        manageUsersButton.setBounds(10 + 6 * buttonWidth + 10, 1 + 30, buttonWidth, 30);
        manageUsersButton.addActionListener(new manageUsersButtonActionListener());
        add(manageUsersButton);

        //  add users from file
        addUsersFromFileButton = new JButton("Dodaj urzytkowanikow z pliku");
        addUsersFromFileButton.setBounds(10 + 6 * buttonWidth + 10, 1 + 30 + 40, buttonWidth, 30);
        addUsersFromFileButton.addActionListener(new addUsersFromFileActionListener());
        add(addUsersFromFileButton);



        //  debug
        debugButton.setBounds(200,800,100,100);
        debugButton.addActionListener(new debugButtonActionListener());
        add(debugButton);







        userBookJlist = new JList<Book>(userBookListModel);
        add(userBookJlist);

        repoBookJList = new JList<Book>(repoBookListModel);



        openLoginWindow(repo);

    }

    public void openLoginWindow(Repository repository)
    {
        LoginWindow loginGUI = new LoginWindow(repository, this);
    }

    public void refreashMainWinow()
    {

        //  username label
        setUserData();

        if(currenUser._type == User.Type.ADMIN || currenUser._type == User.Type.EMPLOYEE)
        {
            debugButton.setVisible(true);
            addBookButton.setVisible(true);
            addBooksFromFileButton.setVisible(true);
            addUsersFromFileButton.setVisible(true);
            changeBookDataButton.setVisible(true);
            showAllBooksButton.setVisible(true);
            removeBookButton.setVisible(true);
            manageUsersButton.setVisible(true);
        }
        else
        {
            debugButton.setVisible(false);
            addBookButton.setVisible(false);
            addBooksFromFileButton.setVisible(false);
            addUsersFromFileButton.setVisible(false);
            changeBookDataButton.setVisible(false);
            showAllBooksButton.setVisible(false);
            removeBookButton.setVisible(false);
            manageUsersButton.setVisible(false);
        }

    }

    public void setUserData()
    {

        repoBookJList.setBounds(700, 100 + 50, 500, 500);
        try
        {
            userBookListModel.clear();
            repoBookListModel.clear();
            usernameLabel.setText("Urzytkownik:  " + currenUser._name);
        }
        catch (Exception e)
        {

        }

        usernameLabel.setBounds(10,1,500, 15);
        add(usernameLabel);

        //  list of books in repository
        for(Book book : repo._books)
        {
            repoBookListModel.addElement(book);
        }




        add(repoBookJList);

        //  list of books borrowed by curren user
        for(Book book : currenUser._books)
        {
            userBookListModel.addElement(book);
        }


        userBookJlist.setBounds(100, 100 + 50, 500, 500);
    }

    public void serialize()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("repository.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(this.repo);
            outputStream.close();
            fileOutputStream.close();

            System.out.println("Repository has been sucessfuly serialized");
        }
        catch (Exception e)
        {
            System.out.println("Exception encauntered trying to serilaize repoziotry");
            System.out.println(e.getStackTrace());
        }
    }
    MainWinow returnRefrence()
    {
        return this;
    }
    private class buttonBorrowActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                Book book = repoBookJList.getSelectedValue();
                //int index = repoBookJList.getSelectedIndex();
                //repo._books.remove(book);
                //repoBookListModel.remove(index);
                //currenUser.requestBook(book, repo);

                if(book != null)
                {
                    currenUser._books.add(book);
                    repo.removeBook(book);
                    repo.addBorrowing(currenUser, book);
                    refreashMainWinow();
                }


                //currenUser._books.add(book);
                //userBookListModel.addElement(book);
            }
            catch (Exception ex)
            {

            }

        }
    }
    private class  buttonReturnActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                Book book = userBookJlist.getSelectedValue();
                int index = userBookJlist.getSelectedIndex();
                currenUser._books.remove(book);
                userBookListModel.remove(index);

                repoBookListModel.addElement(book);

                repo.changeStateOfBorrowings(currenUser, book);
            }
            catch (Exception ex)
            {

            }
        }
    }
    private class removeBookActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                int index = repoBookJList.getSelectedIndex();
                Book book = repoBookJList.getSelectedValue();
                repo._books.remove(book);
                repoBookListModel.remove(index);
            }
            catch (Exception ex)
            {

            }
        }
    }

    private class debugButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("\n");

            boolean add_a_user = true;

            for(User user : repo._users)
            {
                System.out.println("User:\t" + user._name + "books:");
                for(Book book : user._books)
                    System.out.println(book);
                System.out.println("\n");

                if(user._name.equals("a"))
                    add_a_user = false;
            }

            System.out.println("Books in repository:");
            for(Book book : repo._books)
                System.out.println(book);

            System.out.println("\n\nCURRENT USER: " + currenUser._name);


        }
    }
    private class changeUserActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            openLoginWindow(repo);
        }
    }

    private class addBookActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            AddBookWindow addBookWindow = new AddBookWindow(repo, returnRefrence());
            System.out.println("Test");
        }
    }
    private class changeBookDataActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Book book = repoBookJList.getSelectedValue();
            AddBookWindow addBookWindow = new AddBookWindow(repo, returnRefrence(), book);
        }
    }
    private class manageUsersButtonActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            UsersWindow usersWindow = new UsersWindow(repo, returnRefrence());
        }
    }
    private class addBookFromFileActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(returnRefrence());

            if(response == JFileChooser.APPROVE_OPTION)
            {
                repo.addBookFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            }
            refreashMainWinow();

        }
    }
    private class addUsersFromFileActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(returnRefrence());

            if(response == JFileChooser.APPROVE_OPTION)
            {
                repo.addUserFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            }
            refreashMainWinow();
        }
    }
    private class showBookDetailActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Book book = repoBookJList.getSelectedValue();
            AddBookWindow addBookWindow = new AddBookWindow(repo, returnRefrence(), book, true);
        }
    }
    private class showAllBooksActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            AllBooksWindow allBooksWindow = new AllBooksWindow(repo, returnRefrence());
        }
    }
}
