package company;

import java.io.IOException;

public interface MenuInterface {


    void addRestaurantMenu(String fileName, boolean append) throws IOException;

    void changeMenu()throws IOException;
}
