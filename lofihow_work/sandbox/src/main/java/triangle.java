public class triangle {
    public double sideA;
    public double sideB;
    public double sideC;

    public triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Длина стороны треугольника должна быть положительны.");
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Стороны не могут образовать треугольник");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double trianglePerimeter() {
        return sideA + sideB + sideC;
    }

    public double triangleArea() {
        double Perimeter = trianglePerimeter() / 2;
        return Math.sqrt(Perimeter * (Perimeter - sideA) * (Perimeter - sideB) * (Perimeter - sideC));
    }
    public void info(){
        String text = String.format("Периметер треугольника со сторонами %f, %f, %f = %f", sideA, sideB, sideC, trianglePerimeter());
        System.out.println(text);
        String text2 = String.format("Площадь треугольника со сторонами %f, %f, %f = %.2f", sideA, sideB, sideC, triangleArea());
        System.out.println(text2);
    }
}
