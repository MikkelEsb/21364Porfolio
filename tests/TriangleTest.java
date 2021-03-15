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
    void rotatePoint(){
        Point2D cent= new Point2D(0,0);
        Point2D testA = new Point2D(1,0);
        //Rotate 90 degrees left along unitcircle around center, our x should be 0 and y should be 1
        Point2D tempPoint=testA.getRotatedPoint(Math.PI/2,cent);
        assertEquals(0d,tempPoint.getX(),Math.pow(10,-16));
        assertEquals(1d,tempPoint.getY(),Math.pow(10,-16));
        //Allowing 10^-16 error rate

    }
    @Test
    void rotate(){
        triangleA.rotate(Math.PI/2);
        //Ensure that we maintain area and perimeter through rotations:
        assertEquals(0.5d,triangleA.getArea());
        assertEquals(3.4142135623730950488016887242097d,triangleA.getPerimeter());

    }
    @Test
    void translate(){
        triangleA.translate(1,-1);
        System.out.println(triangleA.toString());
        assertTrue(triangleA.containsPoint(new Point2D(1.5,-0.5)));

    }

    @Test
    void shapeType(){
        assertEquals(ShapeType.TRIANGLE,triangleA.getType());
    }
}
