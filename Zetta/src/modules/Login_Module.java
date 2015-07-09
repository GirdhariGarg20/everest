package modules;

import page_objects.Login_PageObject;
import utility.Constants;
import utility.Exceldata;
import utility.Log;
import utility.Utills;

public class Login_Module {
	static String username, password;


	public static void signin(int iTestCaseRow) throws Exception{
		username  = Exceldata.getCellData(iTestCaseRow, Constants.parameter1);
		password  = Exceldata.getCellData(iTestCaseRow, Constants.parameter2);
		
		try{
			Utills.object(Login_PageObject.username_txt_box).sendKeys(username);
			Log.info(username + " Entered in Usernamre Field");
		
			Utills.object(Login_PageObject.password_txt_box).sendKeys(password); 
			Log.info(password+" Entered in Password Field");
		
			Utills.object(Login_PageObject.login_button).click();;
			Log.info("Login Button Clicked");
		
		}catch(Exception e){
			Log.error("Package Module || Class Login_Module || Method signin"+e.getMessage());
			throw(e);
				}
			
	}
}
