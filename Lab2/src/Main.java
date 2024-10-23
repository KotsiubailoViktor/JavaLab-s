public class Main {
    public static void main(String[] args) {
        // Завдання 28
        double a1 = 1.478;
        double b1 = 9.26;
        double c1 = 0.68;
        double d1 = 2.24;

        double result28 = 2 * (Math.log(Math.abs(b1/a1)) + Math.sqrt(Math.sinh(c1) + Math.pow(Math.E, d1)));
        System.out.println("Результат завдання 28: " + result28);

        // Завдання 29
        double a2 = -2.86;
        double b2 = 1.62;
        double c2 = 10.874;
        double d2 = 2.91;

        double result29 = Math.pow(2 * Math.cos(Math.sqrt(Math.abs(a2 / b2))) + 4 * asinh(d2), c2);
        System.out.println("Результат завдання 29: " + result29);

        // Завдання 30
        double a3 = 0.58;
        double b3 = -0.34;
        double c3 = 1.25;
        double d3 = 1.89;

        double result30 = (3 * a3) / Math.cos(a3) + Math.sqrt(Math.tanh(Math.abs(b3) * c3) / Math.log(d3));
        System.out.println("Результат завдання 30: " + result30);
    }

    // Метод для обчислення гіперболічного арксинуса
    public static double asinh(double x) {
        return Math.log(x + Math.sqrt(x * x + 1));
    }
}
