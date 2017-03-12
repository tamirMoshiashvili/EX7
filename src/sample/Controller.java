package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;

public class Controller {
    @FXML
    private TextField send_feild;

    public void printMsg(ActionEvent event){
        System.out.println("You pressed me!");
    }

}
