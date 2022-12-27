package project_se.test.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import project_se.PolygonShape;

public class PolygonShapeTest {
   
    private PolygonShape polygon;
    private PolygonShape copyPoly;

     @Before
     public void setup() {

        polygon = new PolygonShape(Color.BLUE, Color.BLACK, 0.0, 10);
        Double[] pointsTest = {695.0, 251.0, 866.0, 384.0, 927.0, 256.0};
        polygon.getPoints().addAll(pointsTest);

    }

    @Test
    public void testDraw() {

        Double[] pointsTest = {895.0, 451.0, 1066.0, 584.0, 1127.0, 456.0};

        PolygonShape testPolygon;
        testPolygon = (PolygonShape) polygon.getAcopy(polygon);
        polygon.draw(pointsTest);
        testPolygon.draw(pointsTest);
        assertEquals(testPolygon, polygon);
    }

    @Test
    public void testGetAcopy() {
        copyPoly = (PolygonShape) polygon.getAcopy(polygon);
        assertEquals(polygon, copyPoly);
    }


    @Test
    public void testSetColorStroke() {
        Color background = Color.RED;
        polygon.setColorStroke(Color.RED);
        assertEquals(background, polygon.getColorStroke());

    }

    @Test
    public void testSetAngle() {
        double angle = 90.0;
        polygon.setAngle(90.0);
        assertEquals(angle, polygon.getAngle(), 0);

    }

    @Test
    public void testSetColorFill() {
        Color fill = Color.BLUE;
        polygon.setColorFill(Color.BLUE);
        assertEquals(fill, polygon.getColorFill());
    }


    @Test
    public void testSetPoints() {
        Double[] points = {595.0, 151.0, 766.0, 284.0, 827.0, 156.0};
        polygon.setPoints(points);
        assertArrayEquals(points, polygon.getPointsShape());
    }

    @Test
    public void testSetSize() {
        double sizeX = 400;
        double sizeY = 500;
        polygon.setScaleX(sizeX);
        polygon.setScaleY(sizeY);
        assertEquals(sizeX, polygon.getScaleX(), 0);
        assertEquals(sizeY, polygon.getScaleY(), 0);

    }

}
