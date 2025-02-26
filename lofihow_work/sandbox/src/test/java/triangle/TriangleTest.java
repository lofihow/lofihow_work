package triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void canCalculatePerimeter() {
        double result = Triangle.TrianglePerimeter(3, 3,3);
        Assertions.assertEquals(9, result);
    }
    @Test
    void canCalculateArea(){
        double result = Triangle.triangleArea(3.6, 3.2, 3.7);
        Assertions.assertEquals(5.246436290473753, result);
    }
}
