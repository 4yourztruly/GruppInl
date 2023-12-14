package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Depositform extends JFrame{
    private JPanel panelMain;
    private JList list;
    private JButton backButton;
    private JButton depositButton;
    private JTextField textField1;
    private JButton withdrawButton;
    LoginScreen loginScreen;
    MainMenu mainMenu;
    Account account;
    Depositform(LoginScreen _loginscreen, MainMenu _mainMenu, Account account_) {
        super("Savings");
        loginScreen = _loginscreen;
        mainMenu = _mainMenu;
        account = account_;
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(700, 400);

        DefaultListModel listmodel = new DefaultListModel<>();
        for(int i = 0; i < account.getSavingsArrayList().size(); i++) {
            listmodel.addElement(account.savingsArrayList.get(i));
        }
        list.setModel(listmodel);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                MainMenu mainMenu1 = new MainMenu(loginScreen,account);
                mainMenu1.setVisible(true);





            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = list.getSelectedIndex();
                Savings savings = account.savingsArrayList.get(i);
                account.savingsArrayList.get(i).setBalance(savings.getBalance()+Integer.parseInt(textField1.getText()));
                listmodel.clear();
                for(int d = 0; d < account.getSavingsArrayList().size(); d++) {
                    listmodel.addElement(account.savingsArrayList.get(d));

                }
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = list.getSelectedIndex();
                Savings savings = account.savingsArrayList.get(i);
                account.savingsArrayList.get(i).setBalance(savings.getBalance()-Integer.parseInt(textField1.getText()));
                listmodel.clear();
                for(int d = 0; d < account.getSavingsArrayList().size(); d++) {
                    listmodel.addElement(account.savingsArrayList.get(d));

                }

            }
        });
    } }
