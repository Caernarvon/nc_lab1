package sorters;

import java.util.Arrays;

public class Sorter {

    private Sorter () {}

    //Bubble sort from the beginning

    public static void bubbleSortFromTheBeginning(int[] array) {
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

    //Bubble sort from the end

    public static void bubbleSortFromTheEnd(int[] array) {
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

    public static int[] mergedSortWithBubbleFromTheBeginning(int[] array) {
        if(array.length < 2) {
            return array;}
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);

        return doMergedSortWithBubbleFromTheBeginning(mergedSortWithBubbleFromTheBeginning(array1),
                mergedSortWithBubbleFromTheBeginning(array2));
    }

    private static int[] doMergedSortWithBubbleFromTheBeginning(int[] array1, int array2[]){
        bubbleSortFromTheBeginning(array1);
        bubbleSortFromTheBeginning(array2);
        return mergeArrays(array1, array2);
    }

    // Merged sort with Bubble sort from the end

    public static int[] mergedSortWithBubbleFromTheEnd(int[] array) {
        if(array.length < 2) {
            return array;}
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return doMergedSortWithBubbleFromTheEnd(mergedSortWithBubbleFromTheEnd(array1),
                mergedSortWithBubbleFromTheEnd(array2));
    }

    private static int[] doMergedSortWithBubbleFromTheEnd(int[] array1, int array2[]){
        bubbleSortFromTheEnd(array1);
        bubbleSortFromTheEnd(array2);
        return mergeArrays(array1, array2);
    }





    // Merged sort with quick sort

    public static int[] mergedSortWithQuickSort(int[] array) {
        if(array.length < 2) {
            return array;}
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return doMergedSortWithQuickSort(mergedSortWithQuickSort(array1),
                mergedSortWithQuickSort(array2));
    }

    private static int[] doMergedSortWithQuickSort(int[] array1, int array2[]){
        quickSort(array1);
        quickSort(array2);
        return mergeArrays(array1, array2);
    }

    // Merged sort with quick sort

    public static int[] mergedSortWithArraySort(int[] array) {
        if(array.length < 2) {
            return array;}
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return doMergedSortWithArraySort(mergedSortWithArraySort(array1),
                mergedSortWithArraySort(array2));
    }

    private static int[] doMergedSortWithArraySort(int[] array1, int array2[]){
        arraySort(array1);
        arraySort(array2);
        return mergeArrays(array1, array2);
    }

    // Array sort from Arrays lib

    public static void arraySort(int[] array) {
        Arrays.sort(array);
    }

    //Method that merges two arrays in one sorted array

    private static int[] mergeArrays(int[] array1, int[]array2) {
        int newArrayLength = array1.length + array2.length;
        int[] array = new int[newArrayLength];
        int k = 0;
        int j = 0;
        for (int i = 0; i < newArrayLength; i++) {
            if (k == array1.length) {
                array[i] = array2[j++];
            } else if (j == array2.length) {
                array[i] = array1[k++];
            } else {
                if (array1[k] < array2[j]) {
                    array[i] = array1[k++];
                } else {
                    array[i] = array2[j++];
                }
            }
        }
        return array;
    }
}
