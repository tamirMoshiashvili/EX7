package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.code.TaxiCenter;

public class Controller {

    @FXML
    private TextField commandTxt;

    @FXML
    private TextField numTaxiTxt;

    @FXML
    private GridPane grid;

    @FXML
    private Label clock;

    @FXML
    private Label error;

    /**
     * Read the text from the text-field and execute the needed command.
     *
     * @param event event.
     */
    public void executeCmd(ActionEvent event) {
        // Clean the error label.
        error.setText("");
        // Read the text.
        String txt = commandTxt.getText().toLowerCase();
        if (txt.equals("7")) {
            // End of the game.
            Stage stage = (Stage) grid.getScene().getWindow();
            stage.close();
        } else {
            // Extract the commands information from the text.
            int id = Character.getNumericValue(txt.charAt(0));
            char direction = txt.charAt(2);
            // Move the taxi with the given id to the needed direction.
            TaxiCenter taxiCenter = TaxiCenter.getInstance(grid);
            boolean validMove = false;
            boolean validCharacter = true;
            if (taxiCenter.isInGame(id)) {
                // The player is in the game so move him.
                switch (direction) {
                    case 'a':
                        validMove = taxiCenter.moveLeft(id);
                        break;
                    case 's':
                        validMove = taxiCenter.moveDown(id);
                        break;
                    case 'd':
                        validMove = taxiCenter.moveRight(id);
                        break;
                    case 'w':
                        validMove = taxiCenter.moveUp(id);
                        break;
                    default:
                        error.setText("Invalid Character !!!");
                        validCharacter = false;
                }
                if (validMove) {
                    // Update the clock.
                    int currentTime = Integer.parseInt(clock.getText());
                    currentTime++;
                    clock.setText(Integer.toString(currentTime));
                } else if (validCharacter) {
                    error.setText("Invalid Move !!!");
                }
            }
        }
        // Clean the text-field.
        commandTxt.setText("");
    }

    /**
     * Read the text from the text-field, add the given number of taxi to the game.
     *
     * @param event event.
     */
    public void addTaxi(ActionEvent event) {
        // Clean the error label.
        error.setText("");
        int num = Integer.parseInt(numTaxiTxt.getText());
        TaxiCenter taxiCenter = TaxiCenter.getInstance(grid);
        taxiCenter.addTaxi(num);
        // Clean the text-field.
        numTaxiTxt.setText("");
    }
}
