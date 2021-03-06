package analyzer;

import fillers.FillMethod;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import sorters.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * The class {@code Analyzer} contains methods for performing
 * basic time analysis of sorters depending on filling method
 * and chosen sorter.
 *
 * <p> Public methods doesn't require any arguments because it's
 * expected to use this class only for getting time required to
 * perform sorting. Class allows to get sorting time depending on
 * the all declared filling methods and sorting methods.
 *
 * @author Vovk
 */

public class Analyzer {

    /**
     * The{@code long} value is used to save time before performing
     * something.
     */
    private static long start;

    /**
     * The{@code long} value is used to save time after some method
     * performed.
     */
    private static long end;

    /**
     * The{@code int} value is used to define array length in all
     * fillers.
     */
    private final int ARRAY_SIZE = 1000;

    /**
     * Generating all arrays through reflection. Later these arrays will be
     * used to get copy of selected one and than perform selected type of sorting
     * on it. Copying lets to get replica of originally created array to get
     * best results of checking time.
     */

    private analyzer.ReflectionUtils reflectionUtils = new analyzer.ReflectionUtils();
    private int[] sortedArray = reflectionUtils.fillThroughReflection("generateSortedArray(int)", ARRAY_SIZE);
    private int[] sortedArrayWithX = reflectionUtils.fillThroughReflection("generateSortedArrayWithX(int)", ARRAY_SIZE);
    private int[] sortedRevertedArray = reflectionUtils.fillThroughReflection("generateSortedRevertedArray(int)", ARRAY_SIZE);
    private int[] randomlyFilledArray = reflectionUtils.fillThroughReflection("generateRandomlyFilledArray(int)", ARRAY_SIZE);

    /**
     * Methods below allows to calculate time that required to sort an already
     * sorted array.
     */
    public long bubbleSortBgnToSortedArray() {
        int[] array = sortedArray.clone();
        return getBubbleSortBgnTime(array);
    }

    public long bubbleSortEndToSortedArray() {
        int[] array = sortedArray.clone();
        return getBubbleSortEndTime(array);
    }

    public long quickSortToSortedArray() {
        int[] array = sortedArray.clone();
        return getQuickSortTime(array);
    }

    public long utilitySortToSortedArray() {
        int[] array = sortedArray.clone();
        return getUtilitySortTime(array);
    }

    public long mergedBubbleSortBgnToSortedArray() {
        int[] array = sortedArray.clone();
        return getMergedBubbleSortBgnTime(array);
    }

    public long mergedBubbleSortEndToSortedArray() {
        int[] array = sortedArray.clone();
        return getMergedBubbleSortEndTime(array);
    }

    public long mergedQuickSortToSortedArray() {
        int[] array = sortedArray.clone();
        return getMergedQuickSortTime(array);
    }

    public long mergedUtilitySortToSortedArray() {
        int[] array = sortedArray.clone();
        return getMergedUtilitySortTime(array);
    }

