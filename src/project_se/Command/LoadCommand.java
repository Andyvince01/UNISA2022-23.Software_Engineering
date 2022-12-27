package project_se.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import project_se.AbstractShape;
import project_se.CareTaker;
import project_se.DragMod;
import project_se.EllipseCreator;
import project_se.FXMLDocumentController;
import project_se.LineCreator;
import project_se.LineShape;
import project_se.PolygonCreator;
import project_se.RectangleCreator;
import project_se.TextCreator;


public class LoadCommand implements CommandInterface{

    private AnchorPane anchorPane;
    private CareTaker cTaker;
    private FXMLDocumentController controller;
    private AbstractShape currentSelection;

    /**
     * 
     * @param anchorPane
     * @param cTaker
     * @param controller
     * It inits the LoadCommand class.
     */
    public LoadCommand(AnchorPane anchorPane, CareTaker cTaker, FXMLDocumentController controller){
        this.anchorPane = anchorPane;
        this.cTaker = cTaker;
        this.controller = controller;
    }

    
    /** 
     * @return CareTaker
     * Returns the stack of memento
     */
    public CareTaker getcTaker() {
        return cTaker;
    }

    
    /** 
     * @param cTaker
     * Sets the stack of memento
     */
    public void setcTaker(CareTaker cTaker) {
        this.cTaker = cTaker;
    }

    
    /** 
     * @return FXMLDocumentController
     * Returns the last state of the drawing sheet
     */
    public FXMLDocumentController getController() {
        return controller;
    }

    
    /** 
     * @param controller
     * Sets the last state of the drawing sheet
     */
    public void setController(FXMLDocumentController controller) {
        this.controller = controller;
    }

    
    /** 
     * @param node
     * Inserts all shapes loaded from the text file into the drawing sheet
     */
    @Override
    public void exeCommand(Node node) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        try(Scanner in = new Scanner(new BufferedReader(new FileReader(file)))){
            in.useLocale(Locale.US);
            in.useDelimiter(";|\\n");
            while(in.hasNext()){
                String classShape = in.next();
                if(classShape.equals("Rectangle"))
                    currentSelection = new RectangleCreator();
                else if(classShape.equals("Ellipse"))
                    currentSelection = new EllipseCreator();
                else if(classShape.equals("Line"))
                    currentSelection = new LineCreator();
                else if(classShape.equals("Polygon"))
                    currentSelection = new PolygonCreator();
                else if(classShape.equals("Text"))
                    currentSelection = new TextCreator();
                currentSelection.creationOfShape(Color.web(in.next()), Color.web(in.next()), Double.parseDouble(in.next()), in.next(), Integer.parseInt(in.next()), Double.parseDouble(in.next()), Double.parseDouble(in.next()));
                if(classShape.equals("Rectangle") || classShape.equals("Ellipse") || classShape.equals("Text"))
                    currentSelection.getShape().draw(Double.parseDouble(in.next()), Double.parseDouble(in.next()));
                else if(classShape.equals("Line") || classShape.equals("Polygon")){
                    Double[] points = new Double[100];
                    if(classShape.equals("Polygon")){
                        String[] split = in.next().split(",");
                        points = new Double[split.length];
                        for(int i=0; i<split.length; i++) {
                            if(i == (split.length-1) )
                                points[i] = Double.parseDouble(split[i].substring(1, split[i].length()-1));
                            else 
                                points[i] = Double.parseDouble(split[i].substring(1));
                        }
                    }
                    else if(classShape.equals("Line")){
                        Double x = Double.parseDouble(in.next());
                        Double y = Double.parseDouble(in.next());
                        points = new Double[4];
                        points[0] = x;
                        points[1] = y;
                        points[2] = ((LineShape)currentSelection.getShape()).getEndX();
                        points[3] = ((LineShape)currentSelection.getShape()).getEndY();
                    }
                    currentSelection.getShape().draw(points);
                }
                Node n = (Node) currentSelection.getShape();
                anchorPane.getChildren().add(n);
                DragMod d = new DragMod(n, anchorPane, this.getcTaker(), this.getController());
                d.makeDraggable();                
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
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
