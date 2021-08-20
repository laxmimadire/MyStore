package Tc_mystore_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Tc_mystore_Base.TC_Baseclass;
import Tc_mystore_PageObjects.TC_Indexpage;
import Tc_mystore_Utilities.TC_Logclass;

public class Test_Indexpage extends TC_Baseclass{
	private TC_Indexpage indexpage;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(groups="Smoke")
	public void verifyLogo() throws Throwable
	{
		TC_Logclass.startTestCase("verifyLogo");
		indexpage=new TC_Indexpage();
		boolean result=indexpage.validateLogo();
		Assert.assertTrue(result);
		TC_Logclass.endTestCase("verifyLogo");
	}
	@Test(groups="Smoke")
public void verifyTitle()
{
		TC_Logclass.startTestCase("verifyTitle");
		String actTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(actTitle,"My Store");
		TC_Logclass.endTestCase("verifyTitle");
}
}
