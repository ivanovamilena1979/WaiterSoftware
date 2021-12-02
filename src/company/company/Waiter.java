package company;

import java.io.IOException;
import java.util.Scanner;

public class Waiter extends Employee {
   // RestaurantMenu menu=new RestaurantMenu();
        public Waiter() {

        }

        public Waiter(String userName) {
            super(userName);
        }

        public Waiter(String userName, String password) {
            super(userName, password);
        }
    int selection;
        @Override
        public void getMenu() throws IOException {
            Scanner waiterMenu = new Scanner(System.in);
            System.out.println("1. Start an order");
            System.out.println("2. View the menu");
            System.out.println("3. Edit menu");
            System.out.println("4. Return to Login menu");
            System.out.println("5. Opit Quit");

            do {
                selection = waiterMenu.nextInt();

                if (selection == 1) {
                    System.out.println("1");
                }
                else if (selection == 2) {
                    System.out.println("Restaurant menu");
                  //  menu.readMenu();
                    System.out.println();
                    System.out.println("1. Start an order");
                    System.out.println("2. View the menu");
                    System.out.println("3. Edit menu");
                    System.out.println("4. Return to Login menu");
                    System.out.println("5. Opit Quit");
                    System.out.print(":");
                }
                else if (selection == 3) {
                    System.out.println("Edit menu");
                   // menu.addRestaurantMenu();
                }
                else if (selection == 4) {
                    Login login=new Login();
                    login.login();

                }
                else {
                    System.out.println("5");
                }
            } while(selection != 5);
            waiterMenu.close();
        }
        }
