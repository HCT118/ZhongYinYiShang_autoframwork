package com.boc.binfengshenghuoTest.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boc.utils.TimeSleep;

public class JinRongFuWu
{
  private static Logger logger=LogManager.getLogger(JinRongFuWu.class);
  @FindBy(name="二维码优惠")
  private static WebElement erweimayouhui;
  public JinRongFuWu()
  {
	  PageFactory.initElements(WelcomePage.getDriver(), this);
	  logger.info("加载JinRongFuWu类成功");
  }
  
  public static String geterweimayouhuiValue()
  {
	  TimeSleep.sleepSeconds(3);
	  WelcomePage.getDriver().scrollTo("二维码优惠");
	  logger.info("获取到元素值"+erweimayouhui.getText());
	  return erweimayouhui.getText();
  }
}
