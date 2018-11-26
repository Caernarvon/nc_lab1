package sorters;

/**
 * Class uses bubble sort pattern to sort an arrays.
 *
 * @author Vovk
 */

abstract class AbstractBubbleSorter extends AbstractSorter {

    /**
     * Abstract method, should be overrided by subtypes.
     *
     * @param array array to sort
     */
    public abstract void sort(int [] array);
}
