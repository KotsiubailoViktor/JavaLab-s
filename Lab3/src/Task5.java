
public class Task5 {
    public static void main(String[] args) {
        printResults(2, 3);
        printResults(-2, -1); // Перевірка на некоректний параметр
        printResults(5, 10);
        printResults(0, 2); // Перевірка на некоректний параметр
    }

    public static double computeFunction(double a, double x) {
        if (a <= 0) {
            throw new IllegalArgumentException("Параметр a повинен бути більшим за 0. a = " + a);
        }
        return a * Math.log(x + a);
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
