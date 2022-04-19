package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.CustomerProfilePage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;

	@Test
	@Parameters({"UserName", "Password", "FullName", "Company", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCutomer(String userName, String password, String fullname, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUsername(userName);
		login.insertPassword(password);
		login.clickSignin();
	
		DashboardPage dashboard= PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardHeader();
		dashboard.clickCustomerMenu();
		dashboard.clickaddCustomerMenu();
		
		AddCustomerPage addCustomerPage= PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullname(fullname);
		addCustomerPage.selectCompanyFromDropdwon(company);
		addCustomerPage.insertPhoneNum(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryFromDropdwon(country);
		addCustomerPage.clickSubmitButton();
		
		CustomerProfilePage customerProfilePage= PageFactory.initElements(driver, CustomerProfilePage.class);
		customerProfilePage.verifyNewCustomerProfile();
		dashboard.clickListCustomerMenu();
		
		ListCustomerPage listCustomerPage =PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.verifyListCustomerPage();
		
		addCustomerPage.verifyEnteredNameAndDelete();

		
		
	}
}
