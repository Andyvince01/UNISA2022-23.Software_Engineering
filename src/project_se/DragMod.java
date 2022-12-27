/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_se;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class DragMod{

    private double mousex = 0;
    private double mousey = 0;
    private Node node;
    private AnchorPane anchorPane;
    private CareTaker cTaker;
    private FXMLDocumentController controller;
    private double x, y = 0.0;
    boolean flag = true;
        
    /**
     * 
     * @param node
     * @param anchorPane
     * @param cTaker
     * @param controller
     * Inits the DragMod class.
     */
    public DragMod(Node node, AnchorPane anchorPane, CareTaker cTaker, FXMLDocumentController controller) {
        this.node = node;
        this.anchorPane = anchorPane;
        this.anchorPane.setMinHeight(this.anchorPane.getHeight());
        this.anchorPane.setMinWidth(this.anchorPane.getWidth());
        this.cTaker = cTaker;
        this.controller = controller;
    }

    
    /** 
     * @return Node
     * Returns the object of type node
     */
    public Node getNode() {
        return node;
    }

    
    /** 
     * @param node
     * Sets the value of the object of type node
     */
    public void setNode(Node node) {
        this.node = node;
    }

    
    /** 
     * @param anchorPane
     * Selects the AnchorPane passed as a parameter
     */
    public void setAnchorPane(AnchorPane anchorPane){
        this.anchorPane = anchorPane;
    } 

    /**
     * 
     * @return an AnchorPane object.
     */
    public AnchorPane getAnchorPane() {
        return anchorPane;
    }


    /**
     * 
     * @return a careTaker object.
     */
    public CareTaker getCtaker() {
        return cTaker;
    }

    /**
     * 
     * @param cTaker
     * Overrides the cTaker attribute access mechanism.
     */

    public void setCtaker(CareTaker cTaker) {
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
     * @param X
     * @param Y
     * @return boolean
     * Check that the shape doesn't move out of the AnchorPane, specifically that it doesn't hang out of the top or left margin
     */
    public boolean isInDragZone(double X, double Y){
        return X > 0 && Y > 150;        
    }
    
    
    /** 
     * @param X
     * @param Y
     * @return boolean
     * Check that the shape doesn't move out of the AnchorPane, specifically that it doesn't hang out of the bottom or right margin
     */
    public boolean isNotOverDragZone(double X, double Y){
        return X < (this.getAnchorPane().getWidth() + 30) && Y < (this.getAnchorPane().getHeight() + 175);
    }
    

    /** 
     * Makes a figure moveable, then changes its co-ordinates.
     */
    public void makeDraggable(){
               
        this.getNode().setOnMousePressed(eh ->{
            mousex = eh.getSceneX() - this.getNode().getTranslateX();
            mousey = eh.getSceneY() - this.getNode().getTranslateY();
            x = 0.0;
            y = 0.0;
            this.getNode().setTranslateX(x);
            this.getNode().setTranslateY(y);
        });
        
        this.getNode().setOnMouseDragged(eh -> {
            if(flag){
                this.getCtaker().save(this.getController());
                flag = false;
            }
            if(isInDragZone(eh.getSceneX(), eh.getSceneY()) && isNotOverDragZone(eh.getSceneX(), eh.getSceneY())){
                x = eh.getSceneX() - mousex;
                y = eh.getSceneY() - mousey;
                this.getNode().setTranslateX(x);
                this.getNode().setTranslateY(y);
            }else{
                x = 0.0;
                y = 0.0;
                this.getNode().setTranslateX(x);
                this.getNode().setTranslateY(y);
            }                          
        });    

        this.getNode().setOnMouseReleased(eh -> {
            if(eh.getButton() != MouseButton.SECONDARY){
                ShapeInterface s = ((ShapeInterface)this.getNode());
                if(s.getClass().getName() == "project_se.RectangleShape"){
                    this.getNode().setTranslateX(0);
                    this.getNode().setTranslateY(0);
                    ((RectangleShape)this.getNode()).setX(((RectangleShape)this.getNode()).getX() + x);
                    ((RectangleShape)this.getNode()).setY(((RectangleShape)this.getNode()).getY() + y);
                }
                else if(s.getClass().getName() == "project_se.EllipseShape"){
                    this.getNode().setTranslateX(0);
                    this.getNode().setTranslateY(0);
                    double centerx = ((EllipseShape)this.getNode()).getCenterX();
                    double centery = ((EllipseShape)this.getNode()).getCenterY();
                    ((EllipseShape)this.getNode()).setCenterX(centerx + x);
                    ((EllipseShape)this.getNode()).setCenterY(centery + y);
                }
                else if(s.getClass().getName() == "project_se.LineShape"){
                    this.getNode().setTranslateX(0);
                    this.getNode().setTranslateY(0);
                    double startx = ((LineShape)this.getNode()).getStartX();
                    double endx = ((LineShape)this.getNode()).getEndX();
                    double starty = ((LineShape)this.getNode()).getStartY();
                    double endy = ((LineShape)this.getNode()).getEndY();
                    ((LineShape)this.getNode()).setStartX(startx + x);
                    ((LineShape)this.getNode()).setEndX(endx + x);
                    ((LineShape)this.getNode()).setStartY(starty + y);
                    ((LineShape)this.getNode()).setEndY(endy + y);
                }
                else if(s.getClass().getName() == "project_se.PolygonShape"){
                    this.getNode().setTranslateX(0);
                    this.getNode().setTranslateY(0);
                    Double[] points = ((PolygonShape) s).getPointsShape();
                    for(int i = 0; i < points.length; i++){
                        if(i%2 == 0)
                            points[i] += x;
                        else
                            points[i] += y;    
                    }
                    ((PolygonShape) s).getPoints().clear();
                    ((PolygonShape) s).setPoints(points);
                    ((PolygonShape) s).draw(points);
                }
                else if(s.getClass().getName() == "project_se.TextShape"){
                    this.getNode().setTranslateX(0);
                    this.getNode().setTranslateY(0);
                    ((TextShape)this.getNode()).setX(((TextShape)this.getNode()).getX() + x);
                    ((TextShape)this.getNode()).setY(((TextShape)this.getNode()).getY() + y);
                }
            }   
        flag = true;
        }); 

        
    }

}