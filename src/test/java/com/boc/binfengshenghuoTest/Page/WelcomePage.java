package com.boc.binfengshenghuoTest.Page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boc.android.AndroidDriverApi;
import com.boc.utils.TimeSleep;

public class WelcomePage 
{
   private Logger logger = LogManager.getLogger(WelcomePage.class);
   private static AndroidDriverApi driver;
   @FindBy(name="确定")
   private static WebElement queding;
   @FindBy(name="取消")
   private static WebElement quxiao;
   
   public  WelcomePage(AndroidDriverApi driver)
   {
	   WelcomePage.driver=driver;
	   PageFactory.initElements(driver, this);
	   logger.info("成功进入WelcomPage界面");
   }
   
   public BinFengHomePage enterHomePageQueding()
   {
	   TimeSleep.sleepSeconds(2);
	   queding.click();
	   TimeSleep.sleepSeconds(3);
	   logger.info("准备进入HomePage");
	   return new BinFengHomePage(driver);
	   
	   
   }
   public BinFengHomePage enterHomePageQuXiao()
   {
	   TimeSleep.sleepSeconds(2);
	   quxiao.click();
	   TimeSleep.sleepSeconds(3);
	   logger.info("准备进入HomePage");
	   return new BinFengHomePage(driver);
   }
   
   public static AndroidDriverApi getDriver()
   {
	   return driver;
   }

}
