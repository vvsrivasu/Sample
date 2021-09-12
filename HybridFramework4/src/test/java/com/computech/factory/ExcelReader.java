package com.computech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell col;
	public ExcelReader() {
		try {
			wb = new XSSFWorkbook(new FileInputStream(
					new File("F:\\Workspace_Weekend\\HybridFramework\\TestData\\ApplicationData.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ExcelReader(String excelFilePath) {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(excelFilePath)));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public int rowsCount(String sheetName) {
		
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
		/*sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		return rows;*/
	}
	public int colsCount(String sheetName, int rowNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getPhysicalNumberOfCells();
	}
	public String  getStringData(String sheetName, int rowNo, int colNo) {
		/*sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		col = row.getCell(colNo);
		String value = col.getStringCellValue();
		return value;*/
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
	}

	public String getStringData(int sheetIndex, int rowNo, int colNo) {
		return wb.getSheetAt(sheetIndex).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public static void app() {
		
	}
	public int getIntegerData(String sheetName, int rowNo, int colNo) {
		return (int) wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}

	public double getDoubleData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}
	public boolean getBooleanData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getBooleanCellValue();
	}
}
