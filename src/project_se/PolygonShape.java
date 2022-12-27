package project_se;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PolygonShape extends Polygon implements ShapeInterface {

    private Color colorStroke, colorFill;
    private double coordinateX, coordinateY;
    private Double[] points = new Double[0];
    private double angle;
    private int strokeWidth;

    /**
     * 
     * @param stroke
     * @param fill
     * @param angle
     * @param count
     * Inits the PolygonShape class.
     */
    public PolygonShape(Color stroke, Color fill, double angle, int count) {  
        this.colorStroke = stroke;
        this.colorFill = fill;
        this.angle = angle;
        this.strokeWidth = count;
    }
    
    /** 
     * @param points
     * It assigns to the selected shape (in this case a generic polygon) the properties obtained thanks to the "set" methods 
     * and the array of points passed as a parameter
     */
    @Override
    public void draw(Double[] points) {
        this.getPoints().clear();
        this.getPoints().addAll(points);
        this.setStroke(this.getColorStroke());
        this.setStrokeWidth(this.getCount());
        this.setFill(this.getColorFill());
        this.setRotate(this.getAngle());
        this.setPoints(points); 
    }

    
    /** 
     * @param X
     * @param Y
     * It assigns to the selected shape (in this case a generic polygon) the properties obtained thanks to the "get" methods 
     * and the coordinates passed as a parameter
     */
    @Override
    public void draw(double X, double Y) {

        double firstX = this.points[0];
        double firstY = this.points[1];

        for(int i=0; i<this.points.length; i++){
            if(i%2==0)
                this.points[i] = (X + this.points[i]) - firstX;
            else 
                this.points[i] = (Y + this.points[i]) - firstY;               
        }
        this.getPoints().clear();
        this.getPoints().addAll(points);
        this.setStroke(this.getColorStroke());
        this.setStrokeWidth(this.getStrokeWidth());
        this.setFill(this.getColorFill());
        this.setRotate(this.getAngle());
        this.setPoints(points); 
    }

    
    /** 
     * @param points
     * Sets the array of points
     */
    public void setPoints(Double[] points){
        this.points = points;
    }

    /**
     * 
     * @return an array of Double, representing the points (x,y) of the polygon
     */
    public Double[] getPointsShape(){
        return this.points;
    }

    /**
     * @return the stroke color of the polygon
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
     * Returns the coordinate along the ordinate axis.
     */
    @Override
    public double getY() {
        return coordinateY;
    }

    
    /** 
     * @param X
     * Overrides the x attribute access mechanism.
     */
    @Override
    public void setX(double X) {
        this.coordinateX = X;
        
    }

    
    /** 
     * @param Y
     * Overrides the y attribute access mechanism.
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
        return this.getScaleY();
    }

    
    /** 
     * @return double
     * Returns the width of the shape
     */
    @Override
    public double getWidthShape() {
        return this.getScaleX();
    }

    
    /** 
     * @param shape
     * @return ShapeInterface
     * Returns a copy of the shape passed as a parameter
     */
    @Override
    public ShapeInterface getAcopy(ShapeInterface shape) {
        PolygonShape newCopy = new PolygonShape(shape.getColorStroke(), shape.getColorFill(), shape.getAngle(), shape.getCount());
        newCopy.draw(((PolygonShape) shape).getPointsShape());
        newCopy.getPoints().clear();
        newCopy.getPoints().addAll(((PolygonShape) shape).getPoints());
        newCopy.setSize(shape.getWidthShape(), shape.getHeigthShape());
        return (ShapeInterface) newCopy;
    }
    

    
    /** 
     * @param width
     * @param height
     * Set the size of the shape
     */
    @Override
    public void setSize(double width, double height) {
        this.setScaleX(width);
        this.setScaleY(height);
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
        return "Polygon" + ";" + this.getColorStroke() + ";" + this.getColorFill() + ";" + this.getAngle() + ";" + this.getString() 
                + ";" + this.getCount() + ";" + this.getScaleX() + ";" + this.getScaleY() + ";" + this.getPoints() + "\n";
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
        PolygonShape other = (PolygonShape) obj;
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
        if (this.getScaleX() != other.getScaleX())
            return false;
        if (this.getScaleY() != other.getScaleY())
            return false;
        if (!this.getPoints().equals(other.getPoints()))
            return false;
        return true;
    }


    
}
