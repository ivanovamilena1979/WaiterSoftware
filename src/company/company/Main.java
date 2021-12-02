package company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static company.RestaurantMenu.readMenuFromFile;

public class Main {

    public static void main(String[] args) throws IOException {
        //RestaurantMenu[] menusArray = new RestaurantMenu[1];
        //Login login = new Login();
        //login.login();

        ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
        menusReadFromFile = readMenuFromFile( "menu.txt" );
        System.out.println( menusReadFromFile );

        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter the product type: " );
        String productTypeToAdd = scan.nextLine();
        System.out.println( "Enter the product name: " );
        String productNameToAdd = scan.nextLine();
        System.out.println( "Enter the product price: " );
        double productPriceToAdd = scan.nextDouble();
        RestaurantMenu menu1 = new RestaurantMenu( (menusReadFromFile.size() + 1), productTypeToAdd, productNameToAdd, productPriceToAdd );
        RestaurantMenu[] menusArray = new RestaurantMenu[1];
        menusArray[0] = menu1;

        String outputText = menusArray[0].getID() + "|" + menusArray[0].getProductType() + "|" +
                menusArray[0].getProductName() + "|" + menusArray[0].getProductPrice();
        menu1.addRestaurantMenu( "menu.txt", outputText, true );
    }
}

