package com.company;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order implements OrderInterface {
    private Table table;
    public OrderStatus orderStatus;
    private double totalPrice;
    public LocalDateTime currentTime = LocalDateTime.now();
    public int quantity;
    private ArrayList<RestaurantMenu> menu = new ArrayList<>();
    ArrayList<RestaurantMenu> productName = readProductFromMenu("menu.txt");

    public Order(int table, String product, int quantity, double totalPrice, OrderStatus status, LocalDateTime currentTime) throws FileNotFoundException {

        this.table = getTable();
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderStatus = OrderStatus.ORDERED;
    }

    public Order(int table, ArrayList<RestaurantMenu> readProductFromMenu, int quantity, double totalPrice, OrderStatus ordered, LocalDateTime currentTime) throws FileNotFoundException {
    }

    public Order(int table, LocalDateTime currentTime, ArrayList<RestaurantMenu> readProductFromMenu, int quantity, double totalPrice, OrderStatus ordered) throws FileNotFoundException {
    }

    public Order() throws FileNotFoundException {

    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Order{" +
                "table=" + table +
                ", orderStatus=" + orderStatus +
                ", totalPrice=" + totalPrice +
                ", currentTime=" + currentTime +
                ", quantity=" + quantity +
                '}';
    }
    public RestaurantMenu findProductByName(String name) {
        for (RestaurantMenu e : menu) {
            if (e.getProductName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public static ArrayList<Order> readOrderFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        ArrayList<Order> orderList = new ArrayList<Order>();
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split("\\|");

            int table = Integer.parseInt(items[0]);
            LocalDateTime currentTime = LocalDateTime.parse(items[1]);
            String readProductFromMenu = items[2];
            int quantity = Integer.parseInt(items[3]);
            double totalPrice = Double.parseDouble(items[4]);
            OrderStatus orderStatus = OrderStatus.valueOf(items[5]);

            Order newOrder = new Order(table, currentTime, readProductFromMenu("menu.txt"), quantity, totalPrice, OrderStatus.ORDERED);
            orderList.add(newOrder);

        }
        return orderList;
    }

    public static ArrayList<RestaurantMenu> readProductFromMenu(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        ArrayList<RestaurantMenu> prodList = new ArrayList<RestaurantMenu>();
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split("\\|");

            String productName = items[2];

            RestaurantMenu prod = new RestaurantMenu(productName);
            prodList.add(prod);

        }
        return prodList;
    }


    @Override
    public void createOrder(String fileName, boolean append) throws IOException {
        ArrayList<Order> orderReadFromFile = new ArrayList<Order>();
        orderReadFromFile = readOrderFromFile("order1.txt");
        System.out.println(orderReadFromFile);
        Scanner scan = new Scanner(System.in);
        char decision;
        do {
            System.out.println("Enter the product ID: ");
            Scanner sc = new Scanner(System.in);
            File file = new File("menu.txt");
            Scanner s = new Scanner(file);
            while (s.hasNext()) {

                String line = s.nextLine();
                String[] items = line.split("\\|");

                int ID = Integer.parseInt(items[0]);
                String productType = items[1];
                String productName = items[2];
                double productPrice = Double.parseDouble(items[3]);

                int IDSurched = sc.nextInt();
                if (ID == IDSurched) {
                    //int ID = Integer.parseInt( items[0] );

                    productPrice = Double.parseDouble(items[3]);
                    productName = items[2];
                }
                break;
            }

            System.out.println("How many: ");
            quantity = scan.nextInt();
            System.out.print("Would you like to order again? Y/N / y/n: ");
            decision = s.next().charAt(0);

        } while (decision != 'n' && decision != 'N');
        Order[] orderArray = new Order[1];
        Order order1 = new Order(table.getNumber(), String.valueOf(findProductByName("menu.txt")), quantity, totalPrice, orderStatus, currentTime);
        orderArray[0] = order1;

        String outputText = orderArray[0].getTable() + "|" + orderArray[0].currentTime + "|" + orderArray[0].findProductByName("menu.txt") + "|" + orderArray[0].totalPrice + orderArray[0].orderStatus;
        File file = new File("order.txt");
        FileWriter fs = new FileWriter(file, append);
        PrintWriter ps = new PrintWriter(fs);
        ps.println(outputText);
        ps.close();
    }


    @Override
    public void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException {
        if (!tableOfOrder.isFree()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delProductToOrder() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File inputFile = new File("order.txt");
        File tempFile = new File("myTempOrder.txt");

        BufferedReader reader = new BufferedReader(new FileReader("order1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("tempFileOrder.txt"));
        System.out.println("please enter here product from order for delete: ");


        String lineToRemove = scanner.nextLine();
        System.out.println(lineToRemove);
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));

        }
        reader.close();
        writer.close();
        inputFile.delete();

        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(successful);

    }

    @Override
    public void changeOrderStatusToCooking() {
        System.out.println(OrderStatus.COOKING);
    }

    @Override
    public void changeOrderStatusToPrepared() {
        System.out.println(OrderStatus.PREPARED);
    }

    @Override
    public void changeOrderStatusToPayedAndFinish(Table tableOfOrder) {
        try {
            printOrderInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("The order is payed! Thanks, welcome back !");
        orderStatus = OrderStatus.PAID;
        tableOfOrder.setFree(true);
    }

    @Override
    public void changeOrderStatusToServed() {
        System.out.println(OrderStatus.SERVED);
    }

    @Override
    public void printOrderInfo() throws FileNotFoundException {
        FileReader ord = new FileReader("order.txt");
        Scanner fileReader = new Scanner(ord);

        int lineNumber = 0;
        while (fileReader.hasNext()) {
            lineNumber++;
            if (lineNumber % 2 != 0) {
                System.out.println(fileReader.nextLine());
            } else {
                System.out.println(fileReader.nextLine());
            }

        }
    }
}