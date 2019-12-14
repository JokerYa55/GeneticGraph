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

    private static final int COUNT = 100;
    private static final int a = 0;
    private static double b = 30;
    private static final double DELTA_X = (b - a) / COUNT;
    private static GraphController gController;
    private static Bot bot;
    private static Bot bot1;

    public static void main(String[] args) {
        launch(args);
        LOG.info("Start");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GraphController controller = new GraphController();
        gController = controller;
        gController.showGraph(bot.getResultList(), bot1.getResultList());
        primaryStage.setScene(new Scene(controller.getRoot()));
        primaryStage.show();

    }

    static {
        double[] x = new double[COUNT];
        for (int i = 0; i < COUNT; i++) {
            x[i] = a + i * DELTA_X;
        }
        bot = new Bot(x);
        bot.calc();
        
        bot1 = new Bot(x);
        bot1.calc();
//        bot.getResultList().forEach((t) -> {
//            System.out.println(String.format("t = %s", t));
//        });
    }
}
