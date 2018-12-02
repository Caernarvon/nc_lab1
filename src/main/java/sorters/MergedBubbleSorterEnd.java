package sorters;

/**
 * Class extends merged sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "MergedBubbleSorterEnd")
public final class MergedBubbleSorterEnd extends AbstractMergedSorter {

    /**
     * Defining sort algorithm as bubble sort from end, applying it to arrays
     * and then merge them.
     *
     * @param array1 first half of divided array
     * @param array2 second half of divided array
     */
    @Override
    public int[] sortDividedArray(int[] array1, int[] array2) {
        BubbleSorterEnd sorter = new BubbleSorterEnd();
        sorter.sort(array1);
        sorter.sort(array2);
        return mergeArrays(array1, array2);
    }
}
