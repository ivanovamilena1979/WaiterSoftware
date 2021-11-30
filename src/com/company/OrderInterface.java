package com.company;

public interface OrderInterface {
    void makeAOrder(Table tableOfOrder);
    void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException;
    void addFoodToOrder(Menu DishToAdd);
    void removeFoodFromOrder(Menu dishToRemove);
    double calcTheTotalPriceOfOrder();
    void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer);
    void changeOrderStatusToServed();
}
