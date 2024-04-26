package utilities;

import java.io.*;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	XSSFWorkbook workBook = new XSSFWorkbook();
	FileOutputStream fos;
    String filePath = "C:\\Users\\2318566\\Downloads\\ProjectCAS\\ProjectCAS\\testData\\Output.xlsx";
    
    public void sendFirstCountry(String result) {
		 
		  XSSFSheet sheet = workBook.createSheet("Sheet1");

		  XSSFRow row = sheet.createRow(0); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
    	
    public void sendFirstToolTips(List<String> result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");
		  
		  for(int r=1, i=0; r<(1+result.size())&& i<result.size(); r++, i++)
		  {
			  XSSFRow row = sheet.createRow(r); 
			  row.createCell(0).setCellValue(result.get(i));
		  }
		   
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
    
    public void sendSecondCountry(String result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");

		  XSSFRow row = sheet.createRow(29); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
    
    public void sendSecondToolTips(List<String> result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");
		  
		  for(int r=30, i=0; r<(30+result.size())&& i<result.size(); r++, i++)
		  {
			  XSSFRow row = sheet.createRow(r); 
			  row.createCell(0).setCellValue(result.get(i));
		  }
		   
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
    public void sendThirdCountry(String result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");

		  XSSFRow row = sheet.createRow(56); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
    
    public void sendThirdToolTips(List<String> result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");
		  
		  for(int r=57, i=0; r<(57+result.size())&& i<result.size(); r++, i++)
		  {
			  XSSFRow row = sheet.createRow(r); 
			  row.createCell(0).setCellValue(result.get(i));
		  }
		   
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
}
