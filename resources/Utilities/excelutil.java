package Utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelutil {

 XSSFWorkbook wb;
 XSSFSheet sh;
 XSSFRow ro;
 XSSFCell cl;
 FileInputStream Fis;
 
 public  readexcel(String sheet,int rownum,int cellnum) throws IOException
{
	

	 try {
	Fis = new FileInputStream("C:/Users/FT-User/Desktop/TESTDATA.xlsx");
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	 wb = new XSSFWorkbook(Fis);
	 sh= wb.getSheet(sheet);
	 ro=sh.getRow(rownum);
	 cl= ro.getCell(cellnum);
	 String str= cl.getStringCellValue();
	 int val=(int) cl.getNumericCellValue();
     Date val1=cl.getDateCellValue();
	return null;
	 
	 
	 
	 
	 


}
	


}
	
	

