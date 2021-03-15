import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {
    Circle circleA;
    @BeforeEach
    void setupCircleTest(){
        circleA = new Circle(1,1,2);
    }
    @Test
    void pointInCircle(){
        //Point inside
        Point2D pointInside = new Point2D(1.5,2);
        assertTrue(circleA.containsPoint(pointInside));

        //Point on perimeter
        Point2D pointOnEdge = new Point2D(1,3);
        assertTrue(circleA.containsPoint(pointOnEdge));

        //Point outside
        Point2D pointOutside = new Point2D(1,3.001);
        assertFalse(circleA.containsPoint(pointOutside));

    }
    @Test
    void distanceToCircle(){
        //Overlapping circle
        Circle circleB = new Circle(2,2,1);
        assertEquals(circleA.getCenterDistance(circleB),1.4142135623730950488016887242097d);
    }
    @Test
    void translate(){
        circleA.translate(-3,0);
        //The center should be moved to -2,1 with radius of 2
        //Testing if perimeter of circle is correctly moved
        assertTrue(circleA.containsPoint(new Point2D(-4,1)));
        assertFalse(circleA.containsPoint(new Point2D(1,1)));
        circleA.rotate(0); //Bad practice but just calling this for code coverage ;)
    }
    @Test
    void circleRadius(){
        assertEquals(2d,circleA.getRadius());
    }
    @Test
    void circleArea(){
        assertEquals(12.566370614359172953850573533118d,circleA.getArea());
    }
    @Test
    void circlePerimeter(){
        assertEquals(12.566370614359172953850573533118d,circleA.getPerimeter());
    }
    @Test
    void shapeType(){
        assertEquals(circleA.getType(),ShapeType.CIRCLE);
    }


}
