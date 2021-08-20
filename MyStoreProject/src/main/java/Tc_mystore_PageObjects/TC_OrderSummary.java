package Tc_mystore_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class TC_OrderSummary {
	WebDriver driver;
TC_Actionclass action= new TC_Actionclass();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public TC_OrderSummary() {
		PageFactory.initElements(driver, this);
	}

	public TC_Confirmation clickOnconfirmOrderBtn() throws Throwable {
		action.click(driver, confirmOrderBtn);
		return new TC_Confirmation();
	}

}
