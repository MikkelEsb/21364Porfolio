import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Point2DTest {
    Point2D pointA;
    Point2D pointB;
    @BeforeEach
    void setupPoints(){
        pointA = new Point2D(1,3);
        pointB = new Point2D(0,-1);
    }
    @Test
    void distanceToPoint(){
        assertEquals(pointA.distanceToPoint(pointB),4.1231056256176605498214098559741d);
    }
}
