package controllers;

import gen_item.ResultItem;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class GraphController extends AnchorPane {

    private Parent root;

    @FXML
    LineChart<String, Double> idChart;

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

//        XYChart.Series series1 = new XYChart.Series();
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("cos(x)");
//        series1.setName("sin(x)");
//        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
//        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
//        double x = 0;
//        double delta = 0.1;
//        for (int i = 0; i < 100; i++) {
//            x = x + delta;
//            datas.add(new XYChart.Data<String, Double>(i + "", Math.sin(x)));
//            datas2.add(new XYChart.Data<String, Double>(i + "", Math.cos(x)));
//        }
//
//        series1.setData(datas);
//        series2.setData(datas2);
//
//        idChart.getData().clear();
//        idChart.getData().add(series1);
//
////        idChart.getData().add(series1);
//        idChart.getData().add(series2);
    }

    public Parent getRoot() {
        return root;
    }

    @FXML
    private void initialize() {
    }

    public void showGraph(List<ResultItem>... data) {
        for (int i = 0; i < data.length; i++) {
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("f" + i);
            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            data[i].forEach((t) -> {
                datas.add(new XYChart.Data<String, Double>(t.getX() + "", t.getFx()));
            });
            series1.setData(datas);
            idChart.setCreateSymbols(false);
            idChart.getData().add(series1);
        }

    }
}
