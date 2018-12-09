package sorters;

/**
 * Class extends merged sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "MergedUtilitySorter")
public final class MergedUtilitySorter extends AbstractMergedSorter {

    /**
     * Defining sort algorithm as utility sort, applying it to arrays and then merge them.
     *
     * @param array1 first half of divided array.
     * @param array2 second half of divided array.
     */
    @Override
    public int[] sortDividedArrays(int[] array1, int[] array2) {
        UtilitySorter sorter = new UtilitySorter();
        sorter.sort(array1);
        sorter.sort(array2);
        return mergeArrays(array1, array2);
    }

    @Override
    public String toString() {
        return "MergedUtilitySorter";
    }
}
