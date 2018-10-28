package analyzer;

import fillers.Filler;
import sorters.Sorter;

public class Analyzer {

    private static long start;
    private static long end;
    private static final int ARRAY_LENGTH = 1000;
    private static final int X = (int) (Math.random() * (2147483647 / 2));
    private static int[] sortedArray = Filler.generateSortedArray(ARRAY_LENGTH);
    private static int[] sortedArrayWithX = Filler.generateSortedArrayWithX(ARRAY_LENGTH, X);
    private static int[] sortedRevertedArray = Filler.generateSortedRevertedArray(ARRAY_LENGTH);
    private static int[] randomlyFilledArray = Filler.generateRandomlyFilledArray(ARRAY_LENGTH);


    // Calculating time that required to sort already sorted array

    public static long bubbleSortFromTheBeginningToSortedArray (){
        int[] array = sortedArray.clone();
        return getBubbleSortFromTheBeginningTime(array);
    }

    public static long bubbleSortFromTheEndToSortedArray (){
        int[] array = sortedArray.clone();
        return getBubbleSortFromTheEndTime(array);
    }

    public static long quickSortToSortedArray (){
        int[] array = sortedArray.clone();
        return getQuickSortTime(array);
    }

    public static long arraySortToSortedArray (){
        int[] array = sortedArray.clone();
        return getArraySortTime(array);
    }

    // Calculating time that required to sort already sorted array with X

    public static long bubbleSortFromTheBeginningToSortedArrayWithX (){
        int[] array = sortedArrayWithX.clone();
        return getBubbleSortFromTheBeginningTime(array);
    }

    public static long bubbleSortFromTheEndToSortedArrayWithX (){
        int[] array = sortedArrayWithX.clone();
        return getBubbleSortFromTheEndTime(array);
    }

    public static long quickSortToSortedArrayWithX (){
        int[] array = sortedArrayWithX.clone();
        return getQuickSortTime(array);
    }

    public static long arraySortToSortedArrayWithX (){
        int[] array = sortedArrayWithX.clone();
        return getArraySortTime(array);
    }

    // Calculating time that required to sort already sorted and then reverted array

    public static long bubbleSortFromTheBeginningToSortedRevertedArray (){
        int[] array = sortedRevertedArray.clone();
        return getBubbleSortFromTheBeginningTime(array);
    }

    public static long bubbleSortFromTheEndToSortedRevertedArray (){
        int[] array = sortedRevertedArray.clone();
        return getBubbleSortFromTheEndTime(array);
    }

    public static long quickSortToSortedRevertedArray (){
        int[] array = sortedRevertedArray.clone();
        return getQuickSortTime(array);
    }

    public static long arraySortToSortedRevertedArray (){
        int[] array = sortedRevertedArray.clone();
        return getArraySortTime(array);
    }

    // Calculating time that required to sort randomly filled array

    public static long bubbleSortFromTheBeginningToRandomlyFilledArray (){
        int[] array = randomlyFilledArray.clone();
        return getBubbleSortFromTheBeginningTime(array);
    }

    public static long bubbleSortFromTheEndToRandomlyFilledArray (){
        int[] array = randomlyFilledArray.clone();
        return getBubbleSortFromTheEndTime(array);
    }

    public static long quickSortToRandomlyFilledArray (){
        int[] array = randomlyFilledArray.clone();
        return getQuickSortTime(array);
    }

    public static long arraySortToRandomlyFilledArray (){
        int[] array = randomlyFilledArray.clone();
        return getArraySortTime(array);
    }

    // Calculating time methods for different sorts

    private static long getBubbleSortFromTheBeginningTime (int[] array) {
        start = System.nanoTime();
        Sorter.bubbleSortFromTheBeginning(array);
        end = System.nanoTime();
        return end - start;
    }

    private static long getBubbleSortFromTheEndTime (int[] array) {
        start = System.nanoTime();
        Sorter.bubbleSortFromTheEnd(array);
        end = System.nanoTime();
        return end - start;
    }

    private static long getQuickSortTime (int[] array) {
        start = System.nanoTime();
        Sorter.quickSort(array);
        end = System.nanoTime();
        return end - start;
    }

    private static long getArraySortTime (int[] array) {
        start = System.nanoTime();
        Sorter.ArraySort(array);
        end = System.nanoTime();
        return end - start;
    }

}
