package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame{

    private JPanel panel1;
    private JTextArea userNameTextArea;
    private JTextArea balanceTextArea;
    private JButton backButton;
    private JButton button1;
    private JButton depositWithdrawButton;
    private JButton button3;
    private JButton savingsButton;

    private LoginScreen loginScreen;
    MainMenu thisMainMenu = this;
    private Account account;

    MainMenu(LoginScreen _loginscreen, Account account_) {
        super("Main Menu");
        loginScreen = _loginscreen;
        account = account_;
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(700, 400);
        userNameTextArea.setText("User: "+account.getUserName());
        balanceTextArea.setText("Balance: "+Integer.toString(account.getSavingsArrayList().get(0).getBalance()));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMainMenu.dispose();
                loginScreen.setVisible(true);

            }
        });
        savingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                thisMainMenu.dispose();
                SavingsForm savingsForm = new SavingsForm(loginScreen, thisMainMenu, account);
                for(int i = 0; i < account.getSavingsArrayList().size(); i++) {

                }

                savingsForm.setVisible(true);

            }
        });
        depositWithdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Depositform depositform = new Depositform(loginScreen, thisMainMenu, account);
                thisMainMenu.dispose();
                depositform.setVisible(true);
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
