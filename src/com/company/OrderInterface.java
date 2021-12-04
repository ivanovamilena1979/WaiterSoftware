package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderInterface {
    void createOrder(String fileName, boolean append) throws IOException;

    void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException;

    void delProductToOrder() throws IOException;

    void changeOrderStatusToCooking();

    void changeOrderStatusToPrepared();

    void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer);

    void changeOrderStatusToServed();

    void printOrderInfo() throws FileNotFoundException;
}
