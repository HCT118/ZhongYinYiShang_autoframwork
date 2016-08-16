package com.boc.util.zhongyinyishang;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreen 
{
    private WebDriver driver;
	public TakeScreen(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void takeScreen()
	{
		String screenname=String.valueOf(DateTimeUtil.getDateTime()+".jpg");
		File pic=new File(System.getProperty("user.dir"));
		File picpath=new File(pic,"pic");
		if(!picpath.exists())
		{
			picpath.mkdir();
		}
		String screenpath = picpath.getAbsolutePath()+"/"+screenname;
		TakeScreenShot(screenpath);
	}
	public void TakeScreenShot(String screenpath) 
	{
		try 
		{
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenpath));
			System.out.println("截图成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
   
}
