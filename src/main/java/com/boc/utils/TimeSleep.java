package com.boc.utils;

public class TimeSleep 
{
	/**
	 * 进程休眠mills、seconds
	 */
   public static void sleepMills(long mills)
   {
		try {
			  Thread.sleep(mills);
			} catch (Exception e) 
		    {
				// TODO: handle exception
			}
   }
   
   
   public static void sleepSeconds(long seconds)
   {
	try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
   }
}
