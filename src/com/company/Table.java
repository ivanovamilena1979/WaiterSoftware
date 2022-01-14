package com.company;

import java.util.ArrayList;

public class Table {

    private int number;
    private boolean isFree;
    ArrayList<Order>orderLists;
    ArrayList<Table>tables=new ArrayList<>();
//    Table table1 = new Table( 1, orderLists );
//    Table table2 = new Table( 2, orderLists );
//    Table table3 = new Table( 3, orderLists );
//    Table table4 = new Table( 4, orderLists );
//    Table table5 = new Table( 5, orderLists );


    public Table(int number,ArrayList<Order>orderLists) {
        this.number = number;
        this.orderLists=orderLists;
        if (orderLists.contains( null )){
        this.isFree=true;}
        else this.isFree=false;}

//        public void chooseATableToManageAnOrder(int tableNumber){
//            for(Table table:table){
//                if(name.equals(item.getName())){
//                    System.out.println(item.getName() + " has been removed from the menu.");
//                    menuItems.remove(item);
//                    break;
//                }
//            }
//            System.out.println("No item found");
//        }
//
//    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() { return isFree;
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
