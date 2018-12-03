package sorters;

/**
 * Class extends sort algorithm.
 *
 * @author Vovk
 */

@SorterName(name = "QuickSorter")
public final class QuickSorter extends AbstractSorter {

    /**
     * Method does sort array by quick sort algorithm.
     *
     * <p>Method calls {@code quickSort} to do sort.
     *
     * @param array array to sort
     */
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);

    }

    /**
     * Sorting algorithm is defined in this method.
     *
     * <p>Method calls {@code quickSort} to do sort.
     *
     * @param array array to sort
     * @param ARRAY_START start point of array
     * @param ARRAY_END end point of array
     */
    private void quickSort(int[] array, final int ARRAY_START, final int ARRAY_END) {
        if (array.length == 0) {
            return;
        }
        if (ARRAY_START >= ARRAY_END) {
            return;
        }
        int middle = ARRAY_START + (ARRAY_END - ARRAY_START) / 2;
        int current = array[middle];
        int i = ARRAY_START, j = ARRAY_END;
        while (i <= j) {
            while (array[i] < current) {
                i++;
            }

            while (array[j] > current) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (ARRAY_START < j) {
            quickSort(array, ARRAY_START, j);
        }

        if (ARRAY_END > i) {
            quickSort(array, i, ARRAY_END);
        }
    }

    @Override
    public String toString() {
        return "QuickSorter";
    }
}
