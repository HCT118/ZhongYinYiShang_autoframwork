package com.boc.util.zhongyinyishang;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class InitAndroidDriver 
{
	private AndroidDriver<AndroidElement> driver;
	public InitAndroidDriver()
	{
		URL url = null;
		File classpath= new File(System.getProperty("user.dir"));
		File appDir = new File(classpath,"/app");
		File app = new File(appDir,"com.boc.zyys.apk");
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"192.168.56.101:5555" );
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.boc.bocop.container");
		caps.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.boc.bocop.container.activity.SplashActivity");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "40");
		caps.setCapability("unicodeKeyboard",true);
		caps.setCapability("autoWebview", true);
		caps.setCapability("resetKeyBoard", true);
	//	caps.setCapability("fullReset", true);
		
		try {
			url=new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new AndroidDriver<AndroidElement>(url, caps);
	}
	
	public AndroidDriver<AndroidElement> getDriver()
	{
		return driver;
	}
}
