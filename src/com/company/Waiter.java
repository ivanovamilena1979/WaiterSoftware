package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Employee {
    Table table;
    ArrayList<Table> tables = new ArrayList<>();
    Order orders;
    RestaurantMenu menu = new RestaurantMenu( 1, "drinks", "water", 3.5 );
    int selection;

    public Waiter() {

    }

    public Waiter(String userName) {
        super( userName );
    }

    public Waiter(String userName, String password) {
        super( userName, password );
    }


    @Override
    public void getMenu() throws IOException {
        Scanner waiterMenu = new Scanner( System.in );
        System.out.println( "1. View the menu" );
        System.out.println( "2. Edit menu" );
        System.out.println( "3. Delete an item from the menu" );
        System.out.println( "4. Start a new order" );
        System.out.println( "5. Change an order status to served" );
        System.out.println( "6. All active orders" );
        System.out.println( "7. Add a product to an order" );
        System.out.println( "8. Remove a product from an order" );
        System.out.println( "9. Change an order status to paid" );
        System.out.println( "10. Return to Login menu" );
        System.out.println( "11. Quit" );

        do {
            selection = waiterMenu.nextInt();

            if (selection == 1) {
                ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
                menusReadFromFile = RestaurantMenu.readMenuFromFile( "menu.txt" );
                System.out.println( menusReadFromFile );
            } else if (selection == 2) {
                System.out.println( "Edit menu" );
                menu.addRestaurantMenu( "menu.txt", true );

            } else if (selection == 3) {
                System.out.println( "Delete an item from the menu" );
                RestaurantMenu menu = new RestaurantMenu( 28, "drinks", "Vodka", 3 );
                menu.changeMenu();
            } else if (selection == 4) {
                Order order1 = new Order( "torta", 3.5 );
                ArrayList<Order> orders = new ArrayList<>();
//                orders.add( order1 );
                Table table1 = new Table( 1, orders );
                Table table2 = new Table( 2, orders );
                Table table3 = new Table( 3, orders );
                Table table4 = new Table( 4, orders );
                Table table5 = new Table( 5, orders );
                System.out.println( "Start a new order" );
                Scanner scanner = new Scanner( System.in );
                System.out.print( "Choose the number of the table: " );
                int tableNumber = scanner.nextInt();
                switch (tableNumber) {
                    case 1:
                        if (table1.getNumber() == tableNumber && orders.isEmpty()) {
                            String fileName = String.valueOf( tableNumber ) + ".txt";
                            order1.MilenaMakeOrder( fileName, true );
                        }
                        // order1.MilenaMakeOrder("order.txt",true);}
                        else System.out.println( "This table is not free!" + " " + orders );
                        break;

                    case 2:
                        if (table2.getNumber() == tableNumber && orders.isEmpty()) {
                            String fileName = String.valueOf( tableNumber ) + ".txt";
                            order1.MilenaMakeOrder( fileName, true );
                        } else System.out.println( "This table is not free!" + " " + orders );
                        break;
                    case 3:
                        if (table3.getNumber() == tableNumber && orders.isEmpty()) {
                            String fileName = String.valueOf( tableNumber ) + ".txt";
                            order1.MilenaMakeOrder( fileName, true );
                        } else System.out.println( "This table is not free!" + " " + orders );
                        break;
                    case 4:
                        if (table4.getNumber() == tableNumber && orders.isEmpty()) {
                            String fileName = String.valueOf( tableNumber ) + ".txt";
                            order1.MilenaMakeOrder( fileName, true );
                        } else System.out.println( "This table is not free!" + " " + orders );
                        break;
                    case 5:
                        if (table5.getNumber() == tableNumber && orders.isEmpty()) {
                            String fileName = String.valueOf( tableNumber ) + ".txt";
                            order1.MilenaMakeOrder( fileName, true );
                        } else System.out.println( "This table is not free!" + " " + orders );
                        break;
                    default:
                        System.out.println( "Please enter a number from 1 to 5 - there are just 5 tables!" );

                }
            } else if (selection == 5) {
                File order = new File( "1.txt" );
                String search = String.valueOf( OrderStatus.PREPARED );
                String replace = String.valueOf( OrderStatus.SERVED );

                try {
                    FileReader fr = new FileReader( order );
                    String s;
                    String totalStr = "";

                    try (BufferedReader br = new BufferedReader( fr )) {

                        while ((s = br.readLine()) != null) {
                            totalStr += s + "\n";
                            ;

                        }

                        totalStr = totalStr.replace( search, replace );
                        FileWriter fw = new FileWriter( order );
                        fw.write( totalStr );
                        fw.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            } else if (selection == 6) {
                System.out.println( "Table 1:" + Order.readOrderedProductsFromFile( "1.txt" ) );
                System.out.println( "Table 2:" + Order.readOrderedProductsFromFile( "2.txt" ) );
                System.out.println( "Table 3:" + Order.readOrderedProductsFromFile( "3.txt" ) );
                System.out.println( "Table 4:" + Order.readOrderedProductsFromFile( "4.txt" ) );
                System.out.println( "Table 5:" + Order.readOrderedProductsFromFile( "5.txt" ) );

            } else if (selection == 7) {

                System.out.println( "Start a new order" );
                Order order1 = new Order( "torta", 3.5 );
                order1.MilenaMakeOrder( "1.txt", true );

            }
            else if (selection == 8) {
                System.out.println( "Delete an item from the order" );
                Order.deleteAnItemFromAnOrder();

            }
            else if (selection == 9) {
                System.out.println( "The total amount is: " + Order.sumOrderedProductsFromFile( "1.txt" ) );
                File order = new File( "1.txt" );
                String search = String.valueOf( OrderStatus.SERVED );
                String replace = String.valueOf( OrderStatus.PAID );
                File oldfile = new File( "1.txt" );
                File newfile = new File( "1_paid.txt" );

                if (oldfile.renameTo( newfile )) {
                    System.out.println( "File renamed" );
                } else {
                    // System.out.println( "Sorry! the file can't be renamed" );
                }

            } else if (selection == 10) {
                Login login = new Login();
                login.login();

            } else {
                System.out.println( "10" );
            }
        } while (selection != 11);
        waiterMenu.close();
    }
}
