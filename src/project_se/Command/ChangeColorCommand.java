package project_se.Command;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import project_se.ShapeInterface;
import javafx.scene.paint.Color;
import javafx.scene.Node;


public class ChangeColorCommand implements CommandInterface {

    private AnchorPane anchorPane;
    private Color color;
    private boolean val;

    /**
     * 
     * @param anchorPane
     * @param color
     * @param val
     * It inits the ChangeColorCommand class.
     */
    public ChangeColorCommand (AnchorPane anchorPane, Color color, boolean val) {
        this.anchorPane = anchorPane;
        this.color = color;
        this.val = val;
    }

    /**
     * 
     * @return an anchorpane object.
     */    
    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    /**
     * 
     * @param anchorPane
     * Overrides the anchorPane attribute access mechanism.
     */
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
    
    /** 
     * @param color
     * Sets the color of the object 
     */
    public void setColor (Color color){
        this.color= color;
    }

    
    /** 
     * @return Color
     * Returns the color of the object 
     */
    public Color getColor (){
        return this.color;
    }
    
    
    /** 
     * @param val
     * Sets the value "val" used to distinguish border from fill
     */
    public void setVal (boolean val){
        this.val= val;
    }

    
    /** 
     * @return boolean
     * Returns the value of the object "val"
     */
    public boolean getVal (){
        return this.val;
    }

    
    /** 
     * @param node
     * Change the border and fill color of the shape passed as a parameter, as a node type
     */
    @Override
    public void exeCommand(Node node) {
        if(this.val == true){
            ((ShapeInterface) node).setColorFill(this.getColor());
            ((Shape) node).setFill(((ShapeInterface) node).getColorFill());
        }
        else{
            ((ShapeInterface) node).setColorStroke(this.getColor());
            ((Shape) node).setStroke(((ShapeInterface) node).getColorStroke());
        }
    }

    
    /** 
     * @param node
     * @param x
     * @param y
     */
    @Override
    public void exeCommand(Node node, double x, double y) {
        // TODO Auto-generated method stub
        
    }
    
}