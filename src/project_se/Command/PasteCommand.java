package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import project_se.CareTaker;
import project_se.DragMod;
import project_se.FXMLDocumentController;
import project_se.ShapeInterface;

public class PasteCommand implements CommandInterface {
    
    private AnchorPane anchorPane;
    private CareTaker cTaker;
    private FXMLDocumentController controller;

    /**
     * 
     * @param anchorPane
     * @param cTaker
     * @param controller
     * It inits the PasteCommand class.
     */
    public PasteCommand(AnchorPane anchorPane, CareTaker cTaker, FXMLDocumentController controller) {
        this.anchorPane = anchorPane;
        this.cTaker = cTaker;
        this.controller = controller;
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
     * 
     * @return a CareTaker object
     */
    public CareTaker getcTaker() {
        return cTaker;
    }

    /**
     * 
     * @param cTaker
     * Overrides the careTaker attribute access mechanism.
     */
    public void setcTaker(CareTaker cTaker) {
        this.cTaker = cTaker;
    }

    /**
     * 
     * @return a FXMLDocumentController object.
     */
    public FXMLDocumentController getController() {
        return controller;
    }

    /**
     * 
     * @param controller
     * Overrides the controller attribute access mechanism.
     */
    public void setController(FXMLDocumentController controller) {
        this.controller = controller;
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
     * Creates a shape that has the same parameters as the node passed as a parameter to the function 
     * and inserts it into the anchorpane at the position indicated by the x and y coordinates passed as a parameter
     * Furthermore, the newly inserted node is again made "draggable" in order to be able to move it
     */
    @Override
    public void exeCommand(Node node, double x, double y) {
        ((ShapeInterface) node).draw(x, y);
        anchorPane.getChildren().add(node);
        DragMod d = new DragMod((Node) node, anchorPane, this.getcTaker(), this.getController());
        d.makeDraggable();
    }

}
