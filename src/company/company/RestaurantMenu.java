package company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantMenu implements MenuInterface {
    private int ID;
    private String productType;
    private String productName;
    private double productPrice;

    public RestaurantMenu(int ID,String productType,String productName,double productPrice){
        this.ID=ID;
        this.productType=productType;
        this.productName=productName;
        this.productPrice=productPrice;
    }
    public int getID(){
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductType(){
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public String toString() {
        return ( getID() + "  " + getProductType() + "  " + getProductName() + " "+getProductPrice() +"\n" );
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
        return menuList;
    }

    @Override
    public void addRestaurantMenu(String fileName, String text, boolean append) throws IOException {
        File file = new File( "menu.txt" );
        FileWriter fw = new FileWriter( file, append );
        PrintWriter pw = new PrintWriter( fw );
        pw.println( text );
        pw.close();
    }

    @Override
    public void changeMenu() throws IOException {
        Scanner scanner = new Scanner( System.in );
        File inputFile = new File( "menu1.txt" );
        File tempFile = new File( "myTempFile.txt" );

        BufferedReader reader = new BufferedReader( new FileReader( inputFile ) );
        BufferedWriter writer = new BufferedWriter( new FileWriter( tempFile ) );
        System.out.println( "please copy and paste here the line of the menu you want to delete: " );


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


}
