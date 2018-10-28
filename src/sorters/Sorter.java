package sorters;

import java.util.Arrays;

public class Sorter {

    public static void bubbleSortFromTheBeginning(int[] array) {
        doBubbleSortFromTheBeginning(array);
    }

    private static void doBubbleSortFromTheBeginning(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortFromTheEnd(int[] array) {
        doBubbleSortFromTheEnd(array);
    }

    private static void doBubbleSortFromTheEnd(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array) {

        doQuickSort(array, 0, array.length - 1);
    }

    private static void doQuickSort(int[] array, final int ARRAY_START, final int ARRAY_END) {
        if (ARRAY_START >= ARRAY_END) {
            return;
        }

        int i = ARRAY_START;
        int j = ARRAY_END;
        int current = i - (i - j) / 2;
        while (i < j) {
            while (i < current && (array[i] <= array[current])) {
                i++;
            }
            while (j > current && (array[current] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == current) {
                    current = j;
                } else if (j == current) {
                    current = i;
                }
            }
        }
    }

    public static void ArraySort(int[] array) {
        Arrays.sort(array);
    }
}
