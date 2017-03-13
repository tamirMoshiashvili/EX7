package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import javax.swing.text.html.ImageView;
import java.awt.event.KeyEvent;


public class Controller {

    @FXML
    private TextField commandTxt;

    @FXML
    private TextField numTaxiTxt;

    @FXML
    private ImageView taxi;

    @FXML
    private VBox vbTaxi;

    public void showCmnd(ActionEvent event) {
        System.out.println(commandTxt.getText());
        commandTxt.setText("");
    }

    public void showNumTaxi(ActionEvent event) {
        System.out.println(numTaxiTxt.getText());
        numTaxiTxt.setText("");
    }
    public void upTaxi(KeyEvent event) {
        if (event.getKeyCode() == KeyCode.UP.hashCode())
            System.out.println("hello");
    }


}
