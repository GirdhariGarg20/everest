package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fs;
	public static FileOutputStream fos;
	public static String cellvalue, cellvalue1 ;
	
	//public String filepath;
	public static int TCid = Constants.TestCaseID;
	public static int result = Constants.Result;
	
	public static void setpath(String filepath,String sheetname){
		try{
		fs = new FileInputStream(filepath);
		workbook =  new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetname);
		
		}catch(IOException e){
			Log.error("Package utility || class Exceldata || Method setpath "+e.getMessage());
		}
	}
	
	public static String getCellData(int iTestCaseRow , int colnum) throws Exception{
		try{
			
			cell = sheet.getRow(iTestCaseRow).getCell(colnum);
			switch(cell.getCellType()){
			
			case XSSFCell.CELL_TYPE_NUMERIC:
				 cellvalue = cell.getRawValue();
				 break;
			case XSSFCell.CELL_TYPE_STRING :
				cellvalue = cell.getStringCellValue();
			break;
			case XSSFCell.CELL_TYPE_BLANK :
				cellvalue = "";
			break;
			case XSSFCell.CELL_TYPE_BOOLEAN :
				boolean bool = cell.getBooleanCellValue();
			break;
			default : Log.warn("Excel data type does not exist");
			}
		return cellvalue;
		}catch(Exception e){
			Log.error("Package utility || class Exceldata || Method getCellData "+e.getMessage());
			throw(e);
		}
		
		
	}

public static void setCellData(String filepath, String Result, int iTestCaseRow, String sTestCaseName ){
	try{
	row = sheet.getRow(iTestCaseRow);
	cell = row.getCell(result, Row.RETURN_BLANK_AS_NULL);
	if(cell == null){
		
		cell = row.createCell(result);
		cell.setCellValue(Result);
	}else {
		cell.setCellValue(Result);
	}
	//
	FileOutputStream fos = new FileOutputStream(filepath);
	workbook.write(fos);
	fos.flush();
	fos.close();
	
	}catch(Exception e ){
		Log.error("package utility || Class Exceldata || Method setCellData "+ e.getMessage());
	}
}

public static int getRowContains(String sTestCaseName, int colnum ) throws Exception{
	int i;
	try{
		int rowcount = sheet.getLastRowNum();
		for(i = 1; i<=rowcount;i++){
			if(Exceldata.getCellData(i, colnum).contains(sTestCaseName)){
				break;
			}
		}
		return i;
	}catch(Exception e){
		Log.error("Package utility || class Exceldata || Method getRowContains "+e.getMessage());
		throw (e);
	}
	
}


@SuppressWarnings("null")
public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception

{  

String[][] tabArray = null;

try{

FileInputStream ExcelFile = new FileInputStream(FilePath);

// Access the required test data sheet

workbook = new XSSFWorkbook(ExcelFile);

sheet = workbook.getSheet(SheetName);



int startCol = 7;

int ci=0,cj=0;

//int totalRows = sheet.getLastRowNum();

int totalCols = 8 ;

tabArray=new String[1][2];
tabArray[ci][cj]=Exceldata.getCellData(1, 7);
System.out.print(tabArray[ci][cj]);
for (int j=startCol;j<=totalCols;j++, cj++)

{

//tabArray[ci][cj]=Exceldata.getCellData(1, 7);

//System.out.print(tabArray[ci][cj]);


}

}

catch (FileNotFoundException e)

{

System.out.println("Could not read the Excel sheet");

e.printStackTrace();

}

catch (IOException e)

{

System.out.println("Could not read the Excel sheet");

e.printStackTrace();

}

return(tabArray);

}

	
}
