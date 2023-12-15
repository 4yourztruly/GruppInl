package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPanel{

public int tryId;
    public int currentId;
    UsersHandler UsersHandler = new UsersHandler();
    public JTextField enteredId;
    public JButton selectIdButton;
    public JLabel SelectedId;
    public JLabel listOfUsers;
    public JButton removeAccountButton;
    public JTextField addAccUsrName;
    public JTextField addAccPass;
    public JButton createAccButton;
    public JTextField moneyField;
    public JButton addButton;
    public JButton removeButton1;
    public JPanel adminPanel;
    private JPanel userList;
    private JTextField addAccBalance;
    private JLabel status;
    private JLabel removeStatus;
    private JLabel addOrRemoveStatus;
    private JButton backButton;

    public JFrame jFrame;
    MainMenu Mainmenu;
    AdminPanel thisAdminPanel = this;


    public AdminPanel(MainMenu _mainMenu) {
        jFrame = new JFrame("Admin");
        jFrame.setLocation(300, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(adminPanel);
        jFrame.pack();
        Mainmenu = _mainMenu;
        jFrame.setSize(700, 500);
        userList.setLayout(new BoxLayout(userList, BoxLayout.Y_AXIS));
        jFrame.setVisible(true);
        getUsersList();
        ArrayList<Users> usersList = UsersHandler.getUsersList();
        usersList.get(0).getClass();
        System.out.println(usersList.get(0).getClass());
        //jFrame.setVisible(true);

        selectIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tryId = Integer.parseInt(enteredId.getText());
                    boolean found = false;

                    for(int i = 0; i < usersList.size(); i++) {
                        if (tryId == usersList.get(i).id) {
                            found = true;
                            currentId = tryId;
                            SelectedId.setText("Selected id: " + currentId);
                        }
                    }

                    if (!found) {
                        SelectedId.setText("No id found");

                    }

                } catch (Exception d){
                    SelectedId.setText("That's not a number!");


            }}
        });
        removeAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = currentId;
                    boolean found = false;

                    for(int i = 0; i < usersList.size(); i++) {
                        if (id == usersList.get(i).id) {
                            found = true;
                            usersList.remove(i);
                            removeStatus.setText("User Removed!");
                            resetList();
                        }
                    }

                    if (!found) {
                        removeStatus.setText("User is already removed!");

                    }
                } catch (Exception d){
                    removeStatus.setText("Field was left empty");
                }
            }
        });
        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = addAccUsrName.getText();
                    String password = addAccPass.getText();
                    int balance = Integer.parseInt(addAccBalance.getText());
                    usersList.add(new Users(name, password, balance));
                    status.setText("Account Created!");
                    resetList();
                }
                catch (Exception d){
                    status.setText("Balance entered was not a number!");
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = currentId;
                    boolean found = false;

                    for (Users users : usersList) {
                        if (id == users.id) {
                            found = true;
                            users.balance += Integer.parseInt(moneyField.getText());
                            addOrRemoveStatus.setText(moneyField.getText() + " Has been added!");
                            resetList();

                        }
                    }

                    if (!found) {
                        addOrRemoveStatus.setText("<html>The account you're trying to reach has been deleted<br/><center>choose a new id</html>");
                    }

                } catch (Exception d){
                    addOrRemoveStatus.setText("Field was left empty");
                }
            }
        });
        removeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = currentId;
                    boolean found = false;

                    for (Users users : usersList) {
                        if (id == users.id) {
                            found = true;
                            users.balance -= Integer.parseInt(moneyField.getText());
                            addOrRemoveStatus.setText(moneyField.getText() + " Has been deducted!");
                            resetList();

                        }
                    }

                    if (!found) {
                        addOrRemoveStatus.setText("<html>The account you're trying to reach has been deleted<br/><center>choose a new id</html>");
                    }

                } catch (Exception d){
                    addOrRemoveStatus.setText("Field was left empty");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    jFrame.dispose();
                    Mainmenu.setVisible(true);
            }
        });
    }
    public void makeLabel(String message) {
        JLabel jLabel = new JLabel();
        jLabel.setHorizontalTextPosition(JLabel.LEFT);
        jLabel.setText(message);
        userList.add(jLabel);
        userList.revalidate();
    }
    public void getUsersList(){

        for (Users users : UsersHandler.getUsersList()){
            makeLabel(users.getList());

        }
    }
    public void resetList(){
        userList.removeAll();
        userList.revalidate();
        userList.repaint();
        getUsersList();
    }

    public void setVisible(boolean b) {
    }
}
