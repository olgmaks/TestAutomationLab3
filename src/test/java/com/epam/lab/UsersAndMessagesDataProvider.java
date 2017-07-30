package com.epam.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import com.epam.lab.consts.Constants;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class UsersAndMessagesDataProvider {



    @DataProvider(parallel = true, name = "getExcelData")
    public Object[][] getExcelData() throws FileNotFoundException {
        Object [][] data = null;
        try (InputStream fileStream = new FileInputStream(Constants.PATH_TO_LOGIN_DATA)) {

            XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            data = new Object[sheet.getLastRowNum()][7];
            Iterator rowIterator = sheet.rowIterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                XSSFRow currentRow = (XSSFRow) rowIterator.next();
                Iterator cellIterator = currentRow.cellIterator();
                while (cellIterator.hasNext()) {
                    XSSFCell currentCell = (XSSFCell) cellIterator.next();
                    int rowIndex = currentCell.getRowIndex()-1;
                    int colIndex  = currentCell.getColumnIndex() -1;
                    data[rowIndex][colIndex] = currentCell.getStringCellValue();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
