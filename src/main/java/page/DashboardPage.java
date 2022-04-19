package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_MENU_ELEMENT;

	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_MENU_ELEMENT;
	

	public void verifyDashboardHeader() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Wrong page!");
		System.out.println(DASHBOARD_HEADER_ELEMENT.getText());
	}
	
	public void clickCustomerMenu() {
		CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickaddCustomerMenu() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
		}
	
	public void clickListCustomerMenu() {
		LIST_CUSTOMER_MENU_ELEMENT.click();
	}
	
}
