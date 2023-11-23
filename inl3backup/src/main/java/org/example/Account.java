package org.example;

import java.util.ArrayList;

public class Account {

    private String userName;
    private String passWord;
    private int balance;

    public String getDescription() {

        return userName+","+passWord+","+balance;

    }

    public ArrayList<Account> accounts = new ArrayList<>();


    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.balance = 0;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
