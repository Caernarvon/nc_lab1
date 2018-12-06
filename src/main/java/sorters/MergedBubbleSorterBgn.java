package sorters;

/**
 * Class extends merged sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "MergedBubbleSorterBgn")
public final class MergedBubbleSorterBgn extends AbstractMergedSorter {

    /**
     ** Defining sort algorithm as bubble sort from beginning applying it to arrays
     *  and then merge them.
     *
     * @param array1 first half of divided array.
     * @param array2 second half of divided array.
     */
    @Override
    public int[] sortDividedArray(int[] array1, int[] array2) {
        BubbleSorterBgn sorter = new BubbleSorterBgn();
        sorter.sort(array1);
        sorter.sort(array2);
        return mergeArrays(array1, array2);
    }

    @Override
    public String toString() {
        return "MergedBubbleSorterBgn";
    }
}
