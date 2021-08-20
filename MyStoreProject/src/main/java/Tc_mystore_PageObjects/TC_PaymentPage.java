package Tc_mystore_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class TC_PaymentPage {
	WebDriver driver;
TC_Actionclass action= new TC_Actionclass();
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public TC_PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public TC_OrderSummary clickOnPaymentMethod() throws Throwable {
		action.click(driver, bankWireMethod);
		return new TC_OrderSummary();
	}

}
