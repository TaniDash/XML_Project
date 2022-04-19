package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage extends BasePage {
	WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[3]") WebElement EXPORT_ELEMENT;
	@FindBy(how=How.XPATH, using="//a[@class='btn btn-success']") WebElement ADD_CUSTOMER_ON_LISTCUSTOMER_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"foo_filter\"]") WebElement SEARCH_ON_LISTCUSTOMER_PAGE_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CONTACT_ELEMENT;
	
	
	public void verifyListCustomerPage() {
		Assert.assertEquals(EXPORT_ELEMENT.getText(), "Export", "Wrong!");
	}
	
	public void clickAddCustomerOnListCustomer() {
		waitForElement(driver, 10, ADD_CUSTOMER_ON_LISTCUSTOMER_ELEMENT);
		ADD_CUSTOMER_ON_LISTCUSTOMER_ELEMENT.click();		
	}
	
	public void verifyAddContactPage() {
		Assert.assertEquals(ADD_CONTACT_ELEMENT.getText(), "Add Contact", "Wrong page!");
	}
	
	public void insertSearchBarOnListCustomer(String newName) {
			SEARCH_ON_LISTCUSTOMER_PAGE_ELEMENT.sendKeys(newName);
	}

	//tbody/tr[1]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[1]//i[@class='fa fa-search']
	
	public void verifyEnteredNameAndSearchProfile(String addedName) {
		String before_Xpath= "//tbody/tr[";
		String after_Xpath="]/td[3]";
		String after_profileIcon="]/following-sibling::td[4]/a[1]//i[@class='fa fa-search']";
		
		for(int i=2; i<=5; i++) {
			String name1= driver.findElement(By.xpath(before_Xpath+i+after_Xpath)).getText();
			if(name1.contains(addedName)) {
				System.out.println("Generated name exists!");
				driver.findElement(By.xpath(before_Xpath+i+after_profileIcon)).click();
			}
		}
	}
	
}
