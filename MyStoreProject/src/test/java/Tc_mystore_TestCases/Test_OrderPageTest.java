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
import Tc_mystore_PageObjects.TC_Orderpage;
import Tc_mystore_PageObjects.TC_Searchresultpage;
import Tc_mystore_Utilities.TC_Logclass;


public class Test_OrderPageTest extends TC_Baseclass {

	private TC_Indexpage index;
	private TC_Searchresultpage searchResultPage;
	private TC_AddToCartPage addToCartPage;
	private TC_Orderpage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = TC_XLutils.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		TC_Logclass.startTestCase("verifyTotalPrice");
		index= new TC_Indexpage();
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		TC_Logclass.endTestCase("verifyTotalPrice");
	}

}
