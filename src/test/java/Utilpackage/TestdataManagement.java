package Utilpackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestdataManagement {
	
	public static Object[][] readexceldata() throws IOException{
		
	String f="D:\\Readdata1.xlsx";
		FileInputStream fs=new FileInputStream(f);
		
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		
		Sheet sheet=workbook.getSheet("Credential_details");
		int rowcount=sheet.getPhysicalNumberOfRows();
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowcount][colcount];
		for( int i=0;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		 workbook.close();
		    fs.close();

		    
		    return data;
		
		
	}

}
