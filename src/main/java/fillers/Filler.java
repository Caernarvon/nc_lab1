package fillers;

import java.util.Arrays;

/**
 * Class that fills arrays.
 *
 * @author Vovk
 */

public class Filler {


    /**
     * Don't let anyone instantiate this class.
     */
    private Filler () {}

    /**
     * Generates and returns a sorted array.
     */
    @FillMethod(name = "SortedArray")
    public static int[] generateSortedArray(final int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        array[0] = 1;
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            array[i] = array[i - 1] + generateRandomNumber();
        }
        return array;
    }

    /**
     * Generates and returns a sorted array with X int on the final element.
     */
    @FillMethod(name = "SortedArrayWithX")
    public static int[] generateSortedArrayWithX(final int ARRAY_LENGTH) {
        final int X = generateRandomNumber() * 2;
        int[] array;
        int[] generatedArray = generateSortedArray(ARRAY_LENGTH - 1);
        array = Arrays.copyOf(generatedArray, ARRAY_LENGTH);
        array[ARRAY_LENGTH - 1] = X;
        return array;
    }

    /**
     * Generates and returns a sorted and then reverted array.
     */
    @FillMethod(name = "SortedRevertedArray")
    public static int[] generateSortedRevertedArray(final int ARRAY_LENGTH) {
        int[] array = generateSortedArray(ARRAY_LENGTH);
        for (int i = 0; i < ARRAY_LENGTH / 2; i++) {
            int temp = array[i];
            array[i] = array[ARRAY_LENGTH - i - 1];
            array[ARRAY_LENGTH - i - 1] = temp;
        }
        return array;
    }

    /**
     * Generates and returns a randomly filled array.
     */
    @FillMethod(name = "RandomlyFillerArray")
    public static int[] generateRandomlyFilledArray(final int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = generateRandomNumber();
        }
        return array;
    }

    /**
     * Generates and returns a random number.
     */
    private static int generateRandomNumber() {
        return (int) (Math.random() * 1000);
    }
}
