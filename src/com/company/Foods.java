package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

/**
 * Generates Menu index values for an order
 *  is used by the controller
 */
public class Foods // implements Actor
{
    //class varibles
    private RestaurantMenu restaurantMenu;       //Menu menu;

    //private static Randomizer rand;



    /*
     * These probably shouldn't exist here
     *
     * Possible fixes have a loop in Simulator, while there are still orders
     * to be generated (create a method::boolean), recieve order from order
     * generator, then give order to both the CustomerInvoice and Kitchen
     */

    //instance variables
    private ArrayList<RestaurantMenu> currentMenuItems;//????
    private boolean autoOrder;

    // Constructors
    /**
     * Default constructor will use automatically generated orders
     */
    //public OrderGenerator(Menu menu, Kitchen kitchen, CustomerInvoice invoice)
//    {
//        this(true, menu,kitchen, invoice);
    //}
   // private Foods(RestaurantMenu currentMenuItems) { this(currentMenuItems); }

    /**
     * Initializes the all powerful ROS operator
     *
     * @param autoOrder if True, class will use Randomizer to create random orders.
     */
    public Foods(boolean autoOrder, RestaurantMenu restaurantMenu)
    {

        this.autoOrder = autoOrder;
        this.restaurantMenu = restaurantMenu;


        currentMenuItems = restaurantMenu.getMenu();
        //rand = new Randomizer();

    }
    //Methods
    /**
     *  Acts!
     */
    public void act() throws IOException {
        //Number of orders being placed
        int numberOfOrders = 3;                               //zadavane na nomera na poryxhkite
        for(int i = 0 ; i < numberOfOrders; i++){
            Order currentOrder = new Order();
            buildOrder(currentOrder);
            System.out.println("Order built");

        }
    }

    /**
     * Uses orderGen to randomly select items from an order
     */
    public void buildOrder(Order order) throws IOException {
        //Number of items being added to each order
        int numberOfItems = 2;
        for ( int j = 0 ; j < numberOfItems; j++){
            //This should created a new OrderedItem and add to Arraylist of Order
            order.ad//makeOrder( "order.txt",true );//(currentMenuItems.get(restaurantMenu.getMenuSize()));
        }
    }
//    private void buildOrder(Order order)
//    {
//        //Number of items being added to each order
//        int numberOfItems = rand.getNumberOfItems();
//        for ( int j = 0 ; j < numberOfItems; j++){
//            //This should created a new OrderedItem and add to Arraylist of Order
//            order.add(currentMenuItems.get(rand.getItemIndex(menu.getMenuSize())));
//        }
//    }


    public class Randomizer

    {
        //class variable
        private Random rand;
        private static final int MAX_ORDERS = 2; //Per Simulation tick
        private static final int MAX_ITEMS = 15;
        private static final int NUMBER_OF_TABLES = 30;
        private static final long SEED = 1234567890;
        private static final boolean IS_REPEATABLE_DEFAULT = false;

        //Instance variables
        private boolean isRepeatable;

        //Constructors
        public Randomizer()
        {
            this(IS_REPEATABLE_DEFAULT);
        }

        public Randomizer(boolean isRepeatable)
        {
            if (rand == null){
                this.isRepeatable = isRepeatable;
                reset();
            }
        }

        // Methods
        /**
         * Resets the random generator
         *  If isRepeatable, remains repeatable
         *  If Random, remains random
         */
        private void reset()
        {
            if(isRepeatable)
                rand = new Random(SEED);
            else
                rand = new Random();
        }

        /**
         * Generates an integer
         *
         * @return Returns the number of orders to be completed (<= MAX_ORDERS)
         */
        public int getNumberOfOrders()
        {
            return rand.nextInt(MAX_ORDERS);
        }

        /**
         * Generates an integer
         *
         *
         */
        public int getNumberOfItems()
        {
            return rand.nextInt(MAX_ITEMS);
        }

        /**
         * Returns a random index of the menu's ArrayList<Item>
         *
         //* @param menu The Menu in use
         */
        public int getItemIndex(int number)
        {
            return rand.nextInt(number);
        }

        /**
         * Returns a random table number
         *
         */
        public int getTableNumber()
        {
            return rand.nextInt(NUMBER_OF_TABLES);
        }

    }
}