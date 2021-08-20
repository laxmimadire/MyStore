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


public class Test_LoginPage extends TC_Baseclass {
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
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = TC_XLutils.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		TC_Logclass.startTestCase("loginTest");
		indexPage= new TC_Indexpage();
		TC_Logclass.info("user is going to click on SignIn");
		try {
		loginPage=indexPage.clickOnSignIn();
		}
		catch(StaleElementReferenceException e)
		{
			driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		}
	
	
		TC_Logclass.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    TC_Logclass.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    TC_Logclass.info("Login is Sucess");
	    TC_Logclass.endTestCase("loginTest");
}
	}


