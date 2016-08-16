package com.boc.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

import com.boc.utils.ParseProperty;

public class InitAndroidDriver 
{
	private static ParseProperty pp ;
	private static AndroidDriverApi driver;
	private static Logger logger = LogManager.getLogger(InitAndroidDriver.class);
	
	private   static AndroidDriverApi createDriver()
	{
		pp=new ParseProperty("config.properties");
		File rootDir= new File(System.getProperty("user.dir"));
		File appDir = new File(rootDir,pp.getValue("appDir"));
		File appPath=new File(appDir, pp.getValue("app"));
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.APP,appPath.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, pp.getValue("AUTOMATION_NAME"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, pp.getValue("PLATFORM_NAME"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, pp.getValue("PLATFORM_VERSION"));
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, pp.getValue("DEVICE_NAME"));
		caps.setCapability(MobileCapabilityType.APP_PACKAGE, pp.getValue("APP_PACKAGE"));
		caps.setCapability(MobileCapabilityType.APP_ACTIVITY, pp.getValue("APP_ACTIVITY"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, pp.getValue("PLATFORM_VERSION"));
		caps.setCapability("unicodeKeyboard",true);
		caps.setCapability("autoWebview", true);
		caps.setCapability("resetKeyBoard", true);
//		caps.setCapability("fullReset", true);
		
		String remoteUrl = pp.getValue("remoteUrl");
		try {
			URL url = new URL(remoteUrl);
			driver=new AndroidDriverApi(url,caps);
			logger.info("加载driver成功");
		} catch (MalformedURLException e) {
			logger.info("加载driver失败");
			e.printStackTrace();
			return null;
		}
		return driver;
	}
	
	public static AndroidDriverApi getDriver()
	{
		return createDriver();
	}
   
	public static void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
			logger.info("退出成功");
		}
		else
		{
			logger.info("退出失败");
		}
	}
	
}
