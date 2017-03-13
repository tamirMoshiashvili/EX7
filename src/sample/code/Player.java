package sample.code;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Object that holds data about image in grid-pane.
 */
public class Player {

    private ImageView img;
    private int col;
    private int row;
    private boolean visible;

    /**
     * Constructor.
     *
     * @param url    string which is the url to the image-file.
     * @param width  width of the image.
     * @param height height of the image.
     */
    public Player(String url, double width, double height) {
        Image image = new Image(getClass().getResourceAsStream(url));
        this.img = new ImageView(image);
        this.img.setFitHeight(height);
        this.img.setFitWidth(width);
        this.col = 0;
        this.row = 9;
        this.visible = false;
    }

    /**
     * Get the image-view object.
     *
     * @return image-view object.
     */
    public ImageView getImg() {
        return this.img;
    }

    /**
     * Get the column index.
     *
     * @return integer.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Get the row index.
     *
     * @return integer.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Check if the player is in the game.
     *
     * @return true if it is, false otherwise.
     */
    public boolean isVisible() {
        return this.visible;
    }

    /**
     * Set the col of the player to the given.
     *
     * @param newCol index.
     */
    public void setCol(int newCol) {
        this.col = newCol;
    }

    /**
     * Set the row of the player to the given.
     *
     * @param newRow index.
     */
    public void setRow(int newRow) {
        this.row = newRow;
    }

    /**
     * Set the visibility of the player to the given.
     *
     * @param newVisible true if in game, false otherwise.
     */
    public void setVisible(boolean newVisible) {
        this.visible = newVisible;
    }
}
