package penelope.extended;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
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

    public static void main(String[] args) throws IOException {
        // Initialize the language class
        Language.init();
        // Start the application
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
        TopPanel menuBar = new TopPanel();
        layout.getChildren().add(menuBar.generate());
        // Separator
        layout.getChildren().add(new Separator());
        // Show
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
    }
}
