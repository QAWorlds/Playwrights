package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellValue(String filePath, String sheetName, int row, int col) throws IOException {
       
    	
    	
    	
    	FileInputStream fis = new FileInputStream(filePath);
    	
    	Workbook wb = new XSSFWorkbook(fis);
    	
    	Sheet sheet = wb.getSheet(sheetName);
    	
    	Cell cell = sheet.getRow(row).getCell(col);
    	
    	
    	String value = cell.toString();
    	wb.close();
    	
		return value;
	
    	
    	
    	
    	
    	
           
    	/*FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Cell cell = sheet.getRow(row).getCell(col);

            String value = cell.toString(); // Automatically handles most types as string
            workbook.close();
            return value;

        */
    
}
    
 



}
 