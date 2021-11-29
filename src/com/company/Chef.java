package com.company;

import java.util.Scanner;

public class Chef extends Employee {

    public Chef(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
    }
    int selection;
    @Override
    public void getMenu() {
        Scanner userMenu = new Scanner(System.in);
        System.out.println("1. View order");
        System.out.println("2 Finish order");
        System.out.println("3. Return to Login menu");
        System.out.println("4. Quit");

        do {
            selection = userMenu.nextInt();

            if (selection == 1) {
                System.out.println("1");
            }
            if (selection == 3) {
                Login login=new Login();
                login.login();
            }
        } while(selection != 4);

        userMenu.close();
    }
}

