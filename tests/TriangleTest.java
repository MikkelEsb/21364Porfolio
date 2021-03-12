import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    Triangle triangleA = new Triangle(new Point2D(0,0),new Point2D(1,0),new Point2D(1,1));
    @Test
    void centroidLocation(){
        assertEquals(triangleA.getCenter().getX(),2/3d);
        assertEquals(triangleA.getCenter().getY(),1/3d);
    }
    @Test
    void triangleArea(){
        assertEquals(0.5d,triangleA.getArea());
    }

    @Test
    void pointInTriangle(){
        assertTrue(triangleA.containsPoint(triangleA.getCenter()));
        assertTrue(triangleA.containsPoint(new Point2D(0,0)));
        assertFalse(triangleA.containsPoint(new Point2D(-0.00001,0)));
    }

    @Test
    void trianglePerimeter(){
        assertEquals(3.4142135623730950488016887242097d,triangleA.getPerimeter());
    }

    @Test
    void shapeType(){
        assertEquals(ShapeType.TRIANGLE,triangleA.getType());
    }
}
