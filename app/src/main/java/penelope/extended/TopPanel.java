package penelope.extended;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Menu bar related things.
 */
public class TopPanel {

    /**
     * Constructs the menu bar.
     */
    public MenuBar generate(){
        // Language
        Menu menuLanguage = new Menu(Language.get(0));
        for (String key: Language.available.keySet()){
            MenuItem menuItem = new MenuItem(Language.available.get(key));
            menuLanguage.getItems().add(menuItem);
        }
        return new MenuBar(menuLanguage);
    }
}
