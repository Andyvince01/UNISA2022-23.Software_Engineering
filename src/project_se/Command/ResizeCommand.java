package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import project_se.ShapeInterface;

public class ResizeCommand implements CommandInterface{

    private AnchorPane anchorPane;

    /**
     * 
     * @param anchorPane
     * It inits the ResizeCommand class.
     */
    public ResizeCommand(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
    }

    /** 
     * @param anchorPane
     * Sets the value of the anchor pane with its parameters
     */
    public void setAnchorPane(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
    }

    
    /** 
     * @return AnchorPane
     * Returns the value of the anchor pane with its parameters
     */
    public AnchorPane getAnchorPane(){
        return this.anchorPane;
    }
    
    /** 
     * @param node
     */
    @Override
    public void exeCommand(Node node) {
        // TODO Auto-generated method stub
        
    }

    
    /** 
     * @param node
     * @param x
     * @param y
     * Thanks to the "setSize" method, the size of the node passed as a parameter is reset
     */
    @Override
    public void exeCommand(Node node, double x, double y) {
        ((ShapeInterface)node).setSize(x, y);
    }

}
