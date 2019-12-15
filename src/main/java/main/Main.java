package main;

import controllers.GraphController;
import gen_item.Bot;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private static GraphController gController;

    public static void main(String[] args) {
        launch(args);
        LOG.info("Start");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GraphController controller = new GraphController();
        gController = controller;
        primaryStage.setScene(new Scene(controller.getRoot()));
        primaryStage.show();

    }
}
