package sorters;

import java.util.Arrays;

public class Sorter {

    private Sorter () {}

    //Bubble sort from the beginning

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

    //Bubble sort from the end

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

    //Quick sort

    public static void quickSort(int[] array) {
        doQuickSort(array, 0, array.length - 1);
    }

    private static void doQuickSort(int[] array, final int ARRAY_START, final int ARRAY_END) {
        if (array.length == 0) {
            return;
        }
        if (ARRAY_START >= ARRAY_END) {
            return;
        }
        int middle = ARRAY_START + (ARRAY_END - ARRAY_START) / 2;
        int current = array[middle];
        int i = ARRAY_START, j = ARRAY_END;
        while (i <= j) {
            while (array[i] < current) {
                i++;
            }

            while (array[j] > current) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (ARRAY_START < j) {
            doQuickSort(array, ARRAY_START, j);}

        if (ARRAY_END > i) {
            doQuickSort(array, i, ARRAY_END);}
    }

    // Merged sort with Bubble sort from the beginning

    public static void mergedSortWithBubbleFromTheBeginning(int[] array) {
        doMergedSortWithBubbleFromTheBeginning(array, 0, array.length - 1);
    }

    private static void doMergedSortWithBubbleFromTheBeginning(int[] array, final int ARRAY_START, final int ARRAY_END) {
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
        doMergedSortWithBubbleFromTheBeginning(array, ARRAY_START, current);
        doMergedSortWithBubbleFromTheBeginning(array, current + 1, ARRAY_END);
    }

    // Merged sort with Bubble sort from the end

    public static void mergedSortWithBubbleFromTheEnd(int[] array) {
        doMergedSortWithBubbleFromTheEnd(array, 0, array.length - 1);
    }

    private static void doMergedSortWithBubbleFromTheEnd(int[] array, final int ARRAY_START, final int ARRAY_END) {
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
            if (j > i) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                if (i == current) {
                    current = j;
                } else if (j == current) {
                    current = i;
                }
            }
        }
        doMergedSortWithBubbleFromTheEnd(array, ARRAY_START, current);
        doMergedSortWithBubbleFromTheEnd(array, current + 1, ARRAY_END);
    }

    // Array sort from Arrays lib

    public static void ArraySort(int[] array) {
        Arrays.sort(array);
    }
}
