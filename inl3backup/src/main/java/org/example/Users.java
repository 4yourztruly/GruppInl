package org.example;

public class Users {

    public int getId() {
        return id;
    }

    public int id;
    static int nextId = 1;
    public String name;
    public String password;
    public int balance;

    public Users(int id, String name, String password, int balance) {
        this.id = id;
        if (id >= nextId) {
            nextId = id + 1;
        }
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    public Users(String name, String password, int balance) {
        id = nextId;
        nextId++;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getList(){

      return "Id: " + id + " Username: " + name + " Password: " + password + " Balance: " + balance;
    }
}