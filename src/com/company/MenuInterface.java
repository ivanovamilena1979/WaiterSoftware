package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface MenuInterface {


    void addRestaurantMenu(String fileName, boolean append) throws IOException;

    void changeMenu()throws IOException;
}
