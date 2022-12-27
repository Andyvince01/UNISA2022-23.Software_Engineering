package project_se.test.java;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import javafx.scene.paint.Color;
import project_se.TextShape;


public class TextShapeTest {
    
    private TextShape text;
    private TextShape copyText;

     @Before
     public void setup() {

        text = new TextShape(Color.BLUE, Color.BLACK, 0.00, "Prova", 5);

    }

    @Test
    public void testDraw() {
        TextShape testText;
        testText = (TextShape) text.getAcopy(text);
        text.draw(455.0, 131.0);
        testText.draw(455.0, 131.0);
        assertEquals(testText, text);
    }

    @Test
    public void testGetAcopy() {
        copyText = (TextShape) text.getAcopy(text);
        assertEquals(text, copyText);
    }


    @Test
    public void testSetColorStroke() {
        Color background = Color.RED;
        text.setColorStroke(Color.RED);
        assertEquals(background, text.getColorStroke());

    }

    @Test
    public void testSetAngle() {
        double angle = 30.0;
        text.setAngle(30.0);
        assertEquals(angle, text.getAngle(), 0);

    }

    @Test
    public void testSetColorFill() {
        Color fill = Color.BLUE;
        text.setColorFill(Color.BLUE);
        assertEquals(fill, text.getColorFill());
    }


    @Test
    public void testSetSize() {
        double width = 200;
        double height = 350;
        text.setScaleX(width);
        text.setScaleY(height);
        assertEquals(width, text.getWidthShape(), 0);
        assertEquals(height, text.getHeigthShape(), 0);

    }
}
