import analyzer.Analyzer;
import fillers.Filler;
import org.junit.Assert;
import org.junit.Test;
import sorters.*;

/**
 * @author Vovk Dmytro
 */

public class Tester extends Assert {
    Analyzer analyzer = new Analyzer();

    @Test(expected = NegativeArraySizeException.class)
    public void testSortedArrayGeneration() {
        Filler.generateSortedArray(-1);
    }

    @Test(expected = java.lang.NumberFormatException.class, timeout = 100000)
    public void testSortedArrayGeneration2() {
        Filler.generateSortedArray(Integer.parseInt("asd"));
    }

    @Test(timeout = 3000)
    public void testSortedArrayGeneration3() {
        Filler.generateSortedArray(99999);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testSortedArrayWithXGeneration() {
        Filler.generateSortedArray(-1);
    }

    @Test(expected = java.lang.NumberFormatException.class, timeout = 100000)
    public void testSortedArrayWithXGeneration2() {
        Filler.generateSortedArray(Integer.parseInt("asd"));
    }

    @Test(timeout = 3000)
    public void testSortedArrayWithXGeneration3() {
        Filler.generateSortedArray(99999);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testSortedRevertedArrayGeneration() {
        Filler.generateSortedArray(-1);
    }

    @Test(expected = java.lang.NumberFormatException.class, timeout = 100000)
    public void testSortedRevertedArrayGeneration2() {
        Filler.generateSortedArray(Integer.parseInt("asd"));
    }

    @Test(timeout = 3000)
    public void testSortedRevertedArrayGeneration3() {
        Filler.generateSortedArray(99999);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testRandomlyFilledArrayGeneration() {
        Filler.generateSortedArray(-1);
    }

    @Test(expected = java.lang.NumberFormatException.class, timeout = 100000)
    public void testRandomlyFilledArrayGeneration2() {
        Filler.generateSortedArray(Integer.parseInt("asd"));
    }

    @Test(timeout = 3000)
    public void testRandomlyFilledArrayGeneration3() {
        Filler.generateSortedArray(99999);
    }

    // Analyzer public methods test

    @Test(timeout = 3000)
    public void testBubbleSortBgnToSortedArray() {
        analyzer.bubbleSortBgnToSortedArray();
    }

    @Test(timeout = 3000)
    public void testBubbleSortEndToSortedArray() {
        analyzer.bubbleSortEndToSortedArray();
    }

    @Test(timeout = 3000)
    public void quickSortToSortedArray() {
        analyzer.quickSortToSortedArray();
    }

    @Test(timeout = 3000)
    public void utilitySortToSortedArray() {
        analyzer.utilitySortToSortedArray();
    }

    @Test(timeout = 3000)
    public void mergedBubbleSortBgnToSortedArray() {
        analyzer.mergedBubbleSortBgnToSortedArray();
    }

    @Test(timeout = 3000)
    public void mergedBubbleSortEndToSortedArray() {
        analyzer.mergedBubbleSortEndToSortedArray();
    }

    @Test(timeout = 3000)
    public void mergedQuickSortToSortedArray() {
        analyzer.mergedQuickSortToSortedArray();
    }

    @Test(timeout = 3000)
    public void mergedUtilitySortToSortedArray() {
        analyzer.mergedUtilitySortToSortedArray();
    }

    // sorters test

    @Test(expected = NullPointerException.class)
    public void bubbleSorterBgnTest(){
        BubbleSorterBgn bubbleSorterBgn = new BubbleSorterBgn();
        bubbleSorterBgn.sort(null);
    }

    @Test(timeout = 50000)
    public void bubbleSorterBgnTest2(){
        BubbleSorterBgn bubbleSorterBgn = new BubbleSorterBgn();
        bubbleSorterBgn.sort(Filler.generateRandomlyFilledArray(99999));
    }

    @Test(expected = NullPointerException.class)
    public void bubbleSorterEndTest(){
        BubbleSorterEnd bubbleSorterEnd = new BubbleSorterEnd();
        bubbleSorterEnd.sort(null);
    }

    @Test(timeout = 50000)
    public void bubbleSorterEndTest2(){
        BubbleSorterEnd bubbleSorterEnd = new BubbleSorterEnd();
        bubbleSorterEnd.sort(Filler.generateRandomlyFilledArray(99999));
    }

    @Test(expected = NullPointerException.class)
    public void quickSorterTest(){
        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sort(null);
    }

    @Test(timeout = 3000)
    public void quickSorterTest2(){
        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sort(Filler.generateRandomlyFilledArray(99999));
    }

    @Test(expected = NullPointerException.class)
    public void utilitySorterTest(){
        UtilitySorter utilitySorter = new UtilitySorter();
        utilitySorter.sort(null);
    }

    @Test(timeout = 3000)
    public void utilitySorterTest2(){
        UtilitySorter utilitySorter = new UtilitySorter();
        utilitySorter.sort(Filler.generateRandomlyFilledArray(99999));
    }

    // Merged sorters test

    @Test(expected = NullPointerException.class)
    public void mergedBubbleSorterBgnTest(){
        MergedBubbleSorterBgn mergedBubbleSorterBgn = new MergedBubbleSorterBgn();
        mergedBubbleSorterBgn.sort(null);
    }

    @Test(timeout = 10000)
    public void mergedBubbleSorterBgnTest2(){
        MergedBubbleSorterBgn mergedBubbleSorterBgn = new MergedBubbleSorterBgn();
        mergedBubbleSorterBgn.sort(Filler.generateRandomlyFilledArray(99999));
    }

    @Test(expected = NullPointerException.class)
    public void mergedBubbleSorterEndTest(){
        MergedBubbleSorterEnd mergedBubbleSorterEnd = new MergedBubbleSorterEnd();
        mergedBubbleSorterEnd.sort(null);
    }

    @Test(timeout = 10000)
    public void mergedBubbleSorterEndTest2(){
        MergedBubbleSorterEnd mergedBubbleSorterEnd = new MergedBubbleSorterEnd();
        mergedBubbleSorterEnd.sort(Filler.generateRandomlyFilledArray(99999));
    }

    @Test(expected = NullPointerException.class)
    public void mergedQuickSorterTest(){
        MergedQuickSorter mergedQuickSorter = new MergedQuickSorter();
        mergedQuickSorter.sort(null);
    }

    @Test(timeout = 3000)
    public void mergedQuickSorterTest2(){
        MergedQuickSorter mergedQuickSorter = new MergedQuickSorter();
        mergedQuickSorter.sort(Filler.generateRandomlyFilledArray(99999));
    }

    @Test(expected = NullPointerException.class)
    public void mergedUtilitySorterTest(){
        MergedUtilitySorter mergedUtilitySorter = new MergedUtilitySorter();
        mergedUtilitySorter.sort(null);
    }

    @Test(timeout = 3000)
    public void mergedUtilitySorterTest2(){
        MergedUtilitySorter mergedUtilitySorter = new MergedUtilitySorter();
        mergedUtilitySorter.sort(Filler.generateRandomlyFilledArray(99999));
    }
}
