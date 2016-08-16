package com.boc.binfengshenghuoTest.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boc.android.AndroidDriverApi;

public class BinFengHomePage
{
	private Logger logger=LogManager.getLogger(BinFengHomePage.class);
	@FindBy(name="账单")
	private static  WebElement zhangdan;
	@FindBy(name="积分兑换")
	private static WebElement jifenduihuan;
	@FindBy(name="短信服务")
	private static WebElement duanxinfuwu;
	@FindBy(name="账户信息")
	private static WebElement zhanghuxinxi;
	@FindBy(name="话费充值")
	private static WebElement huafeichongzhi;
	@FindBy(name="电影院")
	private static WebElement dianyingyuan;
	@FindBy(name="申请进度")
	private static WebElement shengqingjindu;
	@FindBy(name="用卡管理")
	private static WebElement yongkaguanli;
	@FindBy(name="惠聚天下")
	private static WebElement huijutianxia;
	@FindBy(name="券Mall")
	private static WebElement quanMall;
	@FindBy(name="特惠快讯")
	private static WebElement tehuikuaixun;
	@FindBy(name="添加")
	private static WebElement tianjia;
	@FindBy(name="金融服务")
	private static WebElement jinrongfuwu;
	@FindBy(name="便民优惠")
	private static WebElement bianminyouhui;
	@FindBy(name="更多")
	private static WebElement gengduo;

	public BinFengHomePage(AndroidDriverApi driver) 
	{
		PageFactory.initElements(driver, this);
		logger.info("初始化HomePage元素成功");
	}
	public  static String getzhangdanText()
	{
		return zhangdan.getText();
	}
	public ZhangDan clickZhangdan()
	{
		zhangdan.click();
		logger.info("准备进入ZhangDan类");
		return new ZhangDan();
	}
	
	public JinRongFuWu clickJinrongFuwu()
	{
		jinrongfuwu.click();
		logger.info("准备进入JinRongFuWu类");
		return new JinRongFuWu();
	}

}
