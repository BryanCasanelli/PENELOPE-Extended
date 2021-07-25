package penelope.extended;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.JMetroStyleClass;
import jfxtras.styles.jmetro.Style;

/**
 * Main class
 */
public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method
     */
    @Override
    public void start(Stage primaryStage) {
        // Window title
        primaryStage.setTitle("PENELOPE Extended");
        // Window icon
        primaryStage.getIcons().add(new Image(App.class.getClassLoader().getResourceAsStream("images/icon_256.png")));
        // Layout
        VBox layout = new VBox();
        // Scene
        Scene scene = new Scene(layout);
        // Configure the theme
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene);
        layout.getStyleClass().add(JMetroStyleClass.BACKGROUND);
        // Menu bar
        layout.getChildren().add(menuBar());
        // Separator
        layout.getChildren().add(new Separator());
        // Show
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
    }

    /**
     * Constructs the menu bar
     */
    public MenuBar menuBar(){
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
