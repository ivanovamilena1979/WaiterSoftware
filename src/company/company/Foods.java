package company;

import java.util.Scanner;

public class Foods {

    private String foodType;
    private String foodName;
    private double foodPrice;


    public Foods(String foodType, String foodName, double foodPrice) {
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

        public void getInfo() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Въведи тип: ");
            foodType = sc.nextLine();
            System.out.print("Въведи наименование : ");
            foodName = sc.nextLine();
            System.out.print("Въведи цена: ");
            foodPrice = sc.nextDouble();
        }
    @Override
    public String toString() {
        return String.format(getfoodName() + "  " + getfoodType() + "  price: " + getfoodPrice() + "\n");
    }
}
