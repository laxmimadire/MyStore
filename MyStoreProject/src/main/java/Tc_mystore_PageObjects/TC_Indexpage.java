package Tc_mystore_PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tc_mystore_Base.TC_Baseclass;


public class TC_Indexpage extends TC_Baseclass
{
	TC_Actionclass action =new TC_Actionclass();
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	@CacheLookup
	private WebElement signin;
	
	@FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
	@CacheLookup
	private WebElement logo;
	
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	@CacheLookup
	private WebElement searchtb;
	
	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	@CacheLookup
	private WebElement submitbtn;
	
	public TC_Indexpage()
	{
		PageFactory.initElements(driver, this);
	}
	public TC_LoginPage clickOnSignIn()
	{
		action.fluentWait(driver,signin, 10);
		action.click(driver, signin);
		return new TC_LoginPage();
	}
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(driver, logo);
	}
	
	public String getMyStoreTitle()
	{
		String myStoreTitel=driver.getTitle();
		return myStoreTitel;
	}
	
	public TC_Searchresultpage searchProduct(String productName) throws Throwable 
	{
		action.type(searchtb, productName);
		action.scrollByVisibilityOfElement(driver, searchtb);
		action.click(driver, searchtb);
		Thread.sleep(3000);
		return new TC_Searchresultpage();
	}
	
}
