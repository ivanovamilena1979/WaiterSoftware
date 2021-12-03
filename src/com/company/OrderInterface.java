package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderInterface {
    void makeOrder(String fileName, boolean append)throws IOException ;
    void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException;
    void addProductToOrder() throws IOException;
void changeOrderStatusToCooking();
    void changeOrderStatusToPrepared();
    void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer);
    void changeOrderStatusToServed();
    void printOrderInfo() throws FileNotFoundException;
}
