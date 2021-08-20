package Tc_mystore_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TC_ReadConfig {
	Properties prop;
	public TC_ReadConfig()
	{
		File scr=new File("./Configuration/Config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(scr);
			prop=new Properties();
			prop.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
		public String getApplicationURL()
		{
			String url=prop.getProperty("url");
			return url;
		}

	public String getUsername()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	}


