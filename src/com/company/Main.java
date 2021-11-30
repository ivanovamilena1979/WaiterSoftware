package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       Login login = new Login();
      login.login();
       RestaurantMenu menu = new RestaurantMenu();
       Waiter waiter=new Waiter();
//        menu.addRestaurantMenu();
//        Order order = new Order();
//        order.makeOrder();
//        order.printOrderInfo();
        //menu.addFoodMenu();
        menu.readMenu();
        menu.changeMenu();
        waiter.getMenu();

    }
}
