public class Task4 {
    public static int hexStringToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім або null.");
        }
        try {
            return Integer.parseInt(s, 16);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Рядок повинен містити коректне шістнадцяткове число.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Перетворення шістнадцяткового рядка на ціле число:");
        try {
            String input1 = "CAFE";
            System.out.println("Вхідні дані: " + input1);
            System.out.println("Результат: " + hexStringToInt(input1));

            String input2 = "FFFF";
            System.out.println("Вхідні дані: " + input2);
            System.out.println("Результат: " + hexStringToInt(input2));

            // Некоректний приклад
            String input3 = "XYX";
            System.out.println("Вхідні дані: " + input3);
            System.out.println("Результат: " + hexStringToInt(input3));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
