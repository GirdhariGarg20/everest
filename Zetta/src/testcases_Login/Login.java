package testcases_Login;

import modules.Login_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bsh.BshClassManager.Listener;
import page_objects.BaseClass;
import utility.DataProviderClass;
import utility.Exceldata;
import utility.TestReport;
import utility.Utills;

@Listeners(value = TestReport.class)
public class Login {
	/*public static WebDriver driver;
	@BeforeClass
	public void beforeclass(){
	// driver = Utills.openBrowser();
	 new BaseClass(driver);
	}
	@BeforeMethod
	public void beforemethod(){
		
	}*/
	
	@Test(dataProvider  = "Login_data", dataProviderClass = DataProviderClass.class)
	
	public void main(String username, String password) throws Exception{
		Reporter.log("Enter Username and Password");
		//System.out.println(username+"  "+password);
		//Login_Module.signin();
		//Exceldata.setpath("C:\\Users\\824671\\workspace\\Zetta\\src\\testdata\\Exceldata.xlsx", "Login");
		//System.out.println("setpath done");
		//String data  = Exceldata.getCellData(2, 8);
		//System.out.println(data);
		
		Utills.take("Login","username text box");
		
		
		
		
	}
}
