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
//-------------------------------------------------------------------------
public void calculate(String fileName) throws FileNotFoundException {
    System.out.print("Enter the ID of the product: ");
    Scanner sc=new Scanner( System.in );
    File file = new File( fileName );
    Scanner s = new Scanner( file );
    while (s.hasNextLine()) {

        String line = s.nextLine();
        String[] items = line.split( "\\|" );

        int ID = Integer.parseInt( items[0] );
        String productType = items[1];
        String productName = items[2];
        double productPrice = Double.parseDouble( items[3] );

int IDSurched=sc.nextInt();
        if (ID==IDSurched){
            //int ID = Integer.parseInt( items[0] );

            System.out.println("price"+Double.parseDouble( items[3] ));

        }

    }}


//    ---------------------------------------------------------------------
    @Override
    public void addRestaurantMenu(String fileName, boolean append) throws IOException {
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
        RestaurantMenu[] menusArray = new RestaurantMenu[1];
        RestaurantMenu menu1 = new RestaurantMenu( (menusReadFromFile.size() + 1), productTypeToAdd, productNameToAdd, productPriceToAdd );
        menusArray[0] = menu1;

        String outputText = menusArray[0].getID() + "|" + menusArray[0].getProductType() + "|" +
                menusArray[0].getProductName() + "|" + menusArray[0].getProductPrice();
        File file = new File( "menu.txt" );
        FileWriter fw = new FileWriter( file, append );
        PrintWriter pw = new PrintWriter( fw );
        pw.println( outputText );
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
