package com.company;

import java.io.*;
import java.util.ArrayList;

public class OrderedItem extends RestaurantMenu {

    private int orderNumber;
    private boolean isCooking;
    private boolean isCooked;

    public OrderedItem(RestaurantMenu menu, int orderNumber) throws IOException {
        super( menu );
        this.orderNumber = orderNumber;
        isCooking = false;
        isCooked = false;
    }
    public ArrayList<OrderedItem> orderedItems;
    public void writeOrderedItemsToAFile(File file) throws IOException {
        try{
            FileOutputStream writeData = new FileOutputStream("order.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(orderedItems);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readOrderedItemsFromAFile(File file){
        try{
            FileInputStream readData = new FileInputStream("order.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList orderedItems = (ArrayList<OrderedItem>) readStream.readObject();
            readStream.close();

            System.out.println(orderedItems.toString());
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}