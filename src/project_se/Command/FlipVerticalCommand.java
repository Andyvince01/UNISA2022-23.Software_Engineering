package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class FlipVerticalCommand implements CommandInterface{

    private AnchorPane anchorPane;

    /**
     * 
     * @param anchorPane
     * It inits the FlipVerticalCommand class.
     */
    public FlipVerticalCommand(AnchorPane anchorPane){
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
     * @param node
     * Change the scale of the shape to flip vertically
     */
    @Override
    public void exeCommand(Node node) {
        node.setScaleY(node.getScaleY()*-1);
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
