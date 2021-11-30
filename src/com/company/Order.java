package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Order implements OrderInterface {
    private int table;
    private boolean done;
    private LocalDate data;
    private Collection<Menu> menu;


    public Order(int table, List<Menu> menu) {

        data = LocalDate.now();
        this.table = table;
        this.menu = menu;
        done = false;
    }

    public int getTable() {
        return table;
    }
    


    public LocalDate getDate() {
        return data;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
   
    public List<Menu> getListOfItems() {
        return new ArrayList<>(menu);
    }
    
    Collection<Menu> getMenuItems() {
        return menu;
    }


    @Override
    public void makeAOrder(Table tableOfOrder) {
        
    }

    @Override
    public void checkIfTableIsFree(Table tableOfOrder) throws IllegalArgumentException {

    }

    @Override
    public void addFoodToOrder(Menu DishToAdd) {

    }

    @Override
    public void removeFoodFromOrder(Menu dishToRemove) {

    }

    @Override
    public double calcTheTotalPriceOfOrder() {
        return 0;
    }

    @Override
    public void changeOrderStatusToPayedAndFinish(Table tableOfOrdrer) {

    }

    @Override
    public void changeOrderStatusToServed() {

    }
}