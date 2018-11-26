package sorters;

/**
 * Class extends bubble sort algorithm.
 *
 * @author Vovk
 */

public final class BubbleSorterEnd extends AbstractBubbleSorter {

    /**
     * Method does sort array by bubble sort algorithm.
     *
     * <p>The main feature of this bubble sort algorithm is that algorithm
     * works from the end.
     *
     * @param array array to sort
     */
    @Override
    public void sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}

