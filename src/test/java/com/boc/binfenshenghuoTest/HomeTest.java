package com.boc.binfenshenghuoTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.boc.android.AndroidDriverApi;
import com.boc.android.InitAndroidDriver;
import com.boc.binfengshenghuoTest.Page.BinFengHomePage;
import com.boc.binfengshenghuoTest.Page.JinRongFuWu;
import com.boc.binfengshenghuoTest.Page.WelcomePage;
import com.boc.binfengshenghuoTest.Page.ZhangDan;

public class HomeTest 
{
    private WelcomePage wp;
    private BinFengHomePage BFHP;
    private ZhangDan zd;
    private JinRongFuWu jrfw;
    private Logger logger= LogManager.getLogger(HomeTest.class);
    private AndroidDriverApi driver;
    @BeforeClass
    public void InitDriver()
    {
    	driver=InitAndroidDriver.getDriver();
    	wp=new WelcomePage(driver);
    	BFHP=wp.enterHomePageQuXiao();
    	
    }
    @Test(enabled=false)
    public void homeTest()
    {
    	String zhangdan=BinFengHomePage.getzhangdanText();
    	driver.takeScreenShot("账单");
    	Assert.assertEquals(zhangdan, "账单");
    	zd=BFHP.clickZhangdan();
    	String weichuzhangdan=ZhangDan.getweichuZhangdanvalue();
    	driver.takeScreenShot("未出账单");
    	System.out.println(weichuzhangdan);
    	Assert.assertEquals(weichuzhangdan, "未出账单");
    }
    @Test
    public void jinrongfuwu()
    {
    	jrfw=BFHP.clickJinrongFuwu();
    	String erweimayouhui=JinRongFuWu.geterweimayouhuiValue();
    	System.out.println(erweimayouhui);
    	Assert.assertEquals(erweimayouhui, "二维码优惠");
    }

    
    @AfterClass
    public void quitApp()
    {
    	driver.quit();
    }
}
