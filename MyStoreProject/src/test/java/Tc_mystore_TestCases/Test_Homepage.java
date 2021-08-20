package Tc_mystore_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Tc_mystore_Base.TC_Baseclass;
import Tc_mystore_Datadriven.TC_XLutils;
import Tc_mystore_PageObjects.TC_Homepage;
import Tc_mystore_PageObjects.TC_Indexpage;
import Tc_mystore_PageObjects.TC_LoginPage;
import Tc_mystore_Utilities.TC_Logclass;

public class Test_Homepage extends TC_Baseclass {
	private TC_Indexpage indexPage;
	private TC_LoginPage loginPage;
	private TC_Homepage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = TC_XLutils.class)
	public void wishListTest(String uname, String pswd) throws Throwable {
		TC_Logclass.startTestCase("wishListTest");

		indexPage= new TC_Indexpage();
		
		try {
	
		loginPage=indexPage.clickOnSignIn();
		}
		catch(StaleElementReferenceException e)
		{
			driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		}
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		TC_Logclass.endTestCase("wishListTest");
	}
	
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = TC_XLutils.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		TC_Logclass.startTestCase("orderHistoryandDetailsTest");
	
			indexPage= new TC_Indexpage();
			
			try {
				
				loginPage=indexPage.clickOnSignIn();
				}
				catch(StaleElementReferenceException e)
				{
					driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
				}
			homePage=loginPage.login(uname,pswd,homePage);
			boolean result=homePage.validateOrderHistory();
			Assert.assertTrue(result);
			TC_Logclass.endTestCase("orderHistoryandDetailsTest");
		
	}
}
