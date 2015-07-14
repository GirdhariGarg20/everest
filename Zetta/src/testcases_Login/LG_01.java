package testcases_Login;


import modules.Login_Module;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import page_objects.BaseClass;
import page_objects.Login_PageObject;
import utility.Constants;
import utility.Exceldata;
import utility.JyperionListener;
import utility.Log;
import utility.Utills;

@Listeners(JyperionListener.class)
public class LG_01 {
	WebDriver driver;
	String sTestCaseName, sheet, username, password;
	int iTestCaseRow;

	@BeforeTest
	public void before() throws Exception {
		iTestCaseRow = Utills.beforeTest(this.toString());

	}

	@Test
	public void main() {
		try {
			Login_Module.signin(iTestCaseRow);
			Assert.assertEquals(Utills.object(Login_PageObject.agentname), "Sumit Tamhane, Agent");
		} catch (Exception e) {
			Log.warn("package testcases.testcases_Login|| Class LG_01 ||Method main"
					+ e.getMessage());
		}

	}

	@AfterTest
	public void after() {
		Log.endTestCase();
		Utills.close();
	}
}
