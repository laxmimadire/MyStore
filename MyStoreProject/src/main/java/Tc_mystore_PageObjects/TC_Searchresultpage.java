package Tc_mystore_PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Tc_mystore_Base.TC_Baseclass;



public class TC_Searchresultpage extends TC_Baseclass {
	

	
	TC_Actionclass action= new TC_Actionclass();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public TC_Searchresultpage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(driver, productResult);
	}
	
	public TC_AddToCartPage clickOnProduct() throws Throwable {
		action.click(driver, productResult);
		return new TC_AddToCartPage();
	}
}