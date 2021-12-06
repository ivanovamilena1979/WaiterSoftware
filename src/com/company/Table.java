package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Table {

    private int number;
    private boolean isFree = true;

    public Table(int number, boolean isFree) {
        this.number = number;
        this.isFree = isFree;
    }
    public Table() {
        this.number = 1;
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

    public static ArrayList<Table> readTableFromAFile(String fileName) {
        ArrayList<Table> tables = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Table table = createTable(attributes);
                tables.add(table);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tables;
    }
    public static Table createTable(String[] item) {
        int number = Integer.parseInt(item[0]);
        Boolean isFree = Boolean.parseBoolean( item[1] );


        return new Table(number, isFree);
    }

    @Override
    public String toString() {
        return "Table{" +
                "number=" + number +
                ", isFree=" + isFree +
                '}';
    }
}
