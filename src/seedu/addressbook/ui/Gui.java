package seedu.addressbook.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import seedu.addressbook.logic.Logic;
import seedu.addressbook.Main;

import java.io.File;
import java.io.IOException;

/**
 * The GUI of the App
 */
public class Gui {

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public static final int INITIAL_WINDOW_WIDTH = 800;
    public static final int INITIAL_WINDOW_HEIGHT = 600;
    private final Logic logic;

    private MainWindow mainWindow;
    private String version;

    public Gui(Logic logic, String version) {
        this.logic = logic;
        this.version = version;
    }

    public void start(Stage stage, Stoppable mainApp) throws IOException {
        mainWindow = createMainWindow(stage, mainApp);
        mainWindow.displayWelcomeMessage(version, logic.getStorageFilePath());
        
    }

    private MainWindow createMainWindow(Stage stage, Stoppable mainApp) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ui" + File.separator + "mainwindow.fxml"));
        stage.setTitle(version);
        stage.setScene(new Scene(loader.load(), INITIAL_WINDOW_WIDTH, INITIAL_WINDOW_HEIGHT));
        //Set application icon
        stage.getIcons().add(new Image("file:resources/images/appIcon.png"));
        stage.show();
        MainWindow mainWindow = loader.getController();
        mainWindow.setLogic(logic);
        mainWindow.setMainApp(mainApp);
        return mainWindow;
    }

}
