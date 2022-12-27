package project_se.test.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import project_se.LineShape;

public class LineShapeTest {
    
    private LineShape line;
    private LineShape copyLine;

     @Before
     public void setup() {

        line = new LineShape(Color.BLUE, Color.BLACK, 3.0, 10);
        Double[] points = {53.0, 54.0, 55.0, 56.0};
        line.draw(points);

    }

    @Test
    public void testDraw() {

        Double[] pointsTest = {23.0, 24.0, 25.0, 26.0};

        LineShape testLine;
        testLine = (LineShape) line.getAcopy(line);
        line.draw(pointsTest);
        testLine.draw(pointsTest);
        assertEquals(testLine, line);
    }

    @Test
    public void testGetAcopy() {
        copyLine = (LineShape) line.getAcopy(line);
        assertEquals(line, copyLine);
    }


    @Test
    public void testSetColorStroke() {
        Color background = Color.RED;
        line.setColorStroke(Color.RED);
        assertEquals(background, line.getColorStroke());

    }

    @Test
    public void testSetAngle() {
        double angle = 60.0;
        line.setAngle(60.0);
        assertEquals(angle, line.getAngle(), 0);

    }

    @Test
    public void testSetColorFill() {
        Color fill = Color.BLUE;
        line.setColorFill(Color.BLUE);
        assertEquals(fill, line.getColorFill());
    }


    @Test
    public void testSetPoints() {
        Double[] points = {63.0, 64.0};
        line.setPoints(points);
        assertArrayEquals(points, line.getPoints());
    }

    @Test
    public void testSetSize() {
        double sizeX = 400;
        double sizeY = 500;
        line.setSize(sizeX, sizeY);
        assertEquals(sizeX, line.getEndX(), 0);
        assertEquals(sizeY, line.getEndY(), 0);

    }
}
