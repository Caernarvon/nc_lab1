package fillers;

import java.util.Arrays;

public class Filler {

    private Filler () {}

    // Generates and returns a sorted array
    public static int[] generateSortedArray(final int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = generateRandomNumber();
        }
        Arrays.sort(array);
        return array;
    }

    // Generates and returns a sorted array with X int on the final element
    public static int[] generateSortedArrayWithX(final int ARRAY_LENGTH, final int X) {
        int[] array = new int[ARRAY_LENGTH];
        int[] generatedArray = generateSortedArray(ARRAY_LENGTH - 1);
        for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
            array[i] = generatedArray[i];
        }
        array[ARRAY_LENGTH - 1] = X;
        return array;
    }

    // Generates and returns a sorted and then reverted array
    public static int[] generateSortedRevertedArray(final int ARRAY_LENGTH) {
        int[] array = generateSortedArray(ARRAY_LENGTH);
        for (int i = 0; i < ARRAY_LENGTH / 2; i++) {
            int temp = array[i];
            array[i] = array[ARRAY_LENGTH - i - 1];
            array[ARRAY_LENGTH - i - 1] = temp;
        }
        return array;
    }

    // Generates and returns a randomly filled array
    public static int[] generateRandomlyFilledArray(final int ARRAY_LENGTH) {
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = generateRandomNumber();
        }
        return array;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 2147483647);
    }
}
