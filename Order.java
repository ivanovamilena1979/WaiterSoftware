package com.company;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order implements OrderInterface {
    private static int numberOfOrders = 0;
    private int orderNumber;
    private OrderStatus orderStatus;
    public RestaurantMenu menu;
    RestaurantMenu restaurantMenu;
    //ArrayList<RestaurantMenu> orderedFood = new ArrayList<RestaurantMenu>();
    ArrayList<Order>orders=new ArrayList<Order>();
    String orderedProduct;
    double price;
    int productId;
    double total;
    private Table table;
    private double totalPrice = calcTheTotalPriceOfOrder();
    private LocalDateTime currentTime = LocalDateTime.now();

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus1) {
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter the status of an order: TAKEN/SERVED OR PAID: " );
        orderStatus1 = scan.nextLine();
       this.orderStatus =OrderStatus.valueOf( orderStatus1 ) ;

    }

    public Order(String name, double price) throws FileNotFoundException {
        numberOfOrders++;
        this.price = price;
       this.orderedProduct = name;
        this.currentTime = LocalDateTime.now();
        this.orderStatus=OrderStatus.TAKEN;
        this.table=getTable();
        this.orderNumber = numberOfOrders;
        orders = new ArrayList<Order>();
        //this.orderedFood1=restaurantMenu.getProductName();
        //this.price=restaurantMenu.getProductPrice();

    }
    ArrayList<Order>newOrders=new ArrayList<>();
    ArrayList<Order>finishedOrders=new ArrayList<>();

    //    -----------------------------------------------------------------------------------------------------------
    public static ArrayList<Order> milenaReadOrderedProductsFromFile(String fileName) throws FileNotFoundException {
        // public static ArrayList<RestaurantMenu> readMenuFromFile(String fileName) throws FileNotFoundException {
        File file = new File( fileName );
        Scanner s = new Scanner( file );
        ArrayList<Order> orderList = new ArrayList<Order>();
        double sum = 0.0;
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split( "\\|" );

            String productName = items[0];
            double price = Double.parseDouble( items[1] );
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm" );
            String formatDateTime = currentTime.format( format );
            formatDateTime = items[2];
            String orderStatus= items[3];
//            System.out.println("oder status: ");
//            String orderStatus=s.nextLine();
//            OrderStatus orderStatus=OrderStatus.valueOf(  )
            Order newOrder = new Order( productName, price);
            orderList.add( newOrder );
            sum += price;

        }

        return orderList;
    }

    public static double milenaSumOrderedProductsFromFile(String fileName) throws FileNotFoundException {
        // public static ArrayList<RestaurantMenu> readMenuFromFile(String fileName) throws FileNotFoundException {
        File file = new File( fileName );
        Scanner s = new Scanner( file );
        ArrayList<Order> orderList = new ArrayList<Order>();
        double sum = 0.0;
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split( "\\|" );

            String productName = items[0];
            double price = Double.parseDouble( items[1] );
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm" );
            String formatDateTime = currentTime.format( format );
            formatDateTime = items[2];
            String orderStatus= items[3];

            Order newOrder = new Order( productName, price);
            orderList.add( newOrder );
            sum += price;

        }

        return sum;
    }

    public String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm" );
        String formatDateTime = currentTime.format( format );

        return formatDateTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Table getTable() {
        return table;
    }

    public void MilenaMakeOrder(String fileName, boolean append) throws IOException {

        ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
        menusReadFromFile = restaurantMenu.readMenuFromFile( "menu.txt" );
        System.out.println( menusReadFromFile );
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter the product id: " );
        this.productId = scan.nextInt();
        Order[] ordersArray = new Order[1];
        this.total = 0;
        for (int i = 0; i < menusReadFromFile.size(); i++) {
            if (this.productId == menusReadFromFile.get( i ).getId()) {
                Order order1 = new Order( menusReadFromFile.get( i ).getProductName(), menusReadFromFile.get( i ).getProductPrice() );;
                ordersArray[0] = order1;
                String outputText = ordersArray[0].orderedProduct + "|" + ordersArray[0].price + "|" + ordersArray[0].getCurrentTime() + "|" + ordersArray[0].orderStatus;
                File file = new File( fileName );
                FileWriter fw = new FileWriter( file, append );
                PrintWriter pw = new PrintWriter( fw );
                pw.println( outputText );
                pw.close();
                this.total += ordersArray[0].price;
            }
        }
    }


    @Override
    public void makeOrder() throws IOException {}

    @Override
    public void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException {
        if (!tableOfOrder.isFree()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addFoodToOrder(RestaurantMenu foodAdd) {
       // orderedFood.add( foodAdd );
    }

    @Override
    public void removeFoodFromOrder(RestaurantMenu foodRemove) {
       // orderedFood.remove( foodRemove );
    }

    @Override
    public double calcTheTotalPriceOfOrder() {

//        try {
//            for (int i = 0; i < ordersArray.length; i++) {
//
//            }
//            return this.total;
//        } catch (NullPointerException e) {
//            System.out.println( "Няма поръчана храна!" );
//        }
        return -1;
    }

    @Override
    public void changeOrderStatusToPayedAndFinish(Table tableOfOrder) {
        try {
            printOrderInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( "Поръчката е платена! Благодарим, заповядайте отново!" );
        orderStatus = OrderStatus.PAID;
        tableOfOrder.setFree( true );
    }
    public void changeOrderStatusToCooking() {
        this.orderStatus=OrderStatus.COOKING;
    }
    @Override
    public void changeOrderStatusToServed() {
        this.orderStatus=OrderStatus.SERVED;
    }

    @Override
    public void printOrderInfo() throws FileNotFoundException {
        FileReader ord = new FileReader( "order1.txt" );
        Scanner fileReader = new Scanner( ord );

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
    public void changeMenu() throws IOException {
        Scanner scanner = new Scanner( System.in );
        File inputFile = new File( "menu.txt" );
        File tempFile = new File( "myTempFile.txt" );

        BufferedReader reader = new BufferedReader( new FileReader( inputFile ) );
        BufferedWriter writer = new BufferedWriter( new FileWriter( tempFile ) );
        System.out.println( "please enter the number of the line you want to delete: " );


        String lineToRemove = scanner.nextLine();
        if (lineToRemove.equals( "1" ) || lineToRemove.equals( "2" )) {
            lineToRemove = "0".concat( lineToRemove );
        }

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.contains( lineToRemove )) continue;
            writer.write( currentLine + System.getProperty( "line.separator" ) );

        }
        reader.close();
        writer.close();
        inputFile.delete();

        boolean successful = tempFile.renameTo( inputFile );
        System.out.println( successful );

    }
    @Override
    public String toString() {
        return  this.orderStatus+" "+getCurrentTime() + " " + this.orderedProduct + "  " + this.price + "\n";
    }

}