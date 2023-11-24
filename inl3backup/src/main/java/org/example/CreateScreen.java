package org.example;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateScreen extends JFrame{
    private JPasswordField passwordField1;
    private JPanel panel1;
    private JTextField textField1;
    private JButton createButton2;
    private JButton cancelButton;
    private JLabel userName;

    private JLabel passWord;
    LoginScreen loginScreen;
    private CreateScreen thisCreateScreen = this;

    CreateScreen(LoginScreen _loginScreen) {

        super("Create");
        loginScreen = _loginScreen;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(700, 400);
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        createButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Account account = new Account(textField1.getText(),new String (passwordField1.getPassword()));
                loginScreen.accounts.add(account);
                System.out.println(account.getDescription());
                thisCreateScreen.dispose();
                loginScreen.setVisible(true);

            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
            }
        });
    } }
