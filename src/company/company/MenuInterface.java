package company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface MenuInterface {


    void addRestaurantMenu(String fileName, String text, boolean append) throws IOException;

    void changeMenu()throws IOException;
}
