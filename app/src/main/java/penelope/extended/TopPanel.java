package penelope.extended;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        Menu menuLanguage = new Menu(Language.get(1));
        for (String key: Language.available.keySet()){
            MenuItem menuItem = new MenuItem(Language.available.get(key));
            menuItem.setOnAction(new LanguageSelected(key));
            menuLanguage.getItems().add(menuItem);
        }
        return new MenuBar(menuLanguage);
    }

    /**
     * Language actions.
     */
    class LanguageSelected implements EventHandler<ActionEvent>{

        // The new language to be setted.
        private String lang;

        /**
         * Initializer.
         * @param key (String) Lenguage to be setted.
         */
        public LanguageSelected(String key){
            lang = key;
        }

        /**
         * Changes the language.
         */
        @Override
        public void handle(ActionEvent event) {
            Language.changeLanguage(lang);
            if (!lang.equals(Language.lang)){
                MessageDialog dialog = new MessageDialog(Language.get(2));
                dialog.showAndWait();
            }
        }
    }
}
