package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        RestaurantMenu[] menusArray = new RestaurantMenu[1];
//        Login login = new Login();
//        login.login();
        //ArrayList<RestaurantMenu> menus;
//        ArrayList<Order> appointments = readOrderFromFile("order.txt");
//        ArrayList<Table> tables = readTableFromAFile("tables.txt");
        ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
//        menusReadFromFile = readMenuFromFile( "menu.txt" );
//        System.out.println( menusReadFromFile );
//        //System.out.println( "The 1 item in the menu is:" + menusReadFromFile.get( 0) );
//        ArrayList<Order> orderReadFromFile = new ArrayList<Order>();
//        orderReadFromFile = readOrderFromFile("order1.txt");
//        System.out.println(orderReadFromFile);

        RestaurantMenu menu1 = new RestaurantMenu( 28, "drinks", "Vodka", 3 );
////
//       menu1.addRestaurantMenu( "menu.txt", true );
        Order order1 = new Order();
        //order1.addItem(RestaurantMenu menu1)public void addItem(Item item){ menuItems.add(item);
        //}

//      order1.makeOrder("order1.txt", true);

Foods foods=new Foods( true,menu1 );
foods.act();
        //menu2.calculate( "menu.txt" );
    }
}

