package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Order.milenaReadOrderedProductsFromFile;

public class Chef extends Employee {
    Order order;
    ArrayList<Order> orders;
    public Chef(String userName, String password) {
        super(userName, password);
    }
    int selection;
    @Override
    public void getMenu() throws IOException {
        Scanner userMenu = new Scanner(System.in);
        System.out.println("1. View order");
        System.out.println("2. Change an order status to Cooking");
        System.out.println("3. Change an order status to Cooked");
        System.out.println("4 Return to Login menu");
        System.out.println("5. Quit");


        do {
            selection = userMenu.nextInt();

            if (selection == 1) {
                File file = new File("order.txt");

                try {
                    Scanner scanner = new Scanner(file);

                    //now read the file line by line...
                    int lineNum = 0;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        lineNum++;
                        if(line.contains( "Taken" )||line.contains( "Cooking" )) {
                            Table table1=new Table( 1,milenaReadOrderedProductsFromFile( "order.txt" ) );
                            System.out.println(line);
                        }
                        //else System.out.println("There are no an active order");
                    }
                } catch(FileNotFoundException e) {
                    //handle this
                }
//                (orders.contains( order.orderStatus==OrderStatus.TAKEN ) ){

            }
            if (selection == 2) {
                File order= new File("order.txt");
                String search = "Taken";
                String replace = "Cooking";

                try{
                    FileReader fr = new FileReader(order);
                    String s;
                    String totalStr = "";

                    try (BufferedReader br = new BufferedReader(fr)) {

                        while ((s = br.readLine()) != null) {
                            totalStr += s+ "\n";;

                        }

                        totalStr = totalStr.replace(search, replace);
                        FileWriter fw = new FileWriter(order);
                        fw.write(totalStr);
                        fw.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            if (selection == 3) {
                File order= new File("order.txt");
                String search = "Cooking";
                String replace = "Cooked";

                try{
                    FileReader fr = new FileReader(order);
                    String s;
                    String totalStr = "";

                    try (BufferedReader br = new BufferedReader(fr)) {

                        while ((s = br.readLine()) != null) {
                            totalStr += s+ "\n";;

                        }

                        totalStr = totalStr.replace(search, replace);
                        FileWriter fw = new FileWriter(order);
                        fw.write(totalStr);
                        fw.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }

            if (selection == 4) {
                Login login=new Login();
                login.login();
            }
        } while(selection != 5);

        userMenu.close();
    }

}

