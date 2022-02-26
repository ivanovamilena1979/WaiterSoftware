package com.company;

import java.io.*;
import java.util.*;

public class RestaurantMenu implements MenuInterface {
    private int id;
    private String productType;
    private String productName;
    private double productPrice;

    public RestaurantMenu(int id, String productType, String productName, double productPrice) {
        this.id = id;
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static ArrayList<RestaurantMenu> readMenuFromFile(String fileName) throws FileNotFoundException {
        File file = new File( fileName );
        Scanner s = new Scanner( file );
        ArrayList<RestaurantMenu> menuList = new ArrayList<RestaurantMenu>();
        while (s.hasNextLine()) {

            String line = s.nextLine();
            String[] items = line.split( "\\|" );

            int ID = Integer.parseInt( items[0] );
            String productType = items[1];
            String productName = items[2];
            double productPrice = Double.parseDouble( items[3] );

            RestaurantMenu newMenu = new RestaurantMenu( ID, productType, productName, productPrice );
            menuList.add( newMenu );
        }
        menuList.sort( Comparator.comparing( RestaurantMenu::getProductType ).reversed().thenComparing( Comparator.comparingInt( RestaurantMenu::getId ) ) );
        // menuList.sort( Comparator.comparingInt(RestaurantMenu::getId));

        return menuList;

    }

    public int getId() {
        return id;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String toString() {
        return (getId() + "  " + getProductType() + "  " + getProductName() + " " + getProductPrice() + "\n");
    }

    @Override
    public void addRestaurantMenu(String fileName, boolean append) throws IOException {
        ArrayList<RestaurantMenu> menusReadFromFile = new ArrayList<RestaurantMenu>();
        menusReadFromFile = readMenuFromFile( "menu.txt" );
        System.out.println( menusReadFromFile );
        menusReadFromFile.sort( Comparator.comparingInt( RestaurantMenu::getId ) );
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter the product type: " );
        String productTypeToAdd = scan.nextLine();
        System.out.println( "Enter the product name: " );
        String productNameToAdd = scan.nextLine();
        System.out.println( "Enter the product price: " );
        double productPriceToAdd = scan.nextDouble();
        RestaurantMenu[] menusArray = new RestaurantMenu[1];
        RestaurantMenu menu1 = new RestaurantMenu( (menusReadFromFile.get( menusReadFromFile.size() - 1 ).id + 1), productTypeToAdd, productNameToAdd, productPriceToAdd );
        menusArray[0] = menu1;
        String outputText = menusArray[0].getId() + "|" + menusArray[0].getProductType() + "|" +
                menusArray[0].getProductName() + "|" + menusArray[0].getProductPrice();
        File file = new File( "menu.txt" );
        FileWriter fw = new FileWriter( file, append );
        PrintWriter pw = new PrintWriter( fw );
        pw.println( outputText );
        pw.close();
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

}
