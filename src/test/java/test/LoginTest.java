package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;
	
	
	@Test
	@Parameters({"UserName", "Password"})
	public void validUserShouldBeAbleToLogin(String userName, String password) {
		driver= BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUsername(userName);
		login.insertPassword(password);
		login.clickSignin();
		
		
	}
	
}
