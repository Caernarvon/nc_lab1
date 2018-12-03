package analyzer;

import fillers.FillMethod;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import sorters.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author Vovk
 */

public class ReflectionUtils {

    /**
     * Method allows to fill array using set of marked methods with {@code FillMethod}.
     * <p> In reference to Reflections API{@see reflections.Reflections} if method is
     * static than first arg should be null.
     *
     * @param methodName method name which will be used to fill.
     * @param ARRAY_SIZE size of array
     */
    public int[] fillThroughReflection(String methodName, int ARRAY_SIZE) {
        int[] array = new int[ARRAY_SIZE];
        for (Method anAnnotatedMethod : findAnnotatedMethods()) {
            if (anAnnotatedMethod.toString().contains(methodName)) {
                try {
                    array = (int[]) anAnnotatedMethod.invoke(null, array.length);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return array;
    }

    /**
     * Method returns set of {@code AbstractSorter} subtypes placed in
     * sorters package.
     */
    public Set<Class<? extends AbstractSorter>> findSubclasses() {
        Reflections reflections = new Reflections("sorters", org.reflections.ReflectionUtils.class.getClassLoader(),
                new SubTypesScanner(false));
        return reflections.getSubTypesOf(AbstractSorter.class);
    }

    /**
     * Method returns set of marked methods with {@code FillMethod}.
     * <p> Method is using reflection api to get set of marked methods.
     */
    public  Set<Method> findAnnotatedMethods() {
        Reflections reflections = new Reflections("fillers", MethodAnnotationsScanner.class);
        return reflections.getMethodsAnnotatedWith(FillMethod.class);
    }

    public String getAnnotationParam(Method method) {
        String methodName = "Check method annotation";
        if (method.isAnnotationPresent(FillMethod.class)) {
            FillMethod ta = method.getAnnotation(FillMethod.class);
            methodName = ta.name();
        }
        return methodName;
    }

    public static String getAnnotationParam(Class<? extends AbstractSorter> clas) {
        String className = "Check class annotation";
        SorterName annotation = clas.getAnnotation(SorterName.class);
        if (annotation != null) {
            return annotation.name();
        }
        return className;
    }

    /**
     * Calculating time that required to sort any given types of array.
     *
     * <p>Method takes any of {@code AbstractSorter} subtypes, that's gives a some flexibility
     * while using this method.
     *
     * @param array   array to work with.
     * @param subType subtype of AbstractSorter.
     *                //@param className class name to find class.
     */
    public long getSortTime(int[] array, Class<? extends AbstractSorter> subType) {
        long start = 0;
        long end = 0;
        if (!subType.toString().contains("Abstract")) {
            start = System.nanoTime();
            doSort(subType, findClass(subType), array);
            end = System.nanoTime();
        }
        return end - start;
    }

    private void doSort(Class<? extends AbstractSorter> subType, AbstractSorter abstractSorter, int[] array) {
        try {
            Method method = subType.getMethod("sort", int[].class);
            method.invoke(abstractSorter, array);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private AbstractSorter findClass (Class<? extends AbstractSorter> subType){
        BubbleSorterBgn bubbleSorterBgn = new BubbleSorterBgn();
        if(getAnnotationParam(subType).equals(bubbleSorterBgn.toString())){
            return bubbleSorterBgn;
        }
        BubbleSorterEnd bubbleSorterEnd = new BubbleSorterEnd();
        if(getAnnotationParam(subType).equals(bubbleSorterEnd.toString())){
            return bubbleSorterEnd;
        }
        MergedBubbleSorterBgn mergedBubbleSorterBgn = new MergedBubbleSorterBgn();
        if(getAnnotationParam(subType).equals(mergedBubbleSorterBgn.toString())){
            return mergedBubbleSorterBgn;
        }
        MergedBubbleSorterEnd mergedBubbleSorterEnd = new MergedBubbleSorterEnd();
        if(getAnnotationParam(subType).equals(mergedBubbleSorterEnd.toString())){
            return mergedBubbleSorterEnd;
        }
        QuickSorter quickSorter = new QuickSorter();
        if(getAnnotationParam(subType).equals(quickSorter.toString())){
            return quickSorter;
        }
        MergedQuickSorter mergedQuickSorter = new MergedQuickSorter();
        if(getAnnotationParam(subType).equals(mergedQuickSorter.toString())){
            return mergedQuickSorter;
        }
        UtilitySorter utilitySorter = new UtilitySorter();
        if(getAnnotationParam(subType).equals(utilitySorter.toString())){
            return utilitySorter;
        }
        MergedUtilitySorter mergedUtilitySorter = new MergedUtilitySorter();
        if(getAnnotationParam(subType).equals(mergedUtilitySorter.toString())){
            return mergedUtilitySorter;
        }
        else {
            return null;
        }
    }
}
