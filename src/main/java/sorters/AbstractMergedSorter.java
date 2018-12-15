package sorters;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Extension of AbstractSorter class, brings merged sort.
 *
 * @author Vovk
 */

public abstract class AbstractMergedSorter extends AbstractSorter implements MergedSorter {
    private int[] arr;
    private static int freeCoresAmount = Runtime.getRuntime().availableProcessors();

    /**
     * Overrided sort method to use merged sort.
     *
     * @param array array to work with.
     */
    @Override
    public void sort(int[] array) {
        doParallelSort(array);
    }

    private void doParallelSort(final int[] array) {
        if ((freeCoresAmount / 2) >= 2) {
            final int middle = array.length / 2;
            final int quarter = middle / 2;
            ExecutorService executor = Executors.newSingleThreadExecutor();
            if ((freeCoresAmount / 2) >= 4) {
                try {
                    /**
                     * dividing and sorting arrays in 4 threads
                     */
                    final int[] array1 = parallelSort(array, executor, 0, quarter);
                    final int[] array2 = parallelSort(array, executor, quarter, middle);
                    final int[] array3 = parallelSort(array, executor, middle, middle + quarter);
                    final int[] array4 = parallelSort(array, executor, middle + quarter, array.length);

                    /**
                     * merging arrays in 2 threads
                     */
                    Future<int[]> merge1 = executor.submit(new Callable<int[]>() {
                        @Override
                        public int[] call() {
                            return mergeArrays(array1, array2);
                        }
                    });
                    Future<int[]> merge2 = executor.submit(new Callable<int[]>() {
                        @Override
                        public int[] call() {
                            return mergeArrays(array3, array4);
                        }
                    });
                    setArr(mergeArrays(merge1.get(), merge2.get()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    executor.shutdown();
                }
            } else {
                try {
                    /**
                     * dividing and sorting arrays in 2 threads
                     */
                    final int[] array1 = parallelSort(array, executor, 0, middle);
                    final int[] array2 = parallelSort(array, executor, middle, array.length);
                    /**
                     * merging arrays
                     */
                    setArr(mergeArrays(array1, array2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    executor.shutdown();
                }
            }
        } else {
            divideArray(array);
        }
    }

    /**
     * Recursive method that divides array on two. Method works until array
     * size is not less 2. Method calls {@code sortDividedArrays} to sort divided
     * arrays.
     *
     * @param array array to work with.
     */
    @Override
    public int[] divideArray(final int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        return sortDividedArrays(divideArray(array1),
                divideArray(array2));
    }

    /**
     * Method does sort two halfs of one divided array. Subtypes should override
     * it to define how to sort arrays.
     *
     * <p>When sorting is done {@code mergeArrays} is called to merge two
     * sorted arrays.
     *
     * @param array1 first half of divided array.
     * @param array2 second half of divided array.
     */
    public abstract int[] sortDividedArrays(int[] array1, int[] array2);

    /**
     * Method does merge two sorted halfs of one divided array.
     *
     * @param array1 first sorted half of divided array.
     * @param array2 second sorted half of divided array.
     */
    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int newArrayLength = array1.length + array2.length;
        int[] array = new int[newArrayLength];
        int k = 0;
        int j = 0;
        for (int i = 0; i < newArrayLength; i++) {
            if (k == array1.length) {
                array[i] = array2[j++];
            } else if (j == array2.length) {
                array[i] = array1[k++];
            } else {
                if (array1[k] < array2[j]) {
                    array[i] = array1[k++];
                } else {
                    array[i] = array2[j++];
                }
            }
        }
        return array;
    }

    private int[] parallelSort(final int[] array, ExecutorService executor, final int startPos, final int endPos) throws ExecutionException, InterruptedException {
        final Future<int[]> sortResult = executor.submit(new Callable<int[]>() {
            @Override
            public int[] call() {
                int[] quarterOfArray = Arrays.copyOfRange(array, startPos, endPos);
                return divideArray(quarterOfArray);
            }
        });
        return sortResult.get();
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }
}
