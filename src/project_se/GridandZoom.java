package project_se;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;

public class GridandZoom {

    private AnchorPane anchorPane;
    private Slider sliderZoom;
    private Slider sliderGrid;
    private CheckBox checkBox;
    private Paint bg1, bg2; 
    private BackgroundFill backgroundFill1, backgroundFill2;
    private Canvas canvas = new Canvas(); 
    private SnapshotParameters sp = new SnapshotParameters();

    /**
     * 
     * @param anchorpane
     * @param sliderGrid
     * @param sliderZoom
     * @param checkBox
     * Inits the GridandZoom class.
     */
    public GridandZoom(AnchorPane anchorpane, Slider sliderGrid, Slider sliderZoom, CheckBox checkBox){
        this.anchorPane = anchorpane;
        this.sliderGrid = sliderGrid;
        this.sliderZoom = sliderZoom;
        this.checkBox = checkBox;
    }
    

    /** 
     * @return CheckBox
     * Returns the value of the Checkbox to verify if it is checked
     */
    private CheckBox getCheckBox(){
        return this.checkBox;
    }


    /**
     * Updates the grid: if the checkbox is selected it imposts the grid, else it returns the white drawing sheet
     */

    public void updateGrid() {
        double size = (sliderGrid.getValue()*4)*sliderZoom.getValue();
        if(!this.getCheckBox().isSelected()){
            bg1 = Paint.valueOf("white");
            backgroundFill1 = new BackgroundFill(bg1, null, null);
            anchorPane.setBackground(new Background(backgroundFill1));
        }
        else{
            bg2 = patternTransparent(size);
            backgroundFill2 = new BackgroundFill(bg2, null, null);
            anchorPane.setBackground(new Background(backgroundFill1, backgroundFill2));
        }
    }

    
    /** 
     * @param size
     * @return ImagePattern
     * Sets the properties of the grid (the ImagePattern class fills a shape with an image pattern. 
     * The user may specify the anchor rectangle, which defines the position, width, and height of 
     * the image relative to the upper left corner of the shape).
     */
    ImagePattern patternTransparent(double size) {
        canvas.setHeight(size);
        canvas.setWidth(size);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, size, size);
        gc.setFill(Color.BLACK);
        gc.strokeLine(0, 0, 0, size);
        gc.strokeLine(1, 0, size, 0);
        sp.setFill(Color.TRANSPARENT);
        WritableImage image = canvas.snapshot(sp, null);
        return new ImagePattern(image, 0, 0, size, size, false);
      }
}
