package com.boc.binfengshenghuoTest.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boc.android.AndroidDriverApi;

public class ZhangDan 
{
	private Logger logger=LogManager.getLogger(ZhangDan.class);
	@FindBy(name="已出账单 ")
	private static WebElement yichuzhangdan;
	@FindBy(name="未出账单")
	private static WebElement weichuzhangdan;
	@FindBy(name="信用卡账单服务")
	private static WebElement xinyongkazhangdan;
	
	public ZhangDan()
	{
		PageFactory.initElements(WelcomePage.getDriver(), this);
		logger.info("初始化ZhangDan类成功");
	}
	
	public static String getYiChuZhangdanvalue()
	{
		return  yichuzhangdan.getText();
	}
	public static String getweichuZhangdanvalue()
	{
		return  weichuzhangdan.getText();
	}
	
}
