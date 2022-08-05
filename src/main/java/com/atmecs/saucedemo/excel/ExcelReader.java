package com.atmecs.saucedemo.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.atmecs.saucedemo.constants.FilePathConstants;

public class ExcelReader {

	@DataProvider
	public String[][] getExcelData() throws IOException {
		File excelFile = new File(FilePathConstants.EXCEL_DATA);
		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int noofRows = sheet.getPhysicalNumberOfRows();
		int noofColumns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noofRows - 1][noofColumns];
		for (int row = 0; row < noofRows - 1; row++) {
			for (int colum = 0; colum < noofColumns; colum++) {
				data[row][colum] = sheet.getRow(row + 1).getCell(colum).getStringCellValue();
			}
		}
		workbook.close();
		fis.close();
		return data;
	}

}
