package output;

import analyzer.Analyzer;

public class Output {

    // Methods to print sorted array

    private static void printBubbleSortFromTheBeginningToSortedArray() {
        System.out.println("Bubble sort from the beginning to sorted array takes \t\t\t" + Analyzer.
                bubbleSortFromTheBeginningToSortedArray() + " ns");
    }

    private static void printBubbleSortFromTheEndToSortedArray() {
        System.out.println("Bubble sort from the end to sorted array takes \t\t\t\t\t" + Analyzer.
                bubbleSortFromTheEndToSortedArray() + " ns");
    }

    private static void printQuickSortToSortedArray() {
        System.out.println("Quick sort to sorted array takes \t\t\t\t\t\t\t\t" + Analyzer.
                quickSortToSortedArray() + " ns");
    }

    private static void printArraySortToSortedArray() {
        System.out.println("Array sort to sorted array takes \t\t\t\t\t\t\t\t" + Analyzer.
                arraySortToSortedArray() + " ns");
    }

    // Methods to print sorted array with X

    private static void printBubbleSortFromTheBeginningToSortedArrayWithX() {
        System.out.println("Bubble sort from the beginning to sorted array with X takes \t" + Analyzer.
                bubbleSortFromTheBeginningToSortedArrayWithX() + " ns");
    }

    private static void printBubbleSortFromTheEndToSortedArrayWithX() {
        System.out.println("Bubble sort from the end to sorted array with X takes \t\t\t" + Analyzer.
                bubbleSortFromTheEndToSortedArrayWithX() + " ns");
    }

    private static void printQuickSortToSortedArrayWithX() {
        System.out.println("Quick sort to sorted array with X takes \t\t\t\t\t\t" + Analyzer.
                quickSortToSortedArrayWithX() + " ns");
    }

    private static void printArraySortToSortedArrayWithX() {
        System.out.println("Array sort to sorted array with X takes \t\t\t\t\t\t" + Analyzer.
                arraySortToSortedArrayWithX() + " ns");
    }

    // Methods to print sorted and then reverted array with X

    private static void printBubbleSortFromTheBeginningToSortedRevertedArray() {
        System.out.println("Bubble sort from the beginning to sorted reverted array takes \t" + Analyzer.
                bubbleSortFromTheBeginningToSortedArray() + " ns");
    }

    private static void printBubbleSortFromTheEndToSortedRevertedArray() {
        System.out.println("Bubble sort from the end to sorted reverted array takes \t\t" + Analyzer.
                bubbleSortFromTheEndToSortedRevertedArray() + " ns");
    }

    private static void printQuickSortToSortedRevertedArray() {
        System.out.println("Quick sort to sorted reverted array takes \t\t\t\t\t\t" + Analyzer.
                quickSortToSortedRevertedArray() + " ns");
    }

    private static void printArraySortToSortedRevertedArray() {
        System.out.println("Array sort to sorted reverted array takes \t\t\t\t\t\t" + Analyzer.
                arraySortToSortedRevertedArray() + " ns");
    }

    // Methods to print randomly filled array

    private static void printBubbleSortFromTheBeginningToRandomlyFilledArray() {
        System.out.println("Bubble sort from the beginning to randomly filled array takes \t" + Analyzer.
                bubbleSortFromTheBeginningToRandomlyFilledArray() + " ns");
    }

    private static void printBubbleSortFromTheEndToRandomlyFilledArray() {
        System.out.println("Bubble sort from the end to randomly filled array takes \t\t" + Analyzer.
                bubbleSortFromTheEndToRandomlyFilledArray() + " ns");
    }

    private static void printQuickSortToRandomlyFilledArray() {
        System.out.println("Quick sort to randomly filled array takes \t\t\t\t\t\t" + Analyzer.
                quickSortToRandomlyFilledArray() + " ns");
    }

    private static void printArraySortToRandomlyFilledArray() {
        System.out.println("Array sort to randomly filled array takes \t\t\t\t\t\t" + Analyzer.
                arraySortToRandomlyFilledArray() + " ns");
    }



    public static void main(String[] args) {
        printBubbleSortFromTheBeginningToSortedArray();
        printBubbleSortFromTheBeginningToSortedArrayWithX();
        printBubbleSortFromTheBeginningToSortedRevertedArray();
        printBubbleSortFromTheBeginningToRandomlyFilledArray();

        System.out.println();

        printBubbleSortFromTheEndToSortedArray();
        printBubbleSortFromTheEndToSortedArrayWithX();
        printBubbleSortFromTheEndToSortedRevertedArray();
        printBubbleSortFromTheEndToRandomlyFilledArray();

        System.out.println();

        printQuickSortToSortedArray();
        printQuickSortToSortedArrayWithX();
        printQuickSortToSortedRevertedArray();
        printQuickSortToRandomlyFilledArray();

        System.out.println();

        printArraySortToSortedArray();
        printArraySortToSortedArrayWithX();
        printArraySortToSortedRevertedArray();
        printArraySortToRandomlyFilledArray();
    }
}
