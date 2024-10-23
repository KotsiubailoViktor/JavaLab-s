public class Main {
    public static void main(String[] args) {
        // Виклик всіх трьох завдань для тестування
        System.out.println("Тестування Завдання 10:");
        Task10.main(args);

        System.out.println("\nТестування Завдання 40:");
        Task40.main(args);

        System.out.println("\nТестування Завдання 63:");
        Task63.main(args);
    }
}

// Завдання 10: Знайти середнє арифметичне елементів масиву
class Task10 {
    public static void main(String[] args) {
        // Тестуємо метод task10
        testTask10(new int[] {1, 2, 3, 4, 5});
        testTask10(new int[] {});  // Викличе виняток
    }

    public static double task10(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім або null");
        }
        int sum = 0;
        for (int value : array) { // Використання for-each
            sum += value;
        }
        return (double) sum / array.length;
    }

    public static void testTask10(int[] array) {
        try {
            System.out.println("Середнє арифметичне: " + task10(array));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}

// Завдання 40: Знайти різницю між максимальним і другим елементом масиву
class Task40 {
    public static void main(String[] args) {
        // Тестуємо метод task40
        testTask40(new int[] {10, 15, 3, 7, 8});
        testTask40(new int[] {1});  // Викличе виняток
    }

    public static int task40(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Масив повинен містити щонайменше 2 елементи");
        }
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Використання циклу for
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                second = max;
                max = array[i];
            } else if (array[i] > second) {
                second = array[i];
            }
        }
        return max - array[1]; // Різниця між максимальним і другим елементом
    }

    public static void testTask40(int[] array) {
        try {
            System.out.println("Різниця між максимальним і другим елементом: " + task40(array));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}

// Завдання 63: Модифікація масиву
class Task63 {
    public static void main(String[] args) {
        // Тестуємо метод task63
        testTask63(new int[] {-3, 0, 5, -1, 8});
        testTask63(new int[] {});  // Викличе виняток
    }

    public static int[] task63(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім або null");
        }

        int max = Integer.MIN_VALUE;
        for (int value : array) { // Використання for-each
            if (value > max) {
                max = value;
            }
        }

        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                newArray[i] = array[i] + max;
            } else if (array[i] == 0) {
                newArray[i] = 1;
            } else {
                newArray[i] = array[i] * 2;
            }
        }
        return newArray;
    }

    public static void testTask63(int[] array) {
        try {
            int[] newArray = task63(array);
            System.out.print("Новий масив: ");
            for (int value : newArray) {
                System.out.print(value + " ");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
