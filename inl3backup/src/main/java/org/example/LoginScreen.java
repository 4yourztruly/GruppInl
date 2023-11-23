package org.example;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen extends JFrame {
    private JPanel panel1;
    private JPasswordField passWordField;
    private JTextField userNameField;
    private JButton signUpButton;
    private JButton signInButton;
    private JLabel Feedback;

    LoginScreen() {

       super("Login");
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
                CreateScreen createscreen = new CreateScreen();
                createscreen.setVisible(true);

            }
        });
        signInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Account account = new Account("blash","blash");


                if(true) {

                    MainMenu mainMenu = new MainMenu();
                    setVisible(false);
                    mainMenu.setVisible(true);

                }
                else {

                    Feedback.setText("Wrong username and/or password!");
                    System.out.println(account.accounts.contains(userNameField.getText())+account.getPassWord());


                } }



        });

    }


}
