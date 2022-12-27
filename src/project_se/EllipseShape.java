package project_se;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseShape extends Ellipse implements ShapeInterface {

   

    private Color colorStroke, colorFill;
    private double coordinateX, coordinateY;
    private int strokeWidth;
    private double angle;
    private double height, width;

    /**
     * 
     * @param stroke
     * @param fill
     * @param angle
     * @param count
     * @param width
     * @param height
     * Inits the EllipseShape class.
     */
    public EllipseShape(Color stroke, Color fill, double angle, int count, double width, double height) {
        //this.setSize(width, height); //default value
        this.colorStroke = stroke;
        this.colorFill = fill;
        this.angle = angle;
        this.strokeWidth = count;
    }

    
    /** 
     * @param X
     * @param Y
     * It assigns to the selected shape (in this case the ellipse) the properties obtained thanks to the "set" methods 
     * and the coordinates passed as a parameter
     */
    @Override
    public void draw(double X, double Y) {
        this.setStrokeWidth(this.getCount()); //default value
        this.setStroke(this.getColorStroke());
        this.setFill(this.getColorFill());
        this.setRotate(this.getAngle());
        this.setCenterX(X);
        this.setCenterY(Y);
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
     * Returns the coordinate along the abscissa axis
     */
    @Override
    public double getX() {
        return coordinateX;
    }

    
    /** 
     * @return double
     * Returns the coordinate along the ordinate axis
     */
    @Override
    public double getY() {
        return coordinateY;
    }

    
    /** 
     * @param X
     * Sets the coordinate along the abscissa axis
     */
    @Override
    public void setX(double X) {
        this.coordinateX = X;
        
    }

    
    /** 
     * @param Y
     * Sets the coordinate along the ordinate axis
     */
    @Override
    public void setY(double Y) {
        this.coordinateY = Y;
    }
    
    /** 
     * @return double
     * Returns the heigth of the shape
     */
    @Override
    public double getHeigthShape() {
        return this.height;
    }

    
    /** 
     * @return double
     * Returns the width of the shape
     */
    @Override
    public double getWidthShape() {
        return this.width;
    }

    
    /** 
     * @param height
     * Sets the heigth of the shape
     */
    public void setHeight(double height){
        this.height = height;
    }
    
    /** 
     * @param width
     * Sets the width of the shape
     */
    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWidth(){
        return this.width;
    }
    
    /** 
     * @param shape
     * @return ShapeInterface
     * Returns a copy of the shape passed as a parameter
     */
    @Override
    public ShapeInterface getAcopy(ShapeInterface shape) {
        EllipseShape newCopy = new EllipseShape(shape.getColorStroke(), shape.getColorFill(), shape.getAngle(), shape.getCount(), shape.getWidthShape(), shape.getHeigthShape());
        newCopy.draw(shape.getX(), shape.getY());
        newCopy.setSize(shape.getWidthShape(), shape.getHeigthShape());
        newCopy.setCenterX(((EllipseShape)shape).getCenterX());
        newCopy.setCenterY(((EllipseShape)shape).getCenterY());
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
     * @param width
     * @param height
     * Set the size of the shape
     */
    @Override
    public void setSize(double width, double height) {
        this.setRadiusY(height);
        this.setRadiusX(width);
        this.setHeight(height);
        this.setWidth(width);
    }

    
    /** 
     * @param angle
     * Sets the rotation angle of the shape
     */
    @Override
    public void setAngle(double angle) {
        this.angle = angle;
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
        return "Ellipse" + ";" + this.getColorStroke() + ";" + this.getColorFill() + ";" + this.getAngle() + ";" + this.getString() + 
                ";" + this.getCount() + ";" + this.getWidth() + ";" + this.getHeight() + ";" + this.getCenterX() + ";" + this.getCenterY() + "\n";
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
        EllipseShape other = (EllipseShape) obj;
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
