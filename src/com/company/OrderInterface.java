package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderInterface {
    void makeOrder() throws IOException;
    void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException;
    void addFoodToOrder(RestaurantMenu foodAdd);
    void removeFoodFromOrder(RestaurantMenu foodRemove);
    double calcTheTotalPriceOfOrder();
    void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer);
    void changeOrderStatusToServed();
    void printOrderInfo() throws FileNotFoundException;
}
