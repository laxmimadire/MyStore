package Tc_mystore_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class TC_ShippingPage {
	WebDriver driver;
TC_Actionclass action=new TC_Actionclass();
@FindBy(id="cgv")
private WebElement terms;

@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
private WebElement proceedToCheckOutBtn;

public TC_ShippingPage() {
	PageFactory.initElements(driver, this);
}

public void checkTheTerms() throws Throwable {
	action.click(driver, terms);
}

public TC_PaymentPage clickOnProceedToCheckOut() throws Throwable {
	action.click(driver, proceedToCheckOutBtn);
	return new TC_PaymentPage();
}
}
