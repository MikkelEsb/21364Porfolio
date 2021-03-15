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
}
