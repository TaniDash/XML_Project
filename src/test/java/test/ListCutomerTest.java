package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerOnListCustomerPage;
import page.AddCustomerPage;
import page.CustomerProfilePage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCutomerTest {

	WebDriver driver;
	
	@Test
	@Parameters({"UserName", "Password", "FullName", "Company", "Email", "Phone", "Address", "City", "State", "Zip", "Country"})
	public void validUserShouldBeAbleToAddCutomerOnListCustomer(String userName, String password, String fullname, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUsername(userName);
		login.insertPassword(password);
		login.clickSignin();
	
		DashboardPage dashboard= PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboardHeader();
		dashboard.clickCustomerMenu();
		dashboard.clickListCustomerMenu();
		
		ListCustomerPage listCustomerPage =PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.clickAddCustomerOnListCustomer();
		
		
		AddCustomerOnListCustomerPage addCustomerOnListCustomerPage= PageFactory.initElements(driver, AddCustomerOnListCustomerPage.class);
		addCustomerOnListCustomerPage.verifyAddContactPage();
		String generatedName= addCustomerOnListCustomerPage.insertFullname(fullname);
		addCustomerOnListCustomerPage.selectCompanyFromDropdwon(company);
		addCustomerOnListCustomerPage.insertPhoneNum(phone);
		addCustomerOnListCustomerPage.insertAddress(address);
		addCustomerOnListCustomerPage.insertCity(city);
		addCustomerOnListCustomerPage.insertState(state);
		addCustomerOnListCustomerPage.insertZip(zip);
		addCustomerOnListCustomerPage.selectCountryFromDropdwon(country);
		addCustomerOnListCustomerPage.clickSubmitButton();
		
		
		CustomerProfilePage customerProfilePage= PageFactory.initElements(driver, CustomerProfilePage.class);
		customerProfilePage.verifyNewCustomerProfile();
		
		dashboard.clickListCustomerMenu();
		listCustomerPage.verifyListCustomerPage();
		listCustomerPage.insertSearchBarOnListCustomer(generatedName);
		listCustomerPage.verifyEnteredNameAndSearchProfile(generatedName);
		
		
	

	
	
	}	
}
