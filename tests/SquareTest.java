import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SquareTest {
    Square squareA;
    @BeforeEach
    void setup(){
        squareA=new Square(new Point2D(0,0),new Point2D(2,2));
    }
    @Test
    void areaSquare(){
        assertEquals(4d,squareA.getArea());
    }
    @Test
    void areaPerimeter(){
        assertEquals(8d,squareA.getPerimeter());
    }
}
