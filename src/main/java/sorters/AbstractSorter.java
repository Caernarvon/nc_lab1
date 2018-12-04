package sorters;

/**
 * Sorting class, brings sort feature.
 *
 * @author Vovk
 */

public abstract class AbstractSorter {

    /**
     * Abstract method, should be overrided by subtypes.
     *
     * @param array array to sort
     */
    public abstract void sort(int [] array);
}
