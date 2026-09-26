package utils;



import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private static final String path1  =
            "src/test/resources/testdata/LoginData.xlsx";

    public static Object[][] getExcelData(String sheetName) {

        try (FileInputStream fis = new FileInputStream(path1);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][columnCount];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < columnCount; j++) {

                    data[i - 1][j] =
                            formatter.formatCellValue(
                                    sheet.getRow(i).getCell(j));
                }
            }

            return data;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to read Excel file: " + path1, e);
        }
    }
}