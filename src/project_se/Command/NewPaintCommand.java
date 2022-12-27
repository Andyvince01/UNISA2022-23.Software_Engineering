/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_se.Command;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author andyv
 */
public class NewPaintCommand implements CommandInterface{
    
    private AnchorPane anchorPane;

    /**
     * 
     * @param anchorPane
     * It inits the NewPaintCommand class.
     */
    public NewPaintCommand(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    
    /** 
     * @return AnchorPane
     * Returns the value of the anchor pane with its parameters
     */
    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    
    /** 
     * @param anchorPane
     * Sets the value of the anchor pane with its parameters
     */
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }   
    
    
    /** 
     * @param node
     * Clears the anchor pane returning the blank sheet
     */
    @Override
    public void exeCommand(Node node) {
        this.anchorPane.getChildren().clear();
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
