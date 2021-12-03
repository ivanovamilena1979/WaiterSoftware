package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Waiter extends Employee {
    // RestaurantMenu menu=new RestaurantMenu();
    public Waiter() {

    }

    public Waiter(String userName) {
        super(userName);
    }

    public Waiter(String userName, String password) {
        super(userName, password);
    }

    int selection;

    @Override
    public void getMenu() throws IOException {
        Scanner waiterMenu = new Scanner(System.in);
        System.out.println("1. View the menu and start an order");
        System.out.println("2. Edit menu");
        System.out.println("3. View order and edit order");
        System.out.println("3. Change order status");
        System.out.println("4. Return to Login menu");
        System.out.println("5. Opit Quit");

        do {
            selection = waiterMenu.nextInt();

            if (selection == 1) {
                RestaurantMenu menu = new RestaurantMenu("kola");
                menu.readMenuFromFile("menu.txt");
                Order order = new Order();
                order.makeOrder("order.txt", true);
            }
            if (selection == 2) {
                System.out.println("Edit menu");
                RestaurantMenu menu = new RestaurantMenu("kola");
                menu.changeMenu();
            }
            if (selection == 3) {
               Order order = new Order();
               order.printOrderInfo();
               order.addProductToOrder();
            }
            if (selection == 4) {
                Login login = new Login();
                login.login();

            }
        } while (selection != 5);
        waiterMenu.close();
    }
}
