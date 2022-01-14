package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Waiter extends Employee {
    Table table;
    ArrayList<Table> tables = new ArrayList<>();
    ArrayList<Order> orderLists = new ArrayList<>();
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
        System.out.println( "9. Return to Login menu" );
        System.out.println( "10. Quit" );

        do {
            selection = waiterMenu.nextInt();

            if (selection == 1) {
                ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
                //  r = menusReadFromFile.readMenuFromFile( "menu.txt" );
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

//                orders.add( order1 );

                Table table1 = new Table( 1, orderLists );
                Table table2 = new Table( 2, orderLists );
                Table table3 = new Table( 3, orderLists );
                Table table4 = new Table( 4, orderLists );
                Table table5 = new Table( 5, orderLists );
                for (Table table : Arrays.asList( table1, table2, table3, table4, table5 )) {
                    tables.add( table );
                }
                System.out.println( "Start a new order" );
                Scanner scanner = new Scanner( System.in );
                System.out.print( "Choose the number of the table: " );
                int tableNumber = scanner.nextInt();
                for (int i = 0; i < tables.size(); i++) {


                if ((table.getNumber() == tableNumber) && orderLists.isEmpty()) {
//                Order order2=new Order("torta",3.5 );
                    String fileName=String.valueOf(tableNumber)+".txt";
                    order1.MilenaMakeOrder( fileName, true );
                } else System.out.println( "This table is not free!" + " " + orders );}

            } else if (selection == 5) {
                File order = new File( "order.txt" );
                String search = "Cooked";
                String replace = "Served";

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


            } else if (selection == 7) {

                System.out.println( "Start a new order" );
                Order order1 = new Order( "torta", 3.5 );
                order1.MilenaMakeOrder( "order.txt", true );

            } else if (selection == 9) {
                Login login = new Login();
                login.login();

            } else {
                System.out.println( "9" );
            }
        } while (selection != 10);
        waiterMenu.close();
    }
}
