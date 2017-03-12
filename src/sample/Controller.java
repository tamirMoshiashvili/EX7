package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField commandTxt;

    @FXML
    private TextField numTaxiTxt;


    public void showCmnd(ActionEvent event){
        System.out.println(commandTxt.getText());
        commandTxt.setText("");
    }

    public void showNumTaxi(ActionEvent event){
        System.out.println(numTaxiTxt.getText());
        numTaxiTxt.setText("");
    }
}


