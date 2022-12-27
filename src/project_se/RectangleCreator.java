package project_se;

import javafx.scene.paint.Color;

public class RectangleCreator extends AbstractShape {

    
    /** 
     * @param stroke
     * @param fill
     * @param angle
     * @param text
     * @param count
     * @return ShapeInterface
     * Create a new shape of type rectangle by setting all the properties passed ​​as a parameter
     */
    @Override
    public ShapeInterface createShape(Color stroke, Color fill, double angle, String text, int count, double width, double height) {
        // TODO Auto-generated method stub
        return new RectangleShape(stroke, fill, angle, count, width, height);
    }



    
}
