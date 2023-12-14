package org.example;

public class Savings {

    private String name;
    private int balance;

    public Savings(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String GetDescription() {
        return name+","+balance+",";
    }

    @Override
    public String toString() {
        return   name+": "+balance;
    }
}
