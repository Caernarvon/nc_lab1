package sorters;

/**
 * Class uses bubble sort pattern to sort an arrays.
 *
 * @author Vovk
 */

abstract class AbstractBubbleSorter extends AbstractSorter {

    /**
     * Sort method. Uses {@code sortAlgorithm} to define sorting algorithm.
     *
     * @param array array to sort.
     */
    public void sort(int [] array){
        for (int i = 0; i < array.length; i++){
            sortAlgorithm(array, i);
        }
    }

    /**
     * Abstract method, defines sorting algorithm, should be overrided by subtypes.
     *
     * @param array array to sort.
     * @param i amount of elements in array, value reduces with each iteration to
     *          to improve performance.
     */
    public abstract int[] sortAlgorithm(int [] array, int i);


}
