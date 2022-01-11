package com.sauce.test.GoogleSearch;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFSheet ExcelWSheet;
	static XSSFWorkbook ExcelWBook;
	static XSSFCell Cell;
	static XSSFRow Row;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		projectPath = System.getProperty("user.dir");
		ExcelWBook = new XSSFWorkbook(projectPath + "/Resources/DataSheet.xlsx");
		ExcelWSheet = ExcelWBook.getSheet("sheet1");
	}

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(2, 1);
		getCellDataNumber(2, 1);
	}

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			projectPath = System.getProperty("user.dir");
			ExcelWBook = new XSSFWorkbook(projectPath + "/Resources/DataSheet.xlsx");
			ExcelWSheet = ExcelWBook.getSheet("sheet1");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

	public static void getRowCount() {
		try {
			projectPath = System.getProperty("user.dir");
			ExcelWBook = new XSSFWorkbook(projectPath + "/Resources/DataSheet.xlsx");
			ExcelWSheet = ExcelWBook.getSheet("sheet1");
			ExcelWSheet.getPhysicalNumberOfRows();
			int rowCount = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows: " + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	// This method is to read the test data from the Excel cell,
	// passing parameters as Row num and Col num

	public static void getCellDataString(int rowNum, int colNum) {

		try {
			projectPath = System.getProperty("user.dir");
			ExcelWBook = new XSSFWorkbook(projectPath + "/Resources/DataSheet.xlsx");
			ExcelWSheet = ExcelWBook.getSheet("sheet1");
			String cellData = ExcelWSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

	public static void getCellDataNumber(int rowNum, int colNum) {

		try {
			double cellData = ExcelWSheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		
	}
}