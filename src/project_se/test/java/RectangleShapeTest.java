package project_se.test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import project_se.RectangleShape;

public class RectangleShapeTest {
    
    private RectangleShape rectangle;
    private RectangleShape copyRec;

     @Before
     public void setup() {

        rectangle = new RectangleShape(Color.BLUE, Color.BLACK, 0.0, 10, 200, 300);

    }

    @Test
    public void testDraw() {
        RectangleShape testRectangle;
        testRectangle = (RectangleShape) rectangle.getAcopy(rectangle);
        rectangle.draw(532.0, 150.0);
        testRectangle.draw(532.0, 150.0);
        assertEquals(testRectangle, rectangle);
    }

    @Test
    public void testGetAcopy() {
        copyRec = (RectangleShape) rectangle.getAcopy(rectangle);
        assertEquals(rectangle, copyRec);
    }


    @Test
    public void testSetColorStroke() {
        Color background = Color.RED;
        rectangle.setColorStroke(Color.RED);
        assertEquals(background, rectangle.getColorStroke());

    }

    @Test
    public void testSetAngle() {
        double angle = 190.0;
        rectangle.setAngle(190.0);
        assertEquals(angle, rectangle.getAngle(), 0);

    }

    @Test
    public void testSetColorFill() {
        Color fill = Color.BLUE;
        rectangle.setColorFill(Color.BLUE);
        assertEquals(fill, rectangle.getColorFill());
    }


    @Test
    public void testSetSize() {
        double sizeX = 400;
        double sizeY = 500;
        rectangle.setSize(sizeX, sizeY);
        assertEquals(sizeX, rectangle.getWidth(), 0);
        assertEquals(sizeY, rectangle.getHeight(), 0);

    }
}
