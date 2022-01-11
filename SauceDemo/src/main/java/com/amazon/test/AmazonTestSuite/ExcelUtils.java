package com.amazon.test.AmazonTestSuite;

import java.io.FileInputStream;
import java.nio.file.Paths;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends BaseClass {

	

	public static XSSFSheet ExcelWSheet;

	public static XSSFWorkbook ExcelWBook;

	public static XSSFCell Cell;

	public static XSSFRow Row;
	
//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method



//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(String SheetName,int RowNum, int ColNum) throws Exception{

		try{
			FileInputStream ExcelFile = new FileInputStream(Paths.get(".").toAbsolutePath().normalize().toString()+"/Resources/DataSheet.xlsx");

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

			}catch (Exception e){

			return"";

			}

}

//This method is to write in the Excel cell, Row num and Col num are the parameters


	
	
}