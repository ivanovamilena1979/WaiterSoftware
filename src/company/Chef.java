package company;

import java.io.IOException;
import java.util.Scanner;

public class Chef extends Employee {

    public Chef(String userName, String password) {
        super(userName, password);
    }
    int selection;
    @Override
    public void getMenu() throws IOException {
        Scanner userMenu = new Scanner(System.in);
        System.out.println("1. View order");
        System.out.println("2 Change status order");
        System.out.println("3. Return to Login menu");
        System.out.println("4. Quit");

        do {
            selection = userMenu.nextInt();

            if (selection == 1) {
               Order order = new Order();
               order.printOrderInfo();
            }
            if (selection == 2) {
                Order order1 = new Order();
                order1.changeOrderStatusToCooking();
                Order order2 = new Order();
                order2.changeOrderStatusToPrepared();
            }
            if (selection == 3) {
                Login login=new Login();
                login.login();
            }
        } while(selection != 4);

        userMenu.close();
    }
}

