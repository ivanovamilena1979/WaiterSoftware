package com.company;

public interface OrderInterface {
    void makeAOrder(Table tableOfOrder);
    void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException;
    void addFoodToOrder(RestaurantMenu foodToAdd);
    void removeFoodFromOrder(RestaurantMenu foodToRemove);
    double calcTheTotalPriceOfOrder();
    void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer);
    void changeOrderStatusToServed();
}
