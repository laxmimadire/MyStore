package Tc_mystore_Base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Tc_mystore_Utilities.TC_ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Baseclass {
  
	public static WebDriver driver;
	TC_ReadConfig readconfig=new TC_ReadConfig();
	//public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver> ();
	
	public String baseurl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static Logger logger;
	
@BeforeClass	
@Parameters("browser")
public void launchApp(String browser)
{
	logger=Logger.getLogger("MyStoreProject");
	PropertyConfigurator.configure("Log4j.properties");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(baseurl);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
}
@AfterClass
public void dissmissApp()
{
 driver.quit();	
}
	
	
	

}
