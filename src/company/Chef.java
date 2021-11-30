package company;

import java.util.Scanner;

public class Chef extends Employee {

    public Chef(String userName, String password) {
        super(userName, password);
    }
    int selection;
    @Override
    public void getMenu() {
        Scanner userMenu = new Scanner(System.in);
        System.out.println("1. View order");
        System.out.println("2 Return to Login menu");
        System.out.println("2. Finish order");
        System.out.println("3. Quit");

        do {
            selection = userMenu.nextInt();

            if (selection == 1) {
                System.out.println("1");
            }
            if (selection == 2) {
                Login login=new Login();
                login.login();
            }
        } while(selection != 3);

        userMenu.close();
    }
}

