package controllers;

import gen_algoritm.implementation.Population;
import gen_item.Bot;
import gen_item.BotBase;
import gen_item.BotResult;
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

    private static final int COUNT = 50;
    private static final int a = 0;
    private static double b = 10;
    private static final double DELTA_X = (b - a) / COUNT;
    private Parent root;
    double[] x = new double[COUNT];

    @FXML
    LineChart<String, Double> idChart;

    @FXML
    Button idBtnStart;
    
    @FXML
    Button idBtnNextStep;

    public GraphController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GraphController.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            root = fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        for (int i = 0; i < COUNT; i++) {
            x[i] = a + i * DELTA_X;
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

        List<BotResult> listItem = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Bot bot = new Bot(x);
            bot.calc();
            listItem.add(bot.getResult());
        }

        showGraph(listItem);
    }

    public void showGraph(List<BotResult> dataList) {
        idChart.getData().clear();
        //Рисуем sin
        BotBase base = new BotBase(x);
        base.calc();
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("sin(x)");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        base.getResultList().forEach((t1) -> {
            datas.add(new XYChart.Data<String, Double>(t1.getX() + "", t1.getFx()));
        });
        series1.setData(datas);
        idChart.setCreateSymbols(false);
        idChart.getData().add(series1);

        dataList.forEach((t) -> {
            XYChart.Series series2 = new XYChart.Series();
            series2.setName(t.getName());
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();
            t.getResltCalc().forEach((t1) -> {
                datas1.add(new XYChart.Data<String, Double>(t1.getX() + "", t1.getFx()));
            });
            series2.setData(datas1);
            idChart.setCreateSymbols(false);
            idChart.getData().add(series2);
        });
    }
    
    @FXML
    public void btnNextStepClick(ActionEvent actionEvent) {
        LOG.info(String.format("action = %s", actionEvent));
        Population population = new Population(10);
    }
}
