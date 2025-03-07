import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTEST {
    @Test
    void canCalculatePerimeter() {
        var A = new Triangle(3, 3, 3);
        Assertions.assertEquals(9, A.trianglePerimeter());
    }

    @Test
    void canCalculateArea() {
        var B = new Triangle(3, 3, 3);
        Assertions.assertEquals(3.897114317029974, B.triangleArea());
    }

    @Test
    public void testTriangleWithNegativeSide() {
        try {
            new Triangle(-1, 2, 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }
    @Test
    public void testTriangleWithBigSide() {
        try {
            new Triangle(10, 2, 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }
    @Test
    void TestEquality(){
        var s1 = new Triangle(5,4,3);
        var s2 = new Triangle(4,3,5);
        Assertions.assertEquals(s1, s2);
    }


@Test
void testEquality2(){
    var a = 2;
    var b = 3;
    var c = 4;
    var triangle2 = new Triangle(a, b, c);
    var triangle1 = new Triangle(a, c, b);
    Assertions.assertEquals(triangle2, triangle1);
}
    @Test
    void testEquality3(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle2 = new Triangle(a, b, c);
        var triangle1 = new Triangle(b, a, c);
        Assertions.assertEquals(triangle2, triangle1);
    }
    @Test
    void testEquality6(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(c, b, a);
        Assertions.assertEquals(triangle, triangle1);
    }
}