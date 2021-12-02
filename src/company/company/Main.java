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
        //System.out.println( "The 1 item in the menu is:" + menusReadFromFile.get( 0) );


        RestaurantMenu menu1=new RestaurantMenu( 28,"drinks","Vodka",3 );

        menu1.addRestaurantMenu( "menu.txt", true );


        //menu2.calculate( "menu.txt" );
    }
}

