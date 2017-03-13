package sample.code;

import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton of players that handles the logic of the game.
 */
public class TaxiCenter {

    private static TaxiCenter ourInstance = null;
    private Map<Integer, Player> players;
    private GridPane grid;

    /**
     * Constructor.
     *
     * @param gridPane grid pane.
     */
    private TaxiCenter(GridPane gridPane) {
        this.grid = gridPane;
        // Calculate the width and height of image.
        double width = (grid.getPrefWidth() - grid.getHgap() * 9) / 10;
        double height = (grid.getPrefHeight() - grid.getVgap() * 9) / 10;

        this.players = new HashMap<Integer, Player>();
        // Create 5 players.
        this.players.put(0, new Player("../resources/blue_car.png", width, height));
        this.players.put(1, new Player("../resources/bluish_car.png", width, height));
        this.players.put(2, new Player("../resources/green_car.png", width, height));
        this.players.put(3, new Player("../resources/pink_car.png", width, height));
        this.players.put(4, new Player("../resources/red_car.png", width, height));
    }

    /**
     * Get the instance of the class.
     *
     * @param gridPane grid pane.
     * @return taxi center object.
     */
    public static TaxiCenter getInstance(GridPane gridPane) {
        if (ourInstance == null) {
            ourInstance = new TaxiCenter(gridPane);
        }
        return ourInstance;
    }

    /**
     * Check if the player with the given id is in the game.
     * @param id id number of a player.
     * @return true if the player is in the game, false otherwise.
     */
    public boolean isInGame(int id){
        return players.get(id).isVisible();
    }

    /**
     * Remove the image from the old-location and set it to the new location.
     *
     * @param player the player to get the data from.
     */
    private void update(Player player) {
        this.grid.getChildren().remove(player.getImg());
        this.grid.add(player.getImg(), player.getCol(), player.getRow());
    }

    /**
     * Move the player up.
     *
     * @param id id number of player.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveUp(int id) {
        Player player = this.players.get(id);
        int row = player.getRow();
        if (row == 0) {
            // Invalid movement.
            return false;
        }
        player.setRow(row - 1);
        update(player);
        return true;
    }

    /**
     * Move the player down.
     *
     * @param id id number of player.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveDown(int id) {
        Player player = this.players.get(id);
        int row = player.getRow();
        if (row == 9) {
            // Invalid movement.
            return false;
        }
        player.setRow(row + 1);
        update(player);
        return true;
    }

    /**
     * Move the player right.
     *
     * @param id id number of player.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveRight(int id) {
        Player player = this.players.get(id);
        int col = player.getCol();
        if (col == 9) {
            // Invalid movement.
            return false;
        }
        player.setCol(col + 1);
        update(player);
        return true;
    }

    /**
     * Move the player left.
     *
     * @param id id number of player.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveLeft(int id) {
        Player player = this.players.get(id);
        int col = player.getCol();
        if (col == 0) {
            // Invalid movement.
            return false;
        }
        player.setCol(col - 1);
        update(player);
        return true;
    }

    /**
     * Add number of taxies to the game according to the given number.
     *
     * @param num the number of the players to add.
     */
    public void addTaxi(int num) {
        // Iterate through the players.
        for (Player player : this.players.values()) {
            if (num > 0 && !player.isVisible()) {
                // Add the player to the game.
                player.setVisible(true);
                this.grid.add(player.getImg(), player.getCol(), player.getRow());
                --num;
            }
            if (num == 0) {
                // Done adding taxi.
                break;
            }
        }
    }
}
