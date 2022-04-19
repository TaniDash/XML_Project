package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class CustomerProfilePage extends BasePage {
	WebDriver driver;
	
	public CustomerProfilePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"summary\"]") WebElement SUMMARY_ELEMENT;
	
	
	public void verifyNewCustomerProfile() {
		waitForElement(driver, 5, SUMMARY_ELEMENT);
		Assert.assertEquals(SUMMARY_ELEMENT.getText(), "Summary", "Wrong page!");
		System.out.println(SUMMARY_ELEMENT.getText());
	}
	
}
