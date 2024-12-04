
public class Task12 {
    public static void main(String[] args) {
        computeSum(0.01);
        computeSum(0.0001);
        computeSum(-0.1); // Перевірка на некоректне ε
    }

    public static void computeSum(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Точність ε повинна бути більшою за 0. ε = " + epsilon);
        }

        double sum = 0;
        double term;
        int n = 1;
        do {
            term = 1.0 / (n * n);
            sum += term;
            n++;
        } while (Math.abs(term) > epsilon);

        System.out.println("Сума при ε = " + epsilon + ": " + sum);
    }
}
