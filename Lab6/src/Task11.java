public class Task11 {
    public static String convertWordsToLowerCase(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Речення не може бути null.");
        }

        String[] parts = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            if (part.matches("[a-zA-Z]+")) { // Слово
                result.append(part.toLowerCase());
            } else { // Не слово
                result.append(part);
            }
            result.append(" "); // Додаємо пробіл між словами
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("Перетворення слів у реченні на малі літери:");
        try {
            String input1 = "The user With the Nickname Koala757677";
            System.out.println("Вхідне речення: " + input1);
            System.out.println("Результат: " + convertWordsToLowerCase(input1));

            String input2 = "HELLO WORLD 1234 ABCD";
            System.out.println("Вхідне речення: " + input2);
            System.out.println("Результат: " + convertWordsToLowerCase(input2));

            // Некоректний приклад
            String input3 = null;
            System.out.println("Вхідне речення: " + input3);
            System.out.println("Результат: " + convertWordsToLowerCase(input3));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
