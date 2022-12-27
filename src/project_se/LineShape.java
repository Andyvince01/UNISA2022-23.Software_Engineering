package project_se;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape extends Line implements ShapeInterface {

    private Color colorStroke, colorFill;
    private double startX, startY, endX, endY;
    private Double[] points;
    private int strokeWidth;
    private double angle;

    public LineShape(Color stroke, Color fill, double angle, int count) {
        this.colorStroke = stroke;
        this.colorFill = fill;
        this.angle = angle;
        this.strokeWidth = count;
    }

    
    /** 
     * @param X
     * @param Y
     * It assigns to the selected shape (in this case the line) the properties obtained thanks to the "set" methods 
     * and the coordinates passed as a parameter
     */
    @Override
    public void draw(double X, double Y) {
        startX = this.points[0];
        startY = this.points[1];
        endX = this.points[2];
        endY = this.points[3];
        this.points[0] = X;
        this.points[1] = Y;
        this.points[2] = X + (endX - startX);
        this.points[3] = Y + (endY - startY);
        this.setPoints(points);
        this.setRotate(this.getAngle());
        this.setStartX(this.points[0]);
        this.setStartY(this.points[1]);
        this.setEndX(this.points[2]);
        this.setEndY(this.points[3]);
        this.setStroke(this.getColorStroke());
        this.setStrokeWidth(this.getCount());
        this.setFill(this.getColorFill());
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
     * Returns the coordinate along the abscissa axis of the start point of the line
     */
    @Override
    public double getX() {
        return this.startX;
    }

    
    /** 
     * @return double
     * Returns the coordinate along the ordinate axis of the start point of the line
     */
    @Override
    public double getY() {
        return this.startY;
    }

    
    /** 
     * @param point
     * Sets the coordinate along the abscissa axis of the start point of the line
     */
    @Override
    public void setX(double point) {
        this.startX = point;
        
    }

    
    /** 
     * @param point
     * Sets the coordinate along the ordinate axis of the start point of the line
     */
    @Override
    public void setY(double point) {
        this.startY = point;
        
    }

    
    /** 
     * @param point
     * Sets the coordinate along the abscissa axis of the end point of the line
     */
    public void endX(double point) {
        this.endX = point;
    }

    
    /** 
     * @param point
     * Sets the coordinate along the ordinate axis of the end point of the line
     */
    public void endY(double point) {
        this.endY = point;
    }

    
    /** 
     * @return double
     * Returns the heigth of the shape
     */
    @Override
    public double getHeigthShape() {
        return this.getEndY();
    }

    
    /** 
     * @return double
     * Returns the width of the shape
     */
    @Override
    public double getWidthShape() {
        return this.getEndX();
    }

    
    /** 
     * @param shape
     * @return ShapeInterface
     * Returns a copy of the shape passed as a parameter
     */
    @Override
    public ShapeInterface getAcopy(ShapeInterface shape) {
        LineShape newCopy = new LineShape(shape.getColorStroke(), shape.getColorFill(), shape.getAngle(), shape.getCount());
        newCopy.draw(((LineShape) shape).getPoints());
        newCopy.setStartX(((LineShape) shape).getStartX());
        newCopy.setStartY(((LineShape) shape).getStartY());
        newCopy.setSize(shape.getWidthShape(), shape.getHeigthShape());
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
     * @param X
     * @param Y
     * Set the size of the shape
     */
    @Override
    public void setSize(double X, double Y) {
        this.setEndX(X);
        this.setEndY(Y);
    }

    
    /** 
     * @param points
     * It assigns to the selected shape (in this case the line) the properties obtained thanks to the "set" methods 
     * and the coordinates passed as a parameter
     */
    @Override
    public void draw(Double[] points) {
        this.setStroke(this.getColorStroke());
        this.setFill(this.getColorFill());
        this.setStartX(points[0]);
        this.setStartY(points[1]);
        this.setEndX(points[2]);
        this.setEndY(points[3]);
        this.setRotate(this.getAngle());
        this.setStrokeWidth(this.getCount());
        this.setPoints(points);
    }

    
    /** 
     * @param points
     * Sets the coordinate of the line and inserts them in an array of double
     */
    public void setPoints(Double[] points){
        this.points = points;
    }

    
    /** 
     * @return Double[]
     * Returns the coordinate of the line
     */
    public Double[] getPoints(){
        return this.points;
    }

    
    /** 
     * @param angle
     * Sets the rotation angle of the shape
     */
    @Override
    public void setAngle(double angle) {
        this.angle=angle;
        
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
        return "Line" + ";" + this.getColorStroke() + ";" + this.getColorFill() + ";" + this.getAngle() + ";" + this.getString() + 
                ";" + this.getCount() + ";" + this.getEndX() + ";" + this.getEndY() + ";" + this.getStartX() + ";" + this.getStartY() + "\n";
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
        LineShape other = (LineShape) obj;
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
        if (this.getEndX() != other.getEndX())
            return false;
        if (this.getEndY() != other.getEndY())
            return false;
        if (this.getStartX() != other.getStartX())
            return false;
        if (this.getStartY() != other.getStartY())
            return false;
        return true;
    }
    
}