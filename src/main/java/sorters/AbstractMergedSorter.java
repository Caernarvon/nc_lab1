package sorters;

import java.util.Arrays;

/**
 * Extension of AbstractSorter class, brings merged sort.
 *
 * @author Vovk
 */

public abstract class AbstractMergedSorter extends AbstractSorter implements MergedSorter {

    /**
     * Overrided sort method to use merged sort.
     *
     * @param array array to work with.
     */
    @Override
    public void sort(int[] array) {
        divideArray(array);
    }

    /**
     * Recursive method that divides array on two. Method works until array
     * size is not less 2. Method calls {@code sortDividedArray} to sort divided
     * arrays.
     *
     * @param array array to work with.
     */
    @Override
    public int[] divideArray(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return sortDividedArray(divideArray(array1),
                divideArray(array2));
    }

    /**
     * Method does sort two halfs of one divided array. Subtypes should override
     * it to define how to sort arrays.
     *
     * <p>When sorting is done {@code mergeArrays} is called to merge two
     * sorted arrays.
     *
     * @param array1 first half of divided array.
     * @param array2 second half of divided array.
     */
    public abstract int[] sortDividedArray(int[] array1, int[] array2);


    /**
     * Method does merge two sorted halfs of one divided array.
     *
     * @param array1 first sorted half of divided array.
     * @param array2 second sorted half of divided array.
     */
    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
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
