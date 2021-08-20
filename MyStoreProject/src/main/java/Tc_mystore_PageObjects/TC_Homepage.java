package Tc_mystore_PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tc_mystore_Base.TC_Baseclass;



public class TC_Homepage extends TC_Baseclass {
	
	TC_Actionclass action= new TC_Actionclass();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public TC_Homepage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(driver);
		return homePageURL;
	}

}