    /**
     * Methods below allows to calculate time that required to sort an already
     * sorted array with X.
     */
    public long bubbleSortBgnToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getBubbleSortBgnTime(array);
    }

    public long bubbleSortEndToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getBubbleSortEndTime(array);
    }

    public long quickSortToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getQuickSortTime(array);
    }

    public long utilitySortToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getUtilitySortTime(array);
    }

    public long mergedBubbleSortBgnToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getMergedBubbleSortBgnTime(array);
    }

    public long mergedBubbleSortEndToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getMergedBubbleSortEndTime(array);
    }

    public long mergedQuickSortToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getMergedQuickSortTime(array);
    }

    public long mergedUtilitySortToSortedArrayWithX() {
        int[] array = sortedArrayWithX.clone();
        return getMergedUtilitySortTime(array);
    }

    /**
     * Methods below allows to calculate time that required to sort already
     * sorted and then reverted array.
     */
    public long bubbleSortBgnToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getBubbleSortBgnTime(array);
    }

    public long bubbleSortEndToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getBubbleSortEndTime(array);
    }

    public long quickSortToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getQuickSortTime(array);
    }

    public long utilitySortToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getUtilitySortTime(array);
    }

    public long mergedBubbleSortBgnToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getMergedBubbleSortBgnTime(array);
    }

    public long mergedBubbleSortEndToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getMergedBubbleSortEndTime(array);
    }

    public long mergedQuickSortToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getMergedQuickSortTime(array);
    }

    public long mergedUtilitySortToSortedRevertedArray() {
        int[] array = sortedRevertedArray.clone();
        return getMergedUtilitySortTime(array);
    }

    /**
     * Methods below allows to calculate time that required to sort
     * randomly filled array.
     */
    public long bubbleSortBgnToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getBubbleSortBgnTime(array);
    }

    public long bubbleSortEndToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getBubbleSortEndTime(array);
    }

    public long quickSortToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getQuickSortTime(array);
    }

    public long utilitySortToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getUtilitySortTime(array);
    }

    public long mergedBubbleSortBgnToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getMergedBubbleSortBgnTime(array);
    }

    public long mergedBubbleSortEndToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getMergedBubbleSortEndTime(array);
    }

    public long mergedQuickSortToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getMergedQuickSortTime(array);
    }

    public long mergedUtilitySortToRandomlyFilledArray() {
        int[] array = randomlyFilledArray.clone();
        return getMergedUtilitySortTime(array);
    }

    /**
     * Methods which are used to get sorting time depending on transferred
     * array.
     *
     * @param array array to work with.
     */
    private long getBubbleSortBgnTime(int[] array) {
        BubbleSorterBgn bubbleSorterBgn = new BubbleSorterBgn();
        return getSortTime(array, bubbleSorterBgn, "sorters.BubbleSorterBgn");
    }

    private long getBubbleSortEndTime(int[] array) {
        BubbleSorterEnd bubbleSorterEnd = new BubbleSorterEnd();
        return getSortTime(array, bubbleSorterEnd, "sorters.BubbleSorterEnd");
    }

    private long getQuickSortTime(int[] array) {
        QuickSorter quickSorter = new QuickSorter();
        return getSortTime(array, quickSorter, "sorters.QuickSorter");
    }

    private long getUtilitySortTime(int[] array) {
        UtilitySorter utilitySorter = new UtilitySorter();
        return getSortTime(array, utilitySorter, "sorters.UtilitySorter");
    }

    private long getMergedBubbleSortBgnTime(int[] array) {
        MergedBubbleSorterBgn mergedBubbleSorterBgn = new MergedBubbleSorterBgn();
        return getSortTime(array, mergedBubbleSorterBgn, "sorters.MergedBubbleSorterBgn");
    }

    private long getMergedBubbleSortEndTime(int[] array) {
        MergedBubbleSorterEnd mergedBubbleSorterEnd = new MergedBubbleSorterEnd();
        return getSortTime(array, mergedBubbleSorterEnd, "sorters.MergedBubbleSorterEnd");
    }

    private long getMergedQuickSortTime(int[] array) {
        MergedQuickSorter mergedQuickSorter = new MergedQuickSorter();
        return getSortTime(array, mergedQuickSorter, "sorters.MergedQuickSorter");
    }

    private long getMergedUtilitySortTime(int[] array) {
        MergedUtilitySorter mergedUtilitySorter = new MergedUtilitySorter();
        return getSortTime(array, mergedUtilitySorter, "sorters.MergedUtilitySorter");
    }

    /**
     * Calculating time that required to sort any given types of array.
     *
     * <p>Method takes any of {@code AbstractSorter} subtypes, that's gives a some flexibility
     * while using this method.
     *
     * @param array          array to work with.
     * @param abstractSorter subtype of AbstractSorter.
     * @param className      class name to find class.
     */
    private long getSortTime(int[] array, AbstractSorter abstractSorter, String className) {
        for (Class<? extends AbstractSorter> subType : reflectionUtils.findSubclasses()) {
            if (subType.toString().contains(className)) {
                try {
                    Method method = subType.getMethod("sort", int[].class);
                    start = System.nanoTime();
                    method.invoke(abstractSorter, array);
                    end = System.nanoTime();

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        return end - start;
    }
}
