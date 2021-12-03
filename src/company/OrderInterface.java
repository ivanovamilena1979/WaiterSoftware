package company;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OrderInterface {
    void makeOrder(String fileName, boolean append)throws IOException ;
    void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException;
    void addFoodToOrder() throws IOException;

    void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer);
    void changeOrderStatusToServed();
    void printOrderInfo() throws FileNotFoundException;
}
