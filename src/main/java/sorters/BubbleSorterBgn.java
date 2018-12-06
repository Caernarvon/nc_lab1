package sorters;

/**
 * Class extends bubble sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "BubbleSorterBgn")
public final class BubbleSorterBgn extends AbstractBubbleSorter {

    /**
     * Method defines sort array algorithm.
     *
     * <p>The main feature of this bubble sort algorithm is that algorithm
     * works from the beginning.
     *
     * @param array array to sort.
     */
    @Override
    public int[] sortAlgorithm(int[] array, int i) {
        for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return "BubbleSorterBgn";
    }
}
