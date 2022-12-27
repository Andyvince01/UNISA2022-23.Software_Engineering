package project_se.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import project_se.EllipseShape;

public class EllipseShapeTest {
    
    private EllipseShape ellipse;
    private EllipseShape copyEll;

     @Before
     public void setup() {

        ellipse = new EllipseShape(Color.BLUE, Color.BLACK, 0.0, 10, 200, 300);

    }

    @Test
    public void testDraw() {
        EllipseShape testEll;
        testEll = (EllipseShape) ellipse.getAcopy(ellipse);
        ellipse.draw(532.0, 150.0);
        testEll.draw(532.0, 150.0);
        assertEquals(testEll, ellipse);
    }

    @Test
    public void testGetAcopy() {
        copyEll = (EllipseShape) ellipse.getAcopy(ellipse);
        assertEquals(ellipse, copyEll);
    }


    @Test
    public void testSetColorStroke() {
        Color background = Color.RED;
        ellipse.setColorStroke(Color.RED);
        assertEquals(background, ellipse.getColorStroke());

    }

    @Test
    public void testSetAngle() {
        double angle = 190.0;
        ellipse.setAngle(190.0);
        assertEquals(angle, ellipse.getAngle(), 0);

    }

    @Test
    public void testSetColorFill() {
        Color fill = Color.BLUE;
        ellipse.setColorFill(Color.BLUE);
        assertEquals(fill, ellipse.getColorFill());
    }


    @Test
    public void testSetSize() {
        double width = 400;
        double height = 500;
        ellipse.setSize(width, height);
        assertEquals(width, ellipse.getRadiusX(), 0);
        assertEquals(height, ellipse.getRadiusY(), 0);
        assertEquals(width, ellipse.getWidth(), 0);
        assertEquals(height, ellipse.getHeight(), 0);

    }

}
