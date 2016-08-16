package com.boc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ParseProperty 
{
	private Properties property = new Properties();
    private Logger logger =LogManager.getLogger(ParseProperty.class);
    private File filepath= new File(System.getProperty("user.dir"), "src\\main");
    private File configpath =new File(filepath, "resources");
    
    public ParseProperty(String path)
    {
    	this.loadProperties(configpath.getAbsolutePath()+"\\"+path);
    }

	private void loadProperties(String path)
	{
		
		try {
			FileInputStream file = new FileInputStream(path);
			property.load(file);
			logger.info("加载    "+path+"成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("加载"+path+"失败");
			e.printStackTrace();
		}
		
	}
	public String getValue(String key)
	{
		return property.getProperty(key);
		
	}
	
	
	public static void main(String[] args)
	{
		ParseProperty p=new ParseProperty("config.properties");
		System.out.println(p.getValue("tt"));
		
		
	}
     
}
