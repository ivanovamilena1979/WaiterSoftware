package com.company;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order extends RestaurantMenu implements OrderInterface {
    // public OrderStatus orderStatus;

    public String orderStatus;
    public int quantity;
    public ArrayList<OrderedItem> orderedItems;
    ArrayList<RestaurantMenu> menus = readMenuFromFile( "menu.txt" );
    ArrayList<Order> appointments = readOrderFromFile( "order.txt" );
    ArrayList<Table> tables = readTableFromAFile( "tables.txt" );
    int orderNumber;
    String currentTime;
    Table table1 = new Table();
    ArrayList<RestaurantMenu> menu = new ArrayList<>();
    String productName;
    public Table table;
    private double totalPrice;

    public Order(int orderNumber, String currentTime, String prod, double totalPrice, String orderStatus) throws FileNotFoundException {

        this.orderNumber = orderNumber;
        this.currentTime = currentTime;
        this.productName = prod;
        this.totalPrice = totalPrice;
        //this.orderStatus = OrderStatus.ORDERED;
        this.orderStatus = orderStatus;
    }


    public Order() throws FileNotFoundException {
        super();
        this.totalPrice = getTotalPrice();
    }
    public int getTableNumber(){
        return table1.getNumber();
    }

    public static ArrayList<Order> readOrderFromFile(String fileName) throws FileNotFoundException {
        File file = new File( fileName );
        Scanner s = new Scanner( file );
        ArrayList<Order> orderList = new ArrayList<Order>();
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split( "\\|" );

            int table = Integer.parseInt( items[0] );
            LocalDateTime currentTime = LocalDateTime.parse( items[1] );
            String readProductFromMenu = items[2];
            double totalPrice = Double.parseDouble( items[3] );
            OrderStatus orderStatus = OrderStatus.valueOf( items[4] );

//            Order newOrder = new Order(table, date, readProductFromMenu("menu.txt"), totalPrice, OrderStatus.ORDERED);
//            orderList.add(newOrder);

        }
        //ID,date,productName,productPrice,orderStatus
        return orderList;
    }

    public static ArrayList<RestaurantMenu> readProductFromMenu(String fileName) throws FileNotFoundException {
        File file = new File( fileName );
        Scanner s = new Scanner( file );
        ArrayList<RestaurantMenu> prodList = new ArrayList<RestaurantMenu>();
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split( "\\|" );

            String productName = items[2];

            RestaurantMenu prod = new RestaurantMenu( productName );
            prodList.add( prod );

        }
        return prodList;
    }

    //    -----------------------------------------------------------------------
    public static Order createAnOrder(String[] items, ArrayList<RestaurantMenu> menus, ArrayList<Order> orders) throws FileNotFoundException {
        int ID = Integer.parseInt( items[0] );
        String productName = items[1];
        String date = items[2];
        double productPrice = Double.parseDouble( items[3] );
        String orderStatus = items[4];
        RestaurantMenu menu = (RestaurantMenu) findProductById( menus, ID );
        return new Order( ID, date, productName, productPrice, orderStatus );
    }

    //int table, LocalDateTime currentTime, ArrayList<RestaurantMenu> prod, double totalPrice, OrderStatus ordered)
    public static ArrayList<Table> readTableFromAFile(String fileName) {
        ArrayList<Table> tables = new ArrayList<>();
        Path pathToFile = Paths.get( fileName );
        try (BufferedReader br = Files.newBufferedReader( pathToFile,
                StandardCharsets.US_ASCII )) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split( "," );
                Table table = createTable( attributes );
                tables.add( table );
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tables;
    }

    public static Table createTable(String[] item) {
        int number = Integer.parseInt( item[0] );
        Boolean isFree = Boolean.parseBoolean( item[1] );
        return new Table( number, isFree );

    }
//    -----------------------------------------------------------------------

    public static RestaurantMenu findProductById(ArrayList<RestaurantMenu> menu, int ID) {
        for (int i = 0; i < menu.size(); i++) {
            if (ID == menu.get( i ).getID()) {
                return (RestaurantMenu) menu.get( i );
            }
        }
        return null;
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

    public void addItem(RestaurantMenu restaurantMenu) throws IOException {
        File file = new File( "menu.txt" );
        OrderedItem orderedItem = new OrderedItem( restaurantMenu, orderNumber );
        orderedItems.add( orderedItem );
        orderedItem.writeOrderedItemsToAFile( file );
    }

    @Override
    public void makeOrder(String fileName, boolean append) throws IOException {
        ArrayList<Order> orderReadFromFile = new ArrayList<Order>();
        orderReadFromFile = readOrderFromFile( "order1.txt" );
        System.out.println( orderReadFromFile );
        Scanner scan = new Scanner( System.in );
        char decision;
        do {
            System.out.println( "Enter the product ID: " );
            Scanner sc = new Scanner( System.in );
            File file = new File( "menu.txt" );
            Scanner s = new Scanner( file );
            while (s.hasNext()) {

                String line = s.nextLine();
                String[] items = line.split( "\\|" );

                int ID = Integer.parseInt( items[0] );
                String productType = items[1];
                String productName = items[2];
                double productPrice = Double.parseDouble( items[3] );

                int IDSurched = sc.nextInt();
                if (ID == IDSurched) {
                    //int ID = Integer.parseInt( items[0] );

                    productPrice = Double.parseDouble( items[3] );
                    productName = items[2];
                }
                break;
            }

            System.out.println( "How many: " );
            quantity = scan.nextInt();
            System.out.print( "Would you like to order again? Y/N / y/n: " );
            decision = scan.next().charAt( 0 );
        } while (decision != 'n' && decision != 'N');

        Order[] orderArray = new Order[1];
        // Order order1 = new Order( table1.getNumber(), currentTime, menu, totalPrice, orderStatus );
        //orderArray[0] = order1;

        String outputText = orderArray[0].getTable() + "|" + orderArray[0].currentTime + "|" + orderArray[0].menu + "|" + orderArray[0].totalPrice + orderArray[0].orderStatus;
        File file = new File( "order.txt" );
        FileWriter fs = new FileWriter( file, append );
        PrintWriter ps = new PrintWriter( fs );
        ps.println( outputText );
        fs.close();
        ps.close();
        //makeOrder( "order1.txt", true);
    }


    @Override
    public void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException {
        if (!tableOfOrder.isFree()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delProductToOrder() throws IOException {
        Scanner scanner = new Scanner( System.in );
        File inputFile = new File( "order.txt" );
        File tempFile = new File( "myTempOrder.txt" );

        BufferedReader reader = new BufferedReader( new FileReader( "order1.txt" ) );
        BufferedWriter writer = new BufferedWriter( new FileWriter( "tempFileOrder.txt" ) );
        System.out.println( "please enter here order you want to delete: " );


        String lineToRemove = scanner.nextLine();
        System.out.println( lineToRemove );
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals( lineToRemove )) continue;
            writer.write( currentLine + System.getProperty( "line.separator" ) );

        }
        reader.close();
        writer.close();
        inputFile.delete();

        boolean successful = tempFile.renameTo( inputFile );
        System.out.println( successful );

    }

    @Override
    public void changeOrderStatusToCooking() {

    }

    @Override
    public void changeOrderStatusToPrepared() {

    }


    @Override
    public void changeOrderStatusToPayedAndFinish(Table tableOfOrder) {
        try {
            printOrderInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println( "Поръчката е платена! Благодарим, заповядайте отново!" );
        //orderStatus = OrderStatus.PAID;
        tableOfOrder.setFree( true );
    }

    @Override
    public void changeOrderStatusToServed() {

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
}