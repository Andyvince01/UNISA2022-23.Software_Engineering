package project_se;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends Rectangle implements ShapeInterface {

    private Color colorStroke, colorFill;
    private double angle;
    private int strokeWidth;

    /**
     * 
     * @param stroke
     * @param fill
     * @param angle
     * @param count
     * @param width
     * @param height
     * It inits the RectangleShape class.
     */
    public RectangleShape(Color stroke, Color fill, double angle, int count, double width, double height) {
        super(width, height); 
        this.colorStroke = stroke;
        this.colorFill = fill;
        this.angle = angle;
        this.strokeWidth = count;
    }

    
    /** 
     * @param X
     * @param Y
     * It assigns to the selected shape (in this case the rectangle) the properties obtained thanks to the "set" methods 
     * and the coordinates passed as a parameter
     */
    @Override
    public void draw(double X, double Y) {
        this.setStroke(this.getColorStroke());
        this.setFill(this.getColorFill());
        this.setStrokeWidth(this.getCount());
        this.setRotate(this.getAngle());
        this.setX(X);
        this.setY(Y);
    }

    
    /** 
     * @return Color
     * Returns the border color of the shape
     */
    @Override
    public Color getColorStroke() {
        return this.colorStroke;
    }

    
    /** 
     * @return Color
     * Returns the fill color of the shape
     */
    @Override
    public Color getColorFill() {
        return this.colorFill;
    }

    
    /** 
     * @param stroke
     * Sets the border color of the shape
     */
    @Override
    public void setColorStroke(Color stroke) {
        this.colorStroke = stroke;
        
    }

    
    /** 
     * @param fill
     * Sets the fill color of the shape
     */
    @Override
    public void setColorFill(Color fill) {
        this.colorFill = fill;
        
    }

    
    /** 
     * @return double
     * Returns the heigth of the shape
     */
    @Override
    public double getHeigthShape() {
        return this.getHeight();
    }

    
    /** 
     * @return double
     * Returns the width of the shape
     */
    @Override
    public double getWidthShape() {
        return this.getWidth();
    }

    
    /** 
     * @param shape
     * @return ShapeInterface
     * Returns a copy of the shape passed as a parameter
     */
    @Override
    public ShapeInterface getAcopy(ShapeInterface shape) {
        RectangleShape newCopy = new RectangleShape(shape.getColorStroke(), shape.getColorFill(), shape.getAngle(), shape.getCount(), shape.getWidthShape(), shape.getHeigthShape());
        newCopy.draw(shape.getX(), shape.getY());
        return (ShapeInterface) newCopy;
    }

    
    /** 
     * @return double
     * Returns the rotation angle of the shape
     */
    @Override
    public double getAngle() {
        return this.angle;
    }

    
    /** 
     * @param points
     */
    @Override
    public void draw(Double[] points) {
        // TODO Auto-generated method stub
        
    }

    
    /** 
     * @param angle
     * Sets the rotation angle of the shape
     */
    @Override
    public void setAngle(double angle) {
        this.angle= angle;  
    }   
    

    
    /** 
     * @param width
     * @param height
     * Set the size of the shape
     */
    @Override
    public void setSize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }


    
    /** 
     * @return String
     */
    @Override
    public String getString() {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * @param text
     */
    @Override
    public void setString(String text) {
        // TODO Auto-generated method stub
        
    }

    
    /** 
     * @return int
     * Returns the thickness of the border
     */
    @Override
    public int getCount() {
        return this.strokeWidth;
    }

    
    /** 
     * @param count
     * Sets the thickness of the border
     */
    @Override
    public void setCount(int count) {
        this.strokeWidth = count;
    }


    /** 
     * @return String
     * Prints the propeties of the shape
     */
    @Override
    public String toString() {
        return "Rectangle" + ";" + Color.web(this.getColorStroke().toString()) + ";" + Color.web(this.getColorFill().toString()) + ";" + this.getAngle() + ";" + this.getString() + 
                ";" + this.getCount() + ";" + this.getWidth() + ";" + this.getHeight() + ";" + this.getX() + ";" + this.getY() + "\n";
    }

    /**
     * It compares the reference object (this) to another object (obj).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RectangleShape other = (RectangleShape) obj;
        if(this.getColorStroke() != other.getColorStroke())
            return false;
        if(this.getColorFill() != other.getColorFill())
            return false;
        if (this.getAngle() != other.getAngle())
            return false;
        if (this.getString() != other.getString())
            return false;
        if (this.getCount() != other.getCount())
            return false;
        if (this.getWidth() != other.getWidth())
            return false;
        if (this.getHeight() != other.getHeight())
            return false;
        if (this.getX() != other.getX())
            return false;
        if (this.getY() != other.getY())
            return false;
        return true;
    }


    

    
    

}
