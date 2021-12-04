package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.RestaurantMenu.readMenuFromFile;

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
        System.out.println("1. View the menu and edit menu");
        System.out.println("2. Start an order");
        System.out.println("3. View order and edit order");
        System.out.println("4. Return to Login menu");
        System.out.println("5. Quit");

        do {
            selection = waiterMenu.nextInt();

            if (selection == 1) {
                ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
                menusReadFromFile = readMenuFromFile("menu.txt");
                System.out.println(menusReadFromFile);
                Scanner editMenu = new Scanner(System.in);
                System.out.println("1. To add product");
                System.out.println("2. To delete a product ");
                do {
                    selection = editMenu.nextInt();
                    if (selection == 1) {
                        RestaurantMenu menu = new RestaurantMenu("kola");
                        menu.addRestaurantMenu("menu.txt", true);
                    }
                    if (selection == 2) {
                        RestaurantMenu menu = new RestaurantMenu("kola");
                        menu.changeMenu();
                    }
                } while (selection != 3);
                editMenu.close();

            }
            if (selection == 2) {
                ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
                menusReadFromFile = readMenuFromFile("menu.txt");
                System.out.println(menusReadFromFile);

                System.out.println("Insert the Order: ");
                Order order = new Order();
                order.createOrder("order.txt", true);
            }
            if (selection == 3) {
                Order order = new Order();
                order.printOrderInfo();
                Scanner input = new Scanner(System.in);
                char y_n = input.next().charAt(0);
                System.out.println("Do you want remove product of order? Y/N / y/n: ");
                do {
                    order.delProductToOrder();
                } while (y_n != 'y' && y_n != 'Y');
            }
            if (selection == 4) {
                Login login = new Login();
                login.login();

            }
        } while (selection != 5);
        waiterMenu.close();
    }
}
