package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"cid\"]") WebElement COMPANY_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how=How.XPATH, using="//select[@name='country']") WebElement COUNTRY_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"submit\"]") WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CONTACT_ELEMENT;
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div/div/div[2]/button[2]") WebElement DELETE_OK_ELEMENT;
	
	
		String insertedName;
		public void insertFullname(String fullname) {
		insertedName= fullname+getRandomNum(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);	
	}
	
		public void selectCompanyFromDropdwon(String company) {
			selectFromDropdown(COMPANY_ELEMENT, company);
	}
		
		public void insertPhoneNum(String phone) {
		String phoneNumber= phone+getRandomNum(999);
		PHONE_ELEMENT.sendKeys(phoneNumber);	
	}
		
		public void insertAddress(String address) {
			ADDRESS_ELEMENT.sendKeys(address);	
		}
		
		public void insertCity(String city) {
			CITY_ELEMENT.sendKeys(city);	
		}
		
		public void insertState(String state) {
			STATE_ELEMENT.sendKeys(state);	
		}
		
		public void insertZip(String zip) {
			ZIP_ELEMENT.sendKeys(zip);	
		}
		
		public void selectCountryFromDropdwon(String country) {
			selectFromDropdown(COUNTRY_ELEMENT, country); 
	}
		
		public void clickSubmitButton() {
			SUBMIT_BUTTON_ELEMENT.click();
		}
		
		public void verifyAddContactPage() {
			Assert.assertEquals(ADD_CONTACT_ELEMENT.getText(), "Add Contact", "Wrong page!");
		}
		
		
		//tbody/tr[1]/td[3]
		//tbody/tr[2]/td[3]
		//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]		
		
		public void verifyEnteredNameAndDelete() {
			String beforeXpath="//tbody/tr[";
			String afterXpath="]/td[3]";
			String afterXpath_delete= "]/td[3]/following-sibling::td[4]/a[2]";
			
			for (int i=1; i<=10; i++) {
				String name= driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
				if(name.contains(insertedName)) {
					System.out.println("Inserted name exists!");
					driver.findElement(By.xpath(beforeXpath+i+afterXpath_delete)).click();;
					DELETE_OK_ELEMENT.click();
				}
			}
			
		}
		
}





