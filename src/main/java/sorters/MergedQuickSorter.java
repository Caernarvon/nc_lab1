package sorters;

/**
 * Class extends merged sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "MergedQuickSorter")
public final class MergedQuickSorter extends AbstractMergedSorter {

    /**
     * Defining sort algorithm as quick sort, applying it to arrays and
     * then merge them.
     *
     * @param array1 first half of divided array
     * @param array2 second half of divided array
     */
    @Override
    public int[] sortDividedArray(int[] array1, int[] array2) {
        QuickSorter sorter = new QuickSorter();
        sorter.sort(array1);
        sorter.sort(array2);
        return mergeArrays(array1, array2);
    }
}
