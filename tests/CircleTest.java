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
        assertTrue(circleA.isPointInCircle(pointInside));

        //Point on perimeter
        Point2D pointOnEdge = new Point2D(1,3);
        assertTrue(circleA.isPointInCircle(pointOnEdge));

        //Point outside
        Point2D pointOutside = new Point2D(1,3.001);
        assertFalse(circleA.isPointInCircle(pointOutside));

    }
    @Test
    void distanceToCircle(){
        //Overlapping circle
        Circle circleB = new Circle(2,2,1);
        assertEquals(circleA.getCenterDistance(circleB),1.4142135623730950488016887242097d);
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
        assertEquals(12.566370614359172953850573533118d,circleA.getCircumference());
    }
    @Test
    void shapeType(){
        assertEquals(circleA.getType(),ShapeType.CIRCLE);
    }


}
