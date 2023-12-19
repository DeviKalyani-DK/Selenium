package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import base.BaseClass;

public class Excel extends BaseClass{
	
	@Test
	public void excelRead() throws Throwable {
	
		File f=new File("C:\\Users\\admin\\Documents\\PracticeExcel.xlsx");
		FileInputStream fin=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		
		
		System.out.println("No of sheets: "+wb.getNumberOfSheets());
		for(int i=0;i<wb.getNumberOfSheets();i++) {
			System.out.println("Sheets: "+ wb.getSheetName(i));
		}
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("Rows: "+rows);
		
		int cells=sheet.getRow(1).getLastCellNum();
		System.out.println("Celss: "+cells);
		
		for(int i=1;i<rows;i++){
			for(int j=0;j<cells;j++) {
				DataFormatter df=new DataFormatter();
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
			}
			System.out.println();
		}
		
		wb.close();
		fin.close();
		
	}

}
