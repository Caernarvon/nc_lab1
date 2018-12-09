package sorters;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Extension of AbstractSorter class, brings merged sort.
 *
 * @author Vovk
 */

public abstract class AbstractMergedSorter extends AbstractSorter implements MergedSorter {
    int[] arr;
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
                /**
                * dividing and sorting arrays in 4 threads
                */
                final Future<int[]> sortResult1 = executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        int[] array1 = Arrays.copyOfRange(array, 0, quarter);
                        return divideArray(array1);
                    }
                });
                final Future<int[]> sortResult2 = executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        int[] array2 = Arrays.copyOfRange(array, quarter, middle);
                        return divideArray(array2);
                    }
                });
                final Future<int[]> sortResult3 = executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        int[] array3 = Arrays.copyOfRange(array, middle, middle + quarter);
                        return divideArray(array3);
                    }
                });
                final Future<int[]> sortResult4 = executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        int[] array4 = Arrays.copyOfRange(array, middle + quarter, array.length);
                        return divideArray(array4);
                    }
                });

                /**
                 * merging arrays in 2 threads
                 */

                try {
                    Future<int[]> merge1 = executor.submit(new Callable<int[]>() {
                        @Override
                        public int[] call() throws ExecutionException, InterruptedException {
                            return mergeArrays(sortResult1.get(), sortResult2.get());
                        }
                    });
                    Future<int[]> merge2 = executor.submit(new Callable<int[]>() {
                        @Override
                        public int[] call() throws ExecutionException, InterruptedException {
                            return mergeArrays(sortResult3.get(), sortResult4.get());
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
                /**
                 * dividing and sorting arrays in 2 threads
                 */
                final Future<int[]> sortResult1 = executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        int[] array1 = Arrays.copyOfRange(array, 0, middle);
                        return divideArray(array1);
                    }
                });
                final Future<int[]> sortResult2 = executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
                        return divideArray(array2);
                    }
                });
                try {
                    /**
                     * merging arrays
                     */
                    setArr(mergeArrays(sortResult1.get(), sortResult2.get()));
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

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }
}
