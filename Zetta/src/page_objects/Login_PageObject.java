package page_objects;

import org.openqa.selenium.By;

public class Login_PageObject {
	

	public static By username_txt_box  =  By.id("userId"); 
	
	public static By password_txt_box = By.id("password");
	
	public static By login_button = By.xpath("//button[@type = 'submit']");
	
	public static By agentname = By.xpath(".//*[@id='navbar-container']/div[2]/ul/li[2]/a/span/b");
	
	public static By logout_object = By.linkText("Log Out");
	
}
