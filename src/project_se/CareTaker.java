package project_se;

import java.util.Stack;

import javafx.scene.control.Button;
import project_se.FXMLDocumentController.Memento;

public class CareTaker {
    
    private Stack<Memento> history;
    
    /**
     * It inits the Caretaker class.
     */
    public CareTaker(){
        history = new Stack<>();
    }    
    
    /** 
     * @param main
     * Saves the state of the drawing area in the variable history of type stack
     */
    public void save(FXMLDocumentController main){
        history.push(main.save());
    }

    
    /** 
     * @param main
     * Returns the first item placed on the stack
     */
    public void revert(FXMLDocumentController main, Button undoButton){
        if(!history.isEmpty()){
            main.revert(history.pop());
            undoButton.setDisable(false);
        }
        else
            undoButton.setDisable(true);
        
    }

}