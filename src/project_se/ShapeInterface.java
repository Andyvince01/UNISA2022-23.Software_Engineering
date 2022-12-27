package project_se;

import javafx.scene.paint.Color;

public interface ShapeInterface {

    public void draw(Double[] points);
	public void draw(double X, double Y);

	public Color getColorStroke();
    public Color getColorFill();
    public void setColorStroke(Color stroke);
    public void setColorFill(Color fill);

	public double getX();
    public double getY();
    public void setX(double X);
    public void setY(double Y);

    public String getString();
    public void setString(String text);
    public int getCount();
    public void setCount(int count);

    public double getHeigthShape();
    public double getWidthShape();
    public void setSize(double width, double height);

    public ShapeInterface getAcopy(ShapeInterface shape);
    public double getAngle();
    public void setAngle(double angle);

    public String toString();
}
