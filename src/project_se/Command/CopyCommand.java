package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import project_se.ShapeInterface;

public class CopyCommand implements CommandInterface{

    private AnchorPane anchorPane;
    private ShapeInterface shapeCopy;

    /**
     * 
     * @param anchorPane
     * It inits the CopyCommand class.
     */
    public CopyCommand(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
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
     * @return ShapeInterface
     * Returns a copy of the shape as type ShapeInterface
     */
    public ShapeInterface getShapeCopy() {
        return this.shapeCopy;
    }
    
    /** 
     * @param shapeCopy
     * Sets the Shape copy
     */
    public void setShapeCopy(ShapeInterface shapeCopy) {
        this.shapeCopy = shapeCopy;
    }

    /** 
     * @param node
     * Save the copy of the passed shape as a parameter in the variable "shapeCopy"
     */
    @Override
    public void exeCommand(Node node) {
        this.shapeCopy = ((ShapeInterface) node).getAcopy((ShapeInterface)node);
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
