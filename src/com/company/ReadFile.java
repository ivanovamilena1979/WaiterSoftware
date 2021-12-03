package com.company;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class ReadFile {
    public static Object RestaurantMenu;
    public static RestaurantMenu addOrder(String[] metadata) throws FileNotFoundException {
        int table = Integer.parseInt(metadata[0]);
        String product = metadata[1];
        int quantity = Integer.parseInt(metadata[2]);
        double totalPrice = Double.parseDouble( metadata[3]);
        OrderStatus status =OrderStatus.valueOf(metadata[4].toUpperCase());
        LocalDateTime currentTime = LocalDateTime.parse(metadata[5]);
        return new RestaurantMenu(table, product, quantity, totalPrice,status, currentTime);
    }

    private static class List1 {
    }
}
