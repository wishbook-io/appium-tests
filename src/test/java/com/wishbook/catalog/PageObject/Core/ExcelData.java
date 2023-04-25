package com.wishbook.catalog.PageObject.Core;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelData {
    public static String getData(String path, String sheetName, int rowNumber,int cellNumber) throws Exception {

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet(sheetName);
            Row row = sh.getRow(rowNumber);
            String data = row.getCell(cellNumber).getStringCellValue();
            System.out.println(data);
            return data;


        }
        catch (Exception e) {
            return "";
        }

    }

}

