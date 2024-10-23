public class Main {
    public static void main(String[] args) {
        // Виклик всіх трьох завдань для тестування
        System.out.println("Тестування Завдання 5:");
        Task5.main(args);

        System.out.println("\nТестування Завдання 6:");
        Task6.main(args);

        System.out.println("\nТестування Завдання 12:");
        Task12.main(args);
    }
}

// Завдання 5: f(x) = x^2 + 3x + 2
class Task5 {
    public static void main(String[] args) {
        // Тестуємо метод task5
        testTask5(1);
        testTask5(2);
        testTask5(3);
        testTask5(-1); // Перевірка на від'ємне значення
        testTask5(0);  // Перевірка на нуль
    }

    public static double task5(double x) {
        return x * x + 3 * x + 2;
    }

    private static void testTask5(double x) {
        System.out.println("f(" + x + ") = " + task5(x));
    }
}

// Завдання 6: f(x) = sin(x) + log(x)
class Task6 {
    public static void main(String[] args) {
        // Тестуємо метод task6
        testTask6(1);
        testTask6(2);
        testTask6(3);
        testTask6(-1); // Перевірка на від'ємне значення (викличе виняток)
    }

    public static double task6(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x must be positive for log function");
        }
        return Math.sin(x) + Math.log(x);
    }

    private static void testTask6(double x) {
        try {
            System.out.println("f(" + x + ") = " + task6(x));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}

// Завдання 12: нескінченна сума з точністю epsilon
class Task12 {
    public static void main(String[] args) {
        // Тестуємо метод task12
        testTask12(0.001);
        testTask12(0.0001);
        testTask12(-0.01); // Некоректна точність, викличе виняток
    }

    public static double task12(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("epsilon must be positive");
        }

        double sum = 0.0;
        double term;
        int n = 1;

        do {
            term = 1.0 / (n * n);
            sum += term;
            n++;
        } while (term > epsilon);

        return sum;
    }

    private static void testTask12(double epsilon) {
        try {
            System.out.println("Sum with epsilon = " + epsilon + " is " + task12(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
