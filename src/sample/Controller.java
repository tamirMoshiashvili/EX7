package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField commandTxt;

    @FXML
    private TextField numTaxiTxt;

    @FXML
    private GridPane grid;

    public void showCmnd(ActionEvent event) {
        System.out.println(commandTxt.getText());
        commandTxt.setText("");
        double width = (grid.getPrefWidth() - grid.getHgap() * 9) / 10;
        double height = (grid.getPrefHeight() - grid.getVgap() * 9) / 10;
        Image red = new Image(getClass().getResourceAsStream("resources/red_car.png"));
        ImageView red_img = new ImageView(red);
        red_img.setFitHeight(height);
        red_img.setFitWidth(width);
        grid.add(red_img, 0, 0);


        Stage stage = (Stage) grid.getScene().getWindow();
        stage.close();
    }

    public void showNumTaxi(ActionEvent event) {
        System.out.println(numTaxiTxt.getText());
        numTaxiTxt.setText("");
        Image bluish = new Image(getClass().getResourceAsStream("resources/bluish_car.png"));
        ImageView bluish_img = new ImageView(bluish);
        double width = (grid.getPrefWidth() - grid.getHgap() * 9) / 10;
        double height = (grid.getPrefHeight() - grid.getVgap() * 9) / 10;
        bluish_img.setFitHeight(height);
        bluish_img.setFitWidth(width);
        grid.add(bluish_img, 3, 3);
    }
}
