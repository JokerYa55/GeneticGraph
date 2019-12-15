package controllers;

import gen_item.Bot;
import gen_item.ResultItem;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class GraphController extends AnchorPane {

    private static final Logger LOG = Logger.getLogger(GraphController.class.getName());

    private static final int COUNT = 10;
    private static final int a = 0;
    private static double b = 10;
    private static final double DELTA_X = (b - a) / COUNT;
    private Parent root;

    @FXML
    LineChart<String, Double> idChart;

    @FXML
    Button idBtnStart;

    public GraphController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GraphController.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            root = fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        idChart.setTitle("Series");

    }

    public Parent getRoot() {
        return root;
    }

    @FXML
    private void initialize() {
    }

    @FXML
    public void btnStartClick(ActionEvent actionEvent) {
        LOG.info(String.format("action = %s", actionEvent));
        // Генерируем массив bot
        double[] x = new double[COUNT];
        for (int i = 0; i < COUNT; i++) {
            x[i] = a + i * DELTA_X;
        }
        List<List<ResultItem>> listItem = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Bot bot = new Bot(x);
            bot.calc();
            listItem.add(bot.getResultList());
        }

        showGraph(listItem);
    }

    public void showGraph(List<List<ResultItem>> dataList) {
        idChart.getData().clear();
        dataList.forEach((t) -> {
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("f");
            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            t.forEach((t1) -> {
                datas.add(new XYChart.Data<String, Double>(t1.getX() + "", t1.getFx()));
            });
            series1.setData(datas);
            idChart.setCreateSymbols(false);
            idChart.getData().add(series1);
        });

    }
}
