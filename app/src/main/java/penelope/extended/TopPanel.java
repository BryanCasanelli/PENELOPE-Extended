package penelope.extended;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Menu bar related things
 */
public class TopPanel {

    /**
     * Constructs the menu bar
     */
    public MenuBar generate(){
        MenuBar output = new MenuBar();
        Menu menu = new Menu("Menu 1");
        MenuItem menuItem1 = new MenuItem("Item 1");
        MenuItem menuItem2 = new MenuItem("Item 2");

        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);

        output.getMenus().add(menu);
        return output;
    }
}
