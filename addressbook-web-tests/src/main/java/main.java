public class main {
    public static void main(String[] args) {
        try {
            var z = calculate();
            System.out.println(z);
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());

        }
    }


    private static int calculate() {
        var x = 1;
        var y = 0;
        var z = divate(x, y);
        return z;
    }

    private static int divate(int x, int y) {
        var z = x / y;
        return z;
    }
}
