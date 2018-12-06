package sorters;

import java.util.Arrays;

/**
 * Class extends sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "UtilitySorter")
public final class UtilitySorter extends AbstractSorter {

    /**
     * Method does sort array by quick sort algorithm.
     *
     * <p>Method calls {@code Arrays.sort} to do sort.
     *
     * @param array array to sort.
     */
    public void sort(int[] array) {
        Arrays.sort(array);
    }

    @Override
    public String toString() {
        return "UtilitySorter";
    }
}
