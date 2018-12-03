package output;

import analyzer.ReflectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sorters.AbstractSorter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Vovk
 */

public class ExcelWriter {
    @SuppressWarnings("deprecation")
    public void writeIntoExcel() {

        try{
            Workbook book = new XSSFWorkbook();
            ReflectionUtils reflectionUtils = new ReflectionUtils();
            final int ARRAY_SIZE1 = 1000;
            final int ARRAY_SIZE2 = 10000;
            final int ARRAY_SIZE3 = 50000;
            for (Method method : reflectionUtils.findAnnotatedMethods()) {
                Sheet sheet = book.createSheet(reflectionUtils.getAnnotationParam(method));
                sheet.autoSizeColumn(30);

                Row firstRow = sheet.createRow(0);
                Row secondRow = sheet.createRow(1);
                Row thirdRow = sheet.createRow(2);
                Row fourthRow = sheet.createRow(3);
                Row fifthRow = sheet.createRow(4);

                Cell sorterNameTitle = firstRow.createCell(1);
                Cell arraySize = secondRow.createCell(0);
                Cell firstElementsAmount = thirdRow.createCell(0);
                Cell secondElementsAmount = fourthRow.createCell(0);
                Cell thirdElementsAmount = fifthRow.createCell(0);

                sorterNameTitle.setCellValue("SORTER NAME");
                arraySize.setCellValue("ARRAY SIZE");
                firstElementsAmount.setCellValue(ARRAY_SIZE1);
                secondElementsAmount.setCellValue(ARRAY_SIZE2);
                thirdElementsAmount.setCellValue(ARRAY_SIZE3);
                int i = 1;
                for (Class<? extends AbstractSorter> subType : reflectionUtils.findSubclasses()) {
                    if (!subType.toString().contains("Abstract")) {
                        Cell sorterName = secondRow.createCell(i);
                        sorterName.setCellValue(reflectionUtils.getAnnotationParam(subType));
                        int[] array1 = reflectionUtils.fillThroughReflection(method.toString(), ARRAY_SIZE1);
                        int[] array2 = reflectionUtils.fillThroughReflection(method.toString(), ARRAY_SIZE2);
                        int[] array3 = reflectionUtils.fillThroughReflection(method.toString(), ARRAY_SIZE3);
                        Cell firstSortTime = thirdRow.createCell(i);
                        firstSortTime.setCellValue(reflectionUtils.getSortTime(array1, subType));
                        Cell secondSortTime = fourthRow.createCell(i);
                        secondSortTime.setCellValue(reflectionUtils.getSortTime(array2, subType));
                        Cell thirdSortTime = fifthRow.createCell(i);
                        thirdSortTime.setCellValue(reflectionUtils.getSortTime(array3, subType));
                        i++;

                    }
                }
                for(int k = 0; k < 9; k++) {
                    sheet.autoSizeColumn(k);
                }
            }
            book.write(new FileOutputStream("generated.xlsx"));
            book.close();
        }
        catch (IOException exception) {
            System.out.println(exception);
        }


    }

    public static void main(String[] args) {
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.writeIntoExcel();
    }
}
