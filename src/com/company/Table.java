package com.company;

import java.util.ArrayList;

public class Table {

    ArrayList<Order> orderLists;
    ArrayList<Table> tables = new ArrayList<>();
    private int number;
    private boolean isFree;

    public Table(int number, ArrayList<Order> orderLists) {
        this.number = number;
        this.orderLists = orderLists;
        if (orderLists.contains( null )) {
            this.isFree = true;
        } else this.isFree = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }


    @Override
    public String toString() {
        return "Table{" +
                "table: " + number +
                ", orders: " + orderLists +
                '}';
    }

}
