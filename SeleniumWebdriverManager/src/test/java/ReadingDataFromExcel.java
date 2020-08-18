import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file= new FileInputStream("D:\\eclipse oxygen\\myPractice\\Data.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		
		XSSFSheet sheet= workbook.getSheet("Sheet1"); // providing sheet name
		
		//XSSFSheet sheet= workbook.getSheetAt(0); // providing index name, starting sheet index from 0
		
		int rowcount= sheet.getLastRowNum();
		
		int colcount= sheet.getRow(0).getLastCellNum();
		
		for (int i=0; i<rowcount; i++)
		{
			XSSFRow currentrow= sheet.getRow(i);
			
			for (int j=0; j<colcount;j++)
			{
				String value= currentrow.getCell(j).toString();
						System.out.print("    "    +value);
			}
			System.out.println();
		}
	}

}
