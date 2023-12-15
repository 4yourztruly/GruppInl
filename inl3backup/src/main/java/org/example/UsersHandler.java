package org.example;

import java.util.ArrayList;

public class UsersHandler{
    AdminPanel AdminPanel;
    public int id;
    public String name;
    public String password;
    public int balance;
    Users Users = new Users(id, name, password, balance);

    public ArrayList<org.example.Users> getUsersList() {
        return usersList;
    }

    ArrayList<Users> usersList = new ArrayList<>();
    public UsersHandler() {
        usersList.add(new Users(1, "Bengt", "Password", 1000));
        usersList.add(new Users(2, "Sven", "1234", 5000));
        usersList.add(new Users(3, "Stig", "4321", 10));
        usersList.add(new Users(4, "Jonas", "Mypass1", 10000000));
    }

}



