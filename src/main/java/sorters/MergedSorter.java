package sorters;

/**
 * @author Vovk
 */

public interface MergedSorter {
    int[] divideArray(int[] array);
    int[] sortDividedArrays(int[] array1, int[] array2);
    int[] mergeArrays(int[] array1, int[] array2);
}
