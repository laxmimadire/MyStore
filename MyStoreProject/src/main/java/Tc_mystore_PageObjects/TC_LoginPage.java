package Tc_mystore_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tc_mystore_Base.TC_Baseclass;



public class TC_LoginPage extends  TC_Baseclass{
	public static WebDriver driver;
TC_Actionclass action= new TC_Actionclass();
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;

	@FindBy(xpath="//button[@id='SubmitLogin']")
	private WebElement signInBtn;
	
	@FindBy(xpath="//input[@id='email_create']")
	private WebElement emailForNewAccount;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	private WebElement createNewAccountBtn;
	
	public TC_LoginPage()
	{
	  
	  PageFactory.initElements(driver,this);
	}
	public TC_Homepage login(String uname, String pswd,TC_Homepage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(driver, signInBtn);
		Thread.sleep(2000);
		homePage=new TC_Homepage();
		return homePage;
	}
	
	public TC_AddressPage login(String uname, String pswd,TC_AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, signInBtn);
		Thread.sleep(2000);
		addressPage=new TC_AddressPage();
		return addressPage;
	}
	
}
