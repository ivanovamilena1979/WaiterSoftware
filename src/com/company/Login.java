package com.company;

import java.util.Scanner;

public class Login extends Employee {
    Scanner input = new Scanner( System.in );

    Employee[] employees = {new Chef( "Bob", "Bobev", "myPassword" ),
            new Chef( "Sue", "Sarandon", "123Seven" ),
            new Waiter( "Jenny", "Strayhorn", "hardPassword" ),
            new Waiter( "Billy", "MeanGuy", "pifiaoanaei" )};
public void login(){
        System.out.println("Enter firstName:");
    String firstName = input.nextLine();

        System.out.println("Enter lastName:");
    String lastName = input.nextLine();

        System.out.println("Enter password:");
    String password = input.nextLine();
    int count = 0;
        for(
    int i = 0;
    i<employees.length;i++)

    {
        if (employees[i].getFirstName().equals( firstName ) &&
                employees[i].getLastName().equals( lastName ) &&
                employees[i].getPassword().equals( password )) {

            employees[i].getMenu();
            count++;

            break;
        }
    }
        if(count ==0)

    {
        System.out.println( "Wrong input!Please check and try again!" );}}


    @Override
    public void getMenu() {
        int selection;
            Scanner WelcomeMenu = new Scanner( System.in );
            System.out.println( "1. Welcome" );
            System.out.println( "2. Dyra byra" );
            System.out.println( "3. UFF" );
            System.out.println( "4. Pfu" );


            do {
                selection = WelcomeMenu.nextInt();

                if (selection == 1) {
                    System.out.println( "1" );
                } else if (selection == 2) {
                    System.out.println( "2" );
                } else if (selection == 3) {
                    System.out.println( "3" );
                } else {
                    System.out.println( "4" );
                }
            } while (selection != 4);
            WelcomeMenu.close();
        }}
