package project_se;

import javafx.scene.paint.Color;

public abstract class AbstractShape {

    private ShapeInterface shape;

    public abstract ShapeInterface createShape(Color stroke, Color fill, double angle, String text, int count, double width, double height); 
    
    /** 
     * @param stroke
     * @param fill
     * @param angle
     * @param text
     * @param count
     * Create a generic Shape by setting all the properties passed as a parameter
     */
    public void creationOfShape(Color stroke, Color fill, double angle, String text, int count, double width, double height){
        shape = this.createShape(stroke, fill, angle, text, count, width, height);
        shape.setColorStroke(stroke);
        shape.setColorFill(fill);
        shape.setAngle(angle);
        shape.setString(text);
        shape.setCount(count);
        shape.setSize(width, height);
    }

    
    /** 
     * @return ShapeInterface
     * Return an object of type shape
     */
    public ShapeInterface getShape(){
        return this.shape;        
    }



    
}
