package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {

    public static final long WAIT_FOR_PAGE_LOAD = 30;

    public static final Logger LOGGER = Logger.getLogger(TestUtil.class.getName());

    public static String DATA_FILE_PATH = "test-data/dataFile.xlsx";
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static Row row;
    public static Cell cell;

    public static Object[][] getDataFromExcel(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(DATA_FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum() - 1];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum() - 1; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}
