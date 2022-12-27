package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import project_se.ShapeInterface;


public class RotateCommand implements CommandInterface{

    private AnchorPane anchorPane;
    private double angle;

    /**
     * 
     * @param anchorPane
     * @param angle
     * It inits the RotateCommand class.
     */
    public RotateCommand(AnchorPane anchorPane, double angle){
        this.anchorPane = anchorPane;
        this.angle = angle;
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
     * @param angle
     * Sets the rotation angle of the shape
     */
    public void setAngle (double angle){
        this.angle= angle;
    }

    
    /** 
     * @return double
     * Returns the rotation angle of the shape
     */
    public double getAngle (){
        return this.angle;
    }

    
    /** 
     * @param node
     * Reset the rotation angle and then rotate the figure
     */
    @Override
    public void exeCommand(Node node) {
        ((ShapeInterface) node).setAngle(this.getAngle());
        ((Shape)node).setRotate(((ShapeInterface) node).getAngle());  
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
