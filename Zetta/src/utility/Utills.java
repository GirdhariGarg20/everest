package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import page_objects.BaseClass;

import com.steadystate.css.util.Output;

public class Utills extends BaseClass {
	public static int iTestCaseRow;
	public static WebElement element ; 
	public Utills(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//public static WebDriver driver;

	public static WebDriver openBrowser() {

		String browser = Constants.browser;
		String url = Constants.URL;

		switch (browser) {

		case "firfox":
			ProfilesIni ini = new ProfilesIni(); 
			FirefoxProfile profile = ini.getProfile("Zetta_Profile");
			driver = new FirefoxDriver(profile);
		break;
		
		}
		driver.get(url);
		return driver;
		
	}
	
	public static void takeScreenshot(String sTestCaseName){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(Constants.screenshot_path+sTestCaseName+".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static String  getTestCasename(String sTestCaseName){
		int posi;
		try{
			posi = sTestCaseName.indexOf("@");
			sTestCaseName = sTestCaseName.substring(0, posi);
			System.out.println(sTestCaseName);
			posi = sTestCaseName.lastIndexOf(".");
			sTestCaseName = sTestCaseName.substring(posi+1);
			System.out.println(sTestCaseName);
			return sTestCaseName;
			
		}catch(Exception e){
			Log.error("Package Utility|| class Utills|| Method geTestCaseName||"+e.getMessage());
			throw(e);
		}
	}

	public static String getSheetName(String sTestCaseName){
		String value = sTestCaseName, sheet = null;
		
		try{
			int posi= value.indexOf("_");
			 value = value.substring(0, posi);
			 switch(value){
			 case "LG":
				 sheet =  "Login";
			 break;
			 default : Log.warn("Please specify a sheetname");
			 }
			return sheet;
		}catch(Exception e){
			Log.error("Package Utility|| class Utills|| Method getSheetName||"+e.getMessage());
			throw(e);
		}
		
	}

	

	
	public static int beforeTest(String sTestCaseName) throws Exception{
		String sheet;
		
		try{
			DOMConfigurator.configure("log4j.xml");
			
			sTestCaseName = Utills.getTestCasename(sTestCaseName);
			
			
			Log.startTestCase(sTestCaseName);
			
			sheet = Utills.getSheetName(sTestCaseName);
			
			
			Exceldata.setpath(Constants.excelpath+Constants.datafile, sheet);
			
			iTestCaseRow = Exceldata.getRowContains(sTestCaseName, Constants.TestCaseID);
			
			driver = Utills.openBrowser();
			new BaseClass(driver);
			
			return iTestCaseRow;
		}catch(Exception e){
			Log.error("Package utility || Class Utills || Method before Test"+e.getMessage());
			throw(e);
				}
			
	}
		

public static String take(String sheet, String logical_name) throws Exception{
	int ilogicalrow;
	Exceldata.setpath(Constants.excelpath+Constants.locator_filename, sheet);
	
	ilogicalrow = Exceldata.getRowContains(logical_name, Constants.logical_name);
	String dd = Exceldata.getCellData(ilogicalrow, Constants.locator_path);
	System.out.println(dd);
	return dd;
}

public static WebElement object(By selector){
	
	element = driver.findElement(selector);
	return element;
	
}

public static void close() {
	
	driver.close();

	
}

}
