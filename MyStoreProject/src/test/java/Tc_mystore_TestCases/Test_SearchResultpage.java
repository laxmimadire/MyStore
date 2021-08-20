package Tc_mystore_TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Tc_mystore_Base.TC_Baseclass;
import Tc_mystore_Datadriven.TC_XLutils;
import Tc_mystore_PageObjects.TC_Indexpage;
import Tc_mystore_PageObjects.TC_Searchresultpage;
import Tc_mystore_Utilities.TC_Logclass;

public class Test_SearchResultpage extends TC_Baseclass {
	private TC_Indexpage index;
	private TC_Searchresultpage searchResultPage;

	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = TC_XLutils.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		TC_Logclass.startTestCase("productAvailabilityTest");
		index= new TC_Indexpage();
		searchResultPage=index.searchProduct(productName);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		TC_Logclass.endTestCase("productAvailabilityTest");
	}


}
