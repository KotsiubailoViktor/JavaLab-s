
public class Task6 {
    public static void main(String[] args) {
        printResults(1, 0.5);
        printResults(3, 2);
        printResults(0, 1); // Перевірка на помилковий параметр
    }

    public static double computeFunction(double a, double x) {
        if (a < 1 || a > 10) {
            throw new IllegalArgumentException("Параметр a повинен бути в межах [1, 10]. a = " + a);
        }
        return Math.pow(a, x) - Math.sin(a * x);
    }

    static void printResults(double a, double x) {
        System.out.print("a: " + a + ", x: " + x + " -> результат: ");
        try {
            System.out.println(computeFunction(a, x));
        } catch (IllegalArgumentException e) {
            System.out.println("ПОМИЛКА! " + e.getMessage());
        }
    }
}
