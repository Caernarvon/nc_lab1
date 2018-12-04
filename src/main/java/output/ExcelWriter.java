package output;

import analyzer.ReflectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import sorters.AbstractSorter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Vovk
 */

public class ExcelWriter {
    @SuppressWarnings("deprecation")
    public void writeIntoExcel() {
        try{
            XSSFWorkbook book = new XSSFWorkbook();
            ReflectionUtils reflectionUtils = new ReflectionUtils();
            final int ARRAY_SIZE1 = 100;
            final int ARRAY_SIZE2 = 1000;
            final int ARRAY_SIZE3 = 5000;
            for (Method method : reflectionUtils.findAnnotatedMethods()) {
                XSSFSheet sheet = book.createSheet(reflectionUtils.getAnnotationParam(method));
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
                printChart(sheet);
            }
            book.write(new FileOutputStream("generated.xlsx"));
            book.close();
        }
        catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void printChart(XSSFSheet sheet) {
        /* At the end of this step, we have a worksheet with test data, that we want to write into a chart */
        /* Create a drawing canvas on the worksheet */
        XSSFDrawing xlsx_drawing = sheet.createDrawingPatriarch();
        /* Define anchor points in the worksheet to position the chart */
        XSSFClientAnchor anchor = xlsx_drawing.createAnchor(0, 0, 0, 0, 0, 6, 10, 27);
        /* Create the chart object based on the anchor point */
        XSSFChart my_line_chart = xlsx_drawing.createChart(anchor);
        /* Define legends for the line chart and set the position of the legend */
        XSSFChartLegend legend = my_line_chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.TOP_RIGHT);
        /* Create data for the chart */
        LineChartData data = my_line_chart.getChartDataFactory().createLineChartData();
        /* Define chart AXIS */
        ChartAxis bottomAxis = my_line_chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = my_line_chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        /* Define Data sources for the chart */
        /* Set the right cell range that contain values for the chart */
        /* Pass the worksheet and cell range address as inputs */
        /* Cell Range Address is defined as First row, last row, first column, last column */
        ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 0, 0));
        ChartDataSource<Number> xs1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 1, 1));
        ChartDataSource<Number> xs2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 2, 2));
        ChartDataSource<Number> xs3 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 3, 3));
        ChartDataSource<Number> xs4 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 4, 4));
        ChartDataSource<Number> xs5 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 5, 5));
        ChartDataSource<Number> xs6 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 6, 6));
        ChartDataSource<Number> xs7 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 7, 7));
        ChartDataSource<Number> xs8 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 4, 8, 8));
        /* Add chart data sources as data to the chart */

        LineChartSeries series1 = data.addSeries(ys, xs1);
        series1.setTitle("UtilitySorter");
        LineChartSeries series2 = data.addSeries(ys, xs2);
        series2.setTitle("BubbleSorterEnd");
        LineChartSeries series3 = data.addSeries(ys, xs3);
        series3.setTitle("MergedBubbleSorterBgn");
        LineChartSeries series4 = data.addSeries(ys, xs4);
        series4.setTitle("MergedBubbleSorterEnd");
        LineChartSeries series5 = data.addSeries(ys, xs5);
        series5.setTitle("MergedQuickSorter");
        LineChartSeries series6 = data.addSeries(ys, xs6);
        series6.setTitle("BubbleSorterBgn");
        LineChartSeries series7 = data.addSeries(ys, xs7);
        series7.setTitle("QuickSorter");
        LineChartSeries series8 = data.addSeries(ys, xs8);
        series8.setTitle("MergedUtilitySorter");

        /* Plot the chart with the inputs from data and chart axis */
        my_line_chart.plot(data, bottomAxis, leftAxis);
    }

    public static void main(String[] args) {
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.writeIntoExcel();
    }
}
