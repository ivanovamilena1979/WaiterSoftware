package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Login extends Employee {
    Scanner input = new Scanner(System.in);

    Employee[] employees = {new Chef("Bobi", "111"),
            new Chef("Pena", "123Seven"),
            new Waiter("Ani",  "123"),
            new Waiter("Bil","321")};

    public void login() throws IOException {
        System.out.print("Enter firstName:");
        String firstName = input.nextLine();
        System.out.print("Enter password:");
        String password = input.nextLine();
        int count = 0;
        for (
                int i = 0;
                i < employees.length; i++) {
            if (employees[i].getUserName().equals(firstName) &&
                    employees[i].getPassword().equals(password)) {

                employees[i].getMenu();
                count++;

                break;
            }
        }
        if (count == 0) {
            System.out.println("Wrong input!Please check and try again!");


        }
    }


    @Override
    public void getMenu() {
        int selection;
        Scanner WelcomeMenu = new Scanner(System.in);
        System.out.println("1. Welcome");
        System.out.println("2. Dyra byra");
        System.out.println("3. UFF");
        System.out.println("4. Pfu");


        do {
            selection = WelcomeMenu.nextInt();

            if (selection == 1) {
                System.out.println("1");
            } else if (selection == 2) {
                System.out.println("2");
            } else if (selection == 3) {
                System.out.println("3");
            } else {
                System.out.println("4");
            }
        } while (selection != 4);
        WelcomeMenu.close();
    }
}
