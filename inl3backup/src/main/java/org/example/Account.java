package org.example;

import java.util.ArrayList;

public class Account {

    private String userName;
    private String passWord;
    private boolean admin;

    ArrayList<Savings>savingsArrayList = new ArrayList<>();

    Savings savings = new Savings("Konto");


    public String getDescription() {

        return userName+","+passWord;

    }



    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        savingsArrayList.add(savings);
        this.admin = false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ArrayList<Savings> getSavingsArrayList() {
        return savingsArrayList;
    }

    public void setSavingsArrayList(ArrayList<Savings> savingsArrayList) {
        this.savingsArrayList = savingsArrayList;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
