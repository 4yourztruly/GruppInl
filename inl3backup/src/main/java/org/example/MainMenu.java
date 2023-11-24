package org.example;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame{

    private JPanel panel1;
    public JTextArea userNameTextArea;
    public JTextArea balanceTextArea;
    private JButton backButton;

    private LoginScreen loginScreen;
    MainMenu thisMainMenu = this;

    MainMenu(LoginScreen _loginscreen) {
        super("Main Menu");
        loginScreen = _loginscreen;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(700, 400);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMainMenu.dispose();
                loginScreen.setVisible(true);

            }
        });
    }

    public JTextArea getUserNameTextArea() {
        return userNameTextArea;
    }

    public void setUserNameTextArea(JTextArea userNameTextArea) {
        this.userNameTextArea = userNameTextArea;
    }

    public JTextArea getBalanceTextArea() {
        return balanceTextArea;
    }

    public void setBalanceTextArea(JTextArea balanceTextArea) {
        this.balanceTextArea = balanceTextArea;
    }




}
