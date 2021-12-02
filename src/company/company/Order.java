package company;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Order implements OrderInterface {
    private Table table;
   public OrderStatus orderStatus;
    private double totalPrice = calcTheTotalPriceOfOrder();
    private LocalDateTime currentTime = LocalDateTime.now();
public RestaurantMenu menu;
    List<RestaurantMenu> orderedFood = new ArrayList<RestaurantMenu>();


    public double getTotalPrice() {
        return totalPrice;
    }

    public Table getTable() {
        return table;
    }

    Collection<RestaurantMenu> getMenuItems() {
        return orderedFood;
    }

//    public Order(LocalDateTime currentTime, List<RestaurantMenu> orderedFood, OrderStatus orderStatus) {
//
//        this.currentTime = LocalDateTime.now();
//
//        this.orderedFood = orderedFood;
//        this.orderStatus = orderStatus;
//    }


    @Override
    public void makeOrder() throws IOException {
//    checkIfTableIsFree();
// table.setFree(false);

        FileWriter fileWriter = new FileWriter("order1.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("Въведете номер на маса: ");
        try {
            int number  =input.nextInt();
            System.out.println("Тип на продукта: ");
           String  productType = input.next();
            System.out.println("Наименование на продукта: ");
            String  productName = input.next();
            System.out.println("Количество: ");
            int quantity = input.nextInt();
            out.println("Номер маса : " + number + ", Дата и час на поръчката: " + currentTime + ",  Име на продукт: " + productName + ", Количество : " + quantity + ", Цена на поръчката: " + getTotalPrice());
            out.close();
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }

    }

    @Override
    public void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException {
        if (!tableOfOrder.isFree()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addFoodToOrder(RestaurantMenu foodAdd) {
        orderedFood.add(foodAdd);
    }

    @Override
    public void removeFoodFromOrder(RestaurantMenu foodRemove) {
        orderedFood.remove(foodRemove);
    }

    @Override
    public double calcTheTotalPriceOfOrder() {
        try {
            return getMenuItems().stream().mapToDouble(order -> getMenuItems().size()).sum();
        } catch (NullPointerException e) {
            System.out.println("Няма поръчана храна!");
        }
        return -1;
    }

    @Override
    public void changeOrderStatusToPayedAndFinish(Table tableOfOrder) {
        try {
            printOrderInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Поръчката е платена! Благодарим, заповядайте отново!");
        //orderStatus = OrderStatus.PAID;
        tableOfOrder.setFree(true);
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