package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class description ...
 * Included in application
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 19. Jun 2017
 */
public class ApplicationController extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp);
        stage.setTitle("Student");
        stage.setWidth(900);
        stage.setHeight(700);

        PieChart.Data first = new PieChart.Data("internal additional master [69%]", 69);
        PieChart.Data second = new PieChart.Data("internal master [12%]", 12);
        PieChart.Data third = new PieChart.Data("remaining [19%]", 19);

        first.pieValueProperty().addListener((observable, oldValue, newValue) -> {
            first.setName("internal additional master [" + Math.round(newValue.doubleValue()) + "%]");
            if(newValue.doubleValue() + second.getPieValue() >= 100){
                second.setPieValue(100-newValue.doubleValue());
                third.setPieValue(0);
            } else {
                third.setPieValue(100-(newValue.doubleValue() + second.getPieValue()));
            }
        });

        second.pieValueProperty().addListener((observable, oldValue, newValue) -> {
            second.setName("internal master [" + Math.round(newValue.doubleValue()) + "%]");
            if(newValue.doubleValue() + first.getPieValue() >= 100){
                first.setPieValue(100-newValue.doubleValue());
                third.setPieValue(0);
            } else {
                third.setPieValue(100-(newValue.doubleValue() + first.getPieValue()));
            }
        });

        third.pieValueProperty().addListener((observable, oldValue, newValue) -> {
            third.setName("remaining [" + Math.round(newValue.doubleValue()) + "%]");
        });

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(first, second, third);
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Student allocation in master term");
        bp.setCenter(chart);

        Slider firstSlider = new Slider(0, 100, 69);
        firstSlider.valueProperty().bindBidirectional(first.pieValueProperty());
        firstSlider.setShowTickLabels(true);
        firstSlider.setShowTickMarks(true);
        firstSlider.setMajorTickUnit(50);
        firstSlider.setMinorTickCount(5);
        firstSlider.setBlockIncrement(10);
        firstSlider.setMinWidth(400);
        Slider secondSlider = new Slider(0, 100, 12);
        secondSlider.valueProperty().bindBidirectional(second.pieValueProperty());
        secondSlider.setShowTickLabels(true);
        secondSlider.setShowTickMarks(true);
        secondSlider.setMajorTickUnit(50);
        secondSlider.setMinorTickCount(5);
        secondSlider.setBlockIncrement(10);
        secondSlider.setMinWidth(400);

        HBox topHbox = new HBox();
        topHbox.getChildren().addAll(firstSlider, secondSlider);
        topHbox.setAlignment(Pos.CENTER);


        VBox vbox = new VBox();
        vbox.setMaxWidth(200);
        vbox.getChildren().addAll(topHbox);

        bp.setBottom(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
