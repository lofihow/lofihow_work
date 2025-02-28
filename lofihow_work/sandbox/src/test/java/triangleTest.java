import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class triangleTest {
    @Test
    void canCalculatePerimeter() {
        var A = new triangle(3, 3, 3);
        Assertions.assertEquals(9, A.trianglePerimeter());
    }

    @Test
    void canCalculateArea() {
        var B = new triangle(3, 3, 3);
        Assertions.assertEquals(3.897114317029974, B.triangleArea());
    }

    @Test
    public void testTriangleWithNegativeSide() {
        try {
            new triangle(-1, 2, 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }
    @Test
    public void testTriangleWithBigSide() {
        try {
            new triangle(10, 2, 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }
    @Test
    void TestEquality(){
        var s1 = new triangle(5,4,3);
        var s2 = new triangle(4,3,5);
        Assertions.assertEquals(s1, s2);
    }
}