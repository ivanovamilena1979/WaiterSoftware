package com.company;

import java.io.*;
import java.util.Scanner;

public class RestaurantMenu implements MenuInterface {

    private String foodType;
    private String foodName;
    private double foodPrice;


    public RestaurantMenu(String foodType, String foodName, double foodPrice) {
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodName = foodName;
    }

    public String getfoodType() {
        return foodType;
    }

    public String getfoodName() { return foodName; }

    public double getfoodPrice() {
        return foodPrice;
    }


    @Override
    public String toString() {
        return String.format(getfoodName() + "  " + getfoodType() + "  price: " + getfoodPrice() + "\n");
    }

    @Override
    public void readMenu() throws FileNotFoundException {
            File file = new File("Menu.txt");
            Scanner fileReader = new Scanner(file, "windows-1251");
            int lineNumber = 0;
            while (fileReader.hasNext()){
                lineNumber++;
                if (lineNumber % 2 != 0){
                    System.out.println("Тип : " + fileReader.nextLine());
                }
                else{
                    System.out.println("Цена : " + fileReader.nextLine());
                }
            }
            fileReader.close();
        }


    @Override
    public void addRestaurantMenu() throws IOException {
        FileWriter fileWriter = new FileWriter("Menu.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("Въведете тип на продукта: ");
        try {
            String foodType = input.nextLine();
            System.out.println("Наименование на продукта: ");
            String foodName = input.nextLine();
            System.out.println("Въведете цена на продукта: ");
            double foodPrice = input.nextDouble();
            out.println("Тип продукт: " + foodType + " Име на продукт: " + foodName + " Цена на продукт: " + foodPrice);
            out.close();
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }

    @Override
    public void changeMenu() throws IOException {

    }
}
