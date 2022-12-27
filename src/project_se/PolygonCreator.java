package project_se;

import javafx.scene.paint.Color;

public class PolygonCreator extends AbstractShape {

    
    /** 
     * @param stroke
     * @param fill
     * @param angle
     * @param text
     * @param count
     * @return ShapeInterface
     * Create a new shape of type polygon by setting all the properties passed ​​as a parameter
     */
    @Override
    public ShapeInterface createShape(Color stroke, Color fill, double angle, String text, int count, double width, double height) {
        return new PolygonShape(stroke, fill, angle, count);
    }


    
}
