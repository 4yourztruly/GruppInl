package org.example;

public class Main {
    public static void main(String[] args) {

        LoginScreen loginscreen = new LoginScreen();
        loginscreen.setVisible(true);
        Account account = new Account("a", "a"); //testkonto
        System.out.println(account.getUserName()+account.getPassWord()); //println för att se att värderna har sparats

        //create screen är funktionellt klar men kan finslipas visuellt
        //login screen funkar inte att logga in än för att jag inte har fixat en lösning för att kolla så att userinput stämmer med något konto
        //main menu är funktionellt kopplad till login screen så den funkar när login screen funkar




    }
}