package triangle;

public class Triangle {
    public static void main(String[] args) {
    printTriangleArea(3.6,3.2,3.7);
    printTrianglePerimeter(3.0, 3.0, 3.0);

}

    static void printTriangleArea(double a, double b, double c) {
        String text = String.format("Площадь треугольника со сторонами %.2f, %.2f и %.2f = %.2f", a, b, c, triangleArea(a, b, c));
        System.out.println(text);
    }

    static void printTrianglePerimeter(double sideA, double sideB, double sideC) {
        String text2 = String.format("Периметр треугольника со сторонами %.2f + %.2f + %.2f = %.2f", sideA, sideB, sideB, TrianglePerimeter(sideA, sideB,sideC));
        System.out.println(text2);
    }

    public static double TrianglePerimeter(double sideA, double sideB, double sideC) {
        return sideA + sideB + sideC;
    }

    public static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}