package Tc_mystore_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Tc_mystore_Base.TC_Baseclass;
import Tc_mystore_Datadriven.TC_XLutils;
import Tc_mystore_PageObjects.TC_AddToCartPage;
import Tc_mystore_PageObjects.TC_Indexpage;
import Tc_mystore_PageObjects.TC_Searchresultpage;
import Tc_mystore_Utilities.TC_Logclass;


public class Test_AddToCartPage 
	extends TC_Baseclass {
		
		private TC_Indexpage index;
		private TC_Searchresultpage searchResultPage;
		private TC_AddToCartPage addToCartPage;

		@Parameters("browser")
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup(String browser) {
			launchApp(browser); 
		}
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			driver.quit();
		}
		
		@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = TC_XLutils.class)
		public void addToCartTest(String productName, String qty, String size) throws Throwable {
			TC_Logclass.startTestCase("addToCartTest");
			index= new TC_Indexpage();
			searchResultPage=index.searchProduct(productName);
			addToCartPage=searchResultPage.clickOnProduct();
			addToCartPage.enterQuantity(qty);
			addToCartPage.selectSize(size);
			addToCartPage.clickOnAddToCart();
			boolean result=addToCartPage.validateAddtoCart();
			Assert.assertTrue(result);
			TC_Logclass.endTestCase("addToCartTest");
			
		}

}
