import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class RectangleTest {
    Rectangle rectangleA;
    @BeforeEach
    void setup(){
        rectangleA =new Rectangle(new Point2D(0,0),new Point2D(2,2));
    }
    @Test
    void areaSquare(){
        assertEquals(4d, rectangleA.getArea());
    }
    @Test
    void areaPerimeter(){
        assertEquals(8d, rectangleA.getPerimeter());
    }
    @Test
    void containsPoint(){
        //Center
        assertTrue(rectangleA.containsPoint(new Point2D(1,1)));
        //Edge
        assertTrue(rectangleA.containsPoint(new Point2D(2,2)));
        //Outside
        assertFalse(rectangleA.containsPoint(new Point2D(3,3)));
    }
    @Test
    void rotation(){
        //Rotate 90 degrees left around center
        rectangleA.rotate(Math.PI/2);

        //All previous tests should still yield same results
        assertEquals(4d, rectangleA.getArea());

        assertEquals(8d, rectangleA.getPerimeter());
        //Center
        assertTrue(rectangleA.containsPoint(new Point2D(1,1)));
        //Edge
        assertTrue(rectangleA.containsPoint(new Point2D(2,2)));
        //Outside
        assertFalse(rectangleA.containsPoint(new Point2D(3,3)));

        System.out.println(rectangleA.toString());
        //Rotate 45 degree right around center
        rectangleA.rotate(-Math.PI/4);
        System.out.println(rectangleA.toString());
        assertFalse(rectangleA.containsPoint(new Point2D(2,2)));

    }

}
