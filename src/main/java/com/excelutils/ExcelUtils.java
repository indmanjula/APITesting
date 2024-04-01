package com.excelutils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class ExcelUtils {
	
	static String[][] tabArray = null;
    Workbook workbk;
    static int rowCount;
	static int colCount;
	String ExcelPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
			+ "TestData.xls";
	

	
	// Read Excel Sheet Values for Data

		//@DataProvider(name = "dataSource")
		public static Object[][] get_Data(String ExcelPath, String SheetName, int coloums) throws Exception, IOException {

			
			Workbook workbook = Workbook.getWorkbook(new File(ExcelPath));
			Sheet sheet = workbook.getSheet(SheetName);

			int totalRecords = sheet.getRows() - 1;
			int initalPosition = 1;

			Object[][] values = new Object[totalRecords][coloums];

			for (int i = 0; i < totalRecords; i++, initalPosition++) {
				for (int j = 0; j < coloums; j++) {
					values[i][j] = sheet.getCell(j, initalPosition).getContents();
				}
			}

			// String[][] TestData = Arrays.deepToString(values);
			System.out.println("Values are " + values[0][0]);

			workbook.close();
			return values;
		}

}
