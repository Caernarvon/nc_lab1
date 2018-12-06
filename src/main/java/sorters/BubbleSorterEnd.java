package sorters;

/**
 * Class extends bubble sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "BubbleSorterEnd")
public final class BubbleSorterEnd extends AbstractBubbleSorter {

    /**
     * Method defines sort array algorithm.
     *
     * <p>The main feature of this bubble sort algorithm is that algorithm
     * works from the end.
     *
     * @param array array to sort.
     */
    @Override
    public int[] sortAlgorithm(int[] array, int i) {
        for (int j = array.length - 1; j > i; j--) {
            if (array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return "BubbleSorterEnd";
    }
}

