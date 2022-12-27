package project_se;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class TextShape extends Text implements ShapeInterface {

    private Color colorStroke, colorFill;
    private String string;
    private int font;
    private double angle;
    
    /**
     * 
     * @param stroke
     * @param fill
     * @param angle
     * @param string
     * @param count
     * It inits the TextShape class.
     */
    public TextShape(Color stroke, Color fill, double angle, String string, int count) {
        this.colorStroke = stroke;
        this.colorFill = fill;
        this.angle = angle;
        this.string = string;
        this.font = count;
    }

    
    /** 
     * @param X
     * @param Y
     * It assigns to the selected shape (in this case the text) the properties obtained thanks to the "set" methods 
     * and the coordinates passed as a parameter
     */
    @Override
    public void draw(double X, double Y) {
        this.setWrappingWidth(200);
        this.setFill(this.getColorFill());
        this.setStrokeWidth(0.5);
        this.setStroke(this.getColorStroke());
        this.setFont(new Font(this.getCount()*3));
        this.setText(this.getString());
        this.setTextAlignment(TextAlignment.CENTER);
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
        TextShape newCopy = new TextShape(shape.getColorStroke(), shape.getColorFill(), shape.getAngle(), shape.getString(), shape.getCount());
        newCopy.draw(shape.getX(), shape.getY());
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
        this.angle = angle;  
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
     * @return String
     * Returns the string value to render a shape
     */
    @Override
    public String getString() {
        return this.string;
    }

    
    /** 
     * @param string
     * Set the string value to render a shape
     */
    @Override
    public void setString(String string) {
        this.string = string;
    }

    
    /** 
     * @return int
     * Returns the thickness of the border
     */
    @Override
    public int getCount() {
        return this.font;
    }

    
    /** 
     * @param count
     * Sets the thickness of the border
     */
    @Override
    public void setCount(int count) {
        this.font = count;
    }

    
    /** 
     * @return String
     * Prints the propeties of the shape
     */
    @Override
    public String toString() {
        return "Text" + ";" + this.getColorStroke() + ";" + this.getColorFill() + ";" + this.getAngle() + ";" + this.getString() + 
                ";" + this.getCount() + ";" + this.getScaleX() + ";" + this.getScaleY() + ";" + this.getX() + ";" + this.getY() + "\n";
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
        TextShape other = (TextShape) obj;
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
        if (this.getX() != other.getX())
            return false;
        if (this.getY() != other.getY())
            return false;
        return true;
    }
    
}
