package org.example;

import javax.swing.*;

public class MainMenu extends JFrame{

    private JPanel panel1;
    private JTextArea userNameTextArea;
    private JTextArea balanceTextArea;

    MainMenu() {

        super("Main Menu");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(700, 400);
} }
