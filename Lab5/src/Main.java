// Лабораторна робота №6, Варіант 10

public class Main {

    // Метод сортування бульбашкою (по спаданню)
    public static void bubbleSortDescending(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Масив не може бути null.");
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Метод сортування вибором (по спаданню)
    public static void selectionSortDescending(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Масив не може бути null.");
        }
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                double temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        double[] array1 = {3.5, 2.1, 5.7, 4.3, 1.9};
        double[] array2 = {7.1, 5.2, 13.4, 1.0, 0.8};

        // Сортування методом Bubble sort
        bubbleSortDescending(array1);
        System.out.println("Bubble sort (по спаданню): " + java.util.Arrays.toString(array1));

        // Сортування методом Selection sort
        selectionSortDescending(array2);
        System.out.println("Selection sort (по спаданню): " + java.util.Arrays.toString(array2));
    }
}
