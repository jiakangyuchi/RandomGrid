/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dale
 */
public class RandomGridFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private final int numRows = 53;
    private final int numColumns = 53;
    
    private grid.Grid randomGrid;
   
    @FXML
    private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        randomGrid = new grid.RandomGrid(numRows, numColumns);
        vBox.getChildren().add(randomGrid.getBoard());
        
        /*
        this.gridPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                refresh();
            }
        });
        
        this.gridPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                refresh();
            }
        });
        */
        /*
        this.stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                refresh();
            }
        });
        
        this.stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                refresh();
            }
        });
        */
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();

        
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        refresh();
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("clear");
        clearGridPane();
    }
    
    @FXML
    private void handleAbout(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("RandomGrid");
        alert.setContentText("This application was developed by Dale Musser for CS4330/7330 at the University of Missouri.  This is based on the code provided at http://code.makery.ch/blog/javafx-dialogs-official/");
        alert.showAndWait();
    }
    
    private void refresh() {
        randomGrid.build(stage.getWidth(), stage.getHeight());
    }
    
    private void clearGridPane() {
        randomGrid.clear();
    }
    

    
}
