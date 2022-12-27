package project_se.Command;

import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

public class DeleteCommand implements CommandInterface {

    private AnchorPane anchorPane;

    /**
     * 
     * @param anchorPane
     * It inits the DeleteCommand class.
     */
    public DeleteCommand(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }


    
    /** 
     * @param node
     * Delete the shape passed as a parameter
     */
    @Override
    public void exeCommand(Node node) {
        this.anchorPane.getChildren().remove(node);    
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
