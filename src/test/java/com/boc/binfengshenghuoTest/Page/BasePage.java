package com.boc.binfengshenghuoTest.Page;

import org.openqa.selenium.support.PageFactory;

import com.boc.android.AndroidDriverApi;


public class BasePage 
{
    protected AndroidDriverApi driver;
    public BasePage(AndroidDriverApi driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
}
