package Tc_mystore_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class TC_AddressPage {
TC_Actionclass action= new TC_Actionclass();
WebDriver driver;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public TC_AddressPage() {
		PageFactory.initElements(driver, this);
	}

	public TC_ShippingPage clickOnCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOut);
		return new TC_ShippingPage();
	}

}
