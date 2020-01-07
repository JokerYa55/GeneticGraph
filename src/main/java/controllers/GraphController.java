package controllers;

import beans.PopulationInfo;
import gen_algoritm.CalcResultInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.SelectionInterface;
import gen_algoritm.implementation.GraphSelection;
import gen_algoritm.implementation.Population;
import java.io.IOException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class GraphController extends AnchorPane {
    
    private static final Logger LOG = Logger.getLogger(GraphController.class.getName());
    
    private static final int COUNT = 50;
    PopulationInterface population;
    private static final int a = 0;
    private static double b = 10;
    private static final double DELTA_X = (b - a) / COUNT;
    private Parent root;
    Double[] x = new Double[COUNT];
    
    @FXML
    LineChart<String, Double> idChart;
    
    @FXML
    Button idBtnStart;
    
    @FXML
    Button idBtnNextStep;
    
    @FXML
    TableView<PopulationInfo> idDataTable;
    
    @FXML
    private TableColumn<PopulationInfo, Integer> idColumn;
    
    @FXML
    private TableColumn<PopulationInfo, Double> aColumn;
    
    @FXML
    private TableColumn<PopulationInfo, Double> bColumn;
    
    @FXML
    private TableColumn<PopulationInfo, Double> cColumn;
    
    @FXML
    private TableColumn<PopulationInfo, Double> dColumn;
    
    @FXML
    private TableColumn<PopulationInfo, Double> fColumn;
    
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
        
        population = new Population(10, x);
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
        
    }
    
    public void shiwTable() {
        ObservableList<PopulationInfo> populationInfo = FXCollections.observableArrayList();
        population.getPipulationItemList().forEach((t) -> {
            System.out.println(String.format("criteria 2 = %s", t.getCriteriaResult()));            
        });
        
        population.getPipulationItemList().forEach((t) -> {
            Double[] gen = ((GenInterface) t.getGen()).getGenAsArray();
            populationInfo.add(new PopulationInfo(1, gen[0], gen[1], gen[2], gen[3], (Double) t.getCriteriaResult()));
        });
        
        populationInfo.forEach((t) -> {
            System.out.println(String.format("t = %s", t));
        });
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        aColumn.setCellValueFactory(new PropertyValueFactory<>("a"));
        bColumn.setCellValueFactory(new PropertyValueFactory<>("b"));
        cColumn.setCellValueFactory(new PropertyValueFactory<>("c"));
        dColumn.setCellValueFactory(new PropertyValueFactory<>("d"));
        fColumn.setCellValueFactory(new PropertyValueFactory<>("f"));
        idDataTable.setItems(populationInfo);
    }
    
    public void showGraph1() {
        idChart.getData().clear();
        //Рисуем sin
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("sin(x)");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        List<CalcResultInterface<Double, Double>> baseList = population.getPipulationItemList().get(0).getBaseResultList();
        baseList.forEach((t1) -> {
            datas.add(new XYChart.Data<String, Double>(t1.getX() + "", t1.getY()));
        });
        series1.setData(datas);
        idChart.setCreateSymbols(false);
        idChart.getData().add(series1);
        
        population.getPipulationItemList().forEach((t) -> {
            XYChart.Series series2 = new XYChart.Series();
            series2.setName(t.getName());
            List<CalcResultInterface<Double, Double>> genList = t.getGenResultList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();
            genList.forEach((t1) -> {
                datas1.add(new XYChart.Data<String, Double>(t1.getX() + "", t1.getY()));
            });
            series2.setData(datas1);
            idChart.setCreateSymbols(false);
            idChart.getData().add(series2);
        });
    }
    
    @FXML
    public void btnNextStepClick(ActionEvent actionEvent) {
        LOG.info(String.format("action = %s", actionEvent));
        population.nextStep();
        shiwTable();
        showGraph1();
    }
}
