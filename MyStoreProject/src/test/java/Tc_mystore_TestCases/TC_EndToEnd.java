package Tc_mystore_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Tc_mystore_Base.TC_Baseclass;
import Tc_mystore_Datadriven.TC_XLutils;
import Tc_mystore_PageObjects.TC_AddToCartPage;
import Tc_mystore_PageObjects.TC_AddressPage;
import Tc_mystore_PageObjects.TC_Confirmation;
import Tc_mystore_PageObjects.TC_Indexpage;
import Tc_mystore_PageObjects.TC_LoginPage;
import Tc_mystore_PageObjects.TC_OrderSummary;
import Tc_mystore_PageObjects.TC_Orderpage;
import Tc_mystore_PageObjects.TC_PaymentPage;
import Tc_mystore_PageObjects.TC_Searchresultpage;
import Tc_mystore_PageObjects.TC_ShippingPage;
import Tc_mystore_Utilities.TC_Logclass;
import Tc_mystore_Utilities.TC_ReadConfig;


public class TC_EndToEnd extends TC_Baseclass {
	TC_ReadConfig readconfig=new TC_ReadConfig();
	private TC_Indexpage index;
	private TC_Searchresultpage searchResultPage;
	private TC_AddToCartPage addToCartPage;
	private TC_Orderpage orderPage;
	private TC_LoginPage loginPage;
	private TC_AddressPage addressPage;
	private TC_ShippingPage shippingPage;
	private TC_PaymentPage paymentPage;
	private TC_OrderSummary orderSummary;
	private TC_Confirmation orderConfirmationPage;

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
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		TC_Logclass.startTestCase("endToEndTest");
		index= new TC_Indexpage();
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login(readconfig.getUsername(), readconfig.getPassword(),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		TC_Logclass.endTestCase("endToEndTests");
	}

}
