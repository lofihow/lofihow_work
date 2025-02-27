import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class triangleTest {
    @Test
    void canCalculatePerimeter(){
        var A = new triangle(3,3,3);
        Assertions.assertEquals(9, A.trianglePerimeter());
    }
    @Test
    void canCalculateArea(){
        var B = new triangle(3,3,3);
        Assertions.assertEquals(3.897114317029974, B.triangleArea());
    }
}