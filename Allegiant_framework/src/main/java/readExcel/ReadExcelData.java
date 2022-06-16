package readExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcelData {
	
	public static String[][] getExcelData(String testSheetName) throws IOException {
		String fileLocation = "C:\\Users\\nmadhanagopal\\eclipse-workspace\\Framework3\\Resources\\Data_Sheet.xlsx";
		String [] [] data = null;
		
		XSSFWorkbook workbook=new XSSFWorkbook(fileLocation);
		int sheets=workbook.getNumberOfSheets();

		
				XSSFSheet sheet;
				for (int i = 0; i < sheets; i++) {
					if(workbook.getSheetName(i).equalsIgnoreCase(testSheetName)) {
						sheet = workbook.getSheetAt(i);	
					
				int lastRowNum = sheet.getLastRowNum();
				int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
				System.out.println(lastRowNum);
				System.out.println(physicalNumberOfRows);
				short lastCellNum = sheet.getRow(0).getLastCellNum();
				System.out.println(lastCellNum);
				data = new String [lastRowNum] [lastCellNum];
				for (int j = 1; j <=lastRowNum; j++) {
					XSSFRow row = sheet.getRow(j);
					for (int k = 0; k < lastCellNum; k++) {
						XSSFCell cell = row.getCell(k);
						DataFormatter dft= new DataFormatter();
						String value= dft.formatCellValue(cell);
                        data [j-1] [k] = value;
					} 
				}
				
				}
							
				}
				workbook.close();
				return data;		
				
	}

}
