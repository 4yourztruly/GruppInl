package org.example;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SavingsForm extends JFrame{

    private JPanel panelMain;
    private JButton backButton;
    private JButton addSavingsAccountButton;
    private JButton removeSavingsAccountButton;
    public JTextArea textArea1;
    private JTextField enterNameTextField;
    public JTextPane textPane1;
    private JList list;
    private JLabel headsLabel;
    private LoginScreen loginScreen;
    private MainMenu mainMenu;
    private Account account;

    SavingsForm(LoginScreen _loginscreen, MainMenu _mainMenu, Account account_) {
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
                setVisible(false);
                mainMenu.setVisible(true);





            }
        });

        addSavingsAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(enterNameTextField.getText().isBlank()) {

                    headsLabel.setText("Please enter a name!");
                } else {
                Savings savings = new Savings(enterNameTextField.getText());
                account.getSavingsArrayList().add(savings);
                listmodel.clear();
                for(int i = 0; i < account.getSavingsArrayList().size(); i++) {
                    listmodel.addElement(account.savingsArrayList.get(i));

                } }
            }
        });
        enterNameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        removeSavingsAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = list.getSelectedIndex();
                if(i>-1) {
                Savings savings = account.savingsArrayList.get(i);
                account.savingsArrayList.remove(savings);
                listmodel.remove(i);
            } else {
                    headsLabel.setText("Please select a line");

                }}
        });
    }}
