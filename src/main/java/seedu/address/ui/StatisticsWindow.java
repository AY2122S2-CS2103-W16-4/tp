package seedu.address.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;

/**
 * The Statistics Window. Provides the basic application layout containing
 * space to display statistics of clients information in the application.
 */
public class StatisticsWindow extends UiPart<Stage> {
    private static final String FXML = "StatisticsWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Logic logic;

    @FXML
    private PieChart pieChart;

    /**
     * Sets up Logic instance in StatisticsWindow
     */
    public StatisticsWindow(Logic logic) {
        super(FXML);
        this.logic = logic;
    }

    /**
     * Calls method to fill in data into PieChart
     */
    public void show() {
        fillPieChartData();
        logger.fine("Showing Statistics Window.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Fills up data into PieChart
     */
    void fillPieChartData() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " tasks: ", data.pieValueProperty()
                        )
                ));
        pieChart.getData().addAll(pieChartData);
    }
}
