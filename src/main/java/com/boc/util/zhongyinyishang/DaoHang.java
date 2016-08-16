package com.boc.util.zhongyinyishang;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DaoHang 
{
	public  static AndroidDriver<AndroidElement> driver =new InitAndroidDriver().getDriver();
	public  void DaoHangJieMian()
	{
		driver.tap(1, 100, 100, 1);
		driver.swipe(1000, 960, 50, 960, 1000);
		driver.swipe(1000, 960, 50, 960, 1000);
		AndroidElement lijitiyan=driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"¡¢º¥ÃÂ—È\")");
		lijitiyan.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
