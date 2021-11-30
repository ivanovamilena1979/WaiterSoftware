package com.company;

import java.io.*;
import java.util.Scanner;

public class RestaurantMenu implements MenuInterface {
    private int itemNumber;
    private String productType;
    private String productName;
    private double productPrice;


//    public Menu(String foodType, String foodName, double foodPrice) {
//        this.foodType = foodType;
//        this.foodPrice = foodPrice;
//        this.foodName = foodName;
//    }

    public String getproductType() {
        return productType;
    }

    public String getproductName() {
        return productName;
    }

    public double getproductPrice() {
        return productPrice;
    }


    @Override
    public String toString() {
        return String.format( getproductName() + "  " + getproductType() + "  price: " + getproductPrice() + "\n" );
    }

    @Override
    public void readMenu() throws IOException {
        //File file = new File( "C:\\Users\\Lenovo\\Desktop\\menu1.txt" );
        //Scanner fileReader = new Scanner( file, "windows-1251" );

        FileReader fin = new FileReader( "C:\\Users\\Lenovo\\Desktop\\menu1.txt" );
        Scanner fileReader = new Scanner( fin );

        int lineNumber = 0;
        while (fileReader.hasNext()) {
            lineNumber++;
            if (lineNumber % 2 != 0) {
                System.out.println( fileReader.nextLine() );
            } else {
                System.out.println( fileReader.nextLine() );
            }
        }
    }

    @Override
    public void addRestaurantMenu() throws IOException {
        FileWriter fileWriter = new FileWriter( "C:\\Users\\Lenovo\\Desktop\\menu1.txt", true );
        PrintWriter out = new PrintWriter( fileWriter );
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter the type of the product (starter, salad,dessert or drink): " );
        try {
            String productType = input.nextLine();
            System.out.println( "The name of the item: " );
            String productName = input.nextLine();
            System.out.println( "Enter the price of the item: " );
            double productPrice = input.nextDouble();
            out.println( "Product type: " + productType + " Product name: " + productName + " Price " + productPrice );
            out.close();
        } catch (Exception e) {
            System.out.println( "Wrong input!" );
        }
    }

    @Override
    public void changeMenu() throws IOException {

    }
}
