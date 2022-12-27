package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class ToBackCommand implements CommandInterface {

    private AnchorPane anchorPane;

    /**
     * 
     * @param anchorPane
     * It inits the ToBackCommand class.
     */
    public ToBackCommand(AnchorPane anchorPane){
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
     * Puts the figure passed as a parameter of type "node" into the background
     */
    @Override
    public void exeCommand(Node node) {
        node.toBack();
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
