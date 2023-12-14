package org.example;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LoginScreen extends JFrame {
    private JPanel panel1;
    private JPasswordField passWordField;
    private JTextField userNameField;
    private JButton signUpButton;
    private JButton signInButton;
    private JLabel Feedback;

    public ArrayList<Account> accounts = new ArrayList<>();
    LoginScreen thisLoginscreen;
    LoginScreen() {

       super("Login");
       thisLoginscreen = this;
       this.setContentPane(this.panel1);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.pack();
       this.setLocation(700, 400);
        userNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        passWordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                CreateScreen createscreen = new CreateScreen(thisLoginscreen);
                createscreen.setVisible(true);

            }
        });
        signInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Account account = new Account("admin","admin");
                account.setAdmin(true);
                accounts.add(account);

                boolean found = false;
                for(int i = 0; i<accounts.size(); i++) {
                    Account acc = accounts.get(i);
                    if(acc.getUserName().equals(userNameField.getText()) && acc.getPassWord().equals(new String (passWordField.getPassword()))) {
                        found = true;
                        MainMenu mainMenu = new MainMenu(thisLoginscreen, acc);
                        setVisible(false);
                        mainMenu.setVisible(true);

                    }
                }
                if (found == false){

                    Feedback.setText("Wrong username and/or password!");



                }
            }



        });

    }


}
