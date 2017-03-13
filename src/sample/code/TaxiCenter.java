package sample.code;

import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

/**
 * Collection of players that handles the logic of the game.
 */
public class TaxiCenter {

    private Map<Integer, Player> players;

    /**
     * Constructor.
     */
    public TaxiCenter() {
        players = new HashMap<Integer, Player>();
        // Create 5 players.
        players.put(0, new Player("blue_car.png"));
        players.put(1, new Player("bluish_car.png"));
        players.put(2, new Player("green_car.png"));
        players.put(3, new Player("pink_car.png"));
        players.put(4, new Player("red_car.png"));
    }

    /**
     * Remove the image from the old-location and set it to the new location.
     * @param grid grid pane object.
     * @param player the player to get the data from.
     */
    private void update(GridPane grid, Player player) {
        grid.getChildren().remove(player.getImg());
        grid.add(player.getImg(), player.getCol(), player.getRow());
    }

    /**
     * Move the player up.
     * @param id id number of player.
     * @param grid grid pane.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveUp(int id, GridPane grid) {
        Player player = players.get(id);
        int row = player.getRow();
        if (row == 0) {
            // Invalid movement.
            return false;
        }
        player.setRow(row - 1);
        update(grid, player);
        return true;
    }

    /**
     * Move the player down.
     * @param id id number of player.
     * @param grid grid pane.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveDown(int id, GridPane grid) {
        Player player = players.get(id);
        int row = player.getRow();
        if (row == 9) {
            // Invalid movement.
            return false;
        }
        player.setRow(row + 1);
        update(grid, player);
        return true;
    }

    /**
     * Move the player right.
     * @param id id number of player.
     * @param grid grid pane.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveRight(int id, GridPane grid) {
        Player player = players.get(id);
        int col = player.getCol();
        if (col == 9) {
            // Invalid movement.
            return false;
        }
        player.setCol(col + 1);
        update(grid, player);
        return true;
    }

    /**
     * Move the player left.
     * @param id id number of player.
     * @param grid grid pane.
     * @return true if the movement was valid, false otherwise.
     */
    public boolean moveLeft(int id, GridPane grid) {
        Player player = players.get(id);
        int col = player.getCol();
        if (col == 0) {
            // Invalid movement.
            return false;
        }
        player.setCol(col - 1);
        update(grid, player);
        return true;
    }

    /**
     * Add number of taxies to the game according to the given number.
     * @param num the number of the players to add.
     * @param grid grid pane.
     */
    public void addTaxi(int num, GridPane grid) {
        // Iterate through the players.
        for (Player player : players.values()) {
            if (num-- > 0 && !player.isVisible()) {
                // Add the player to the game.
                player.setVisible(true);
                grid.add(player.getImg(), player.getCol(), player.getRow());
            }
            if (num == 0){
                // Done adding taxi.
                break;
            }
        }
    }
}
