import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.boc.android.AndroidDriverApi;
import com.boc.android.InitAndroidDriver;
import com.boc.utils.TimeSleep;


public class hometest
{
	 private AndroidDriverApi driver;
	 @BeforeClass
	    public void InitDriver()
	    {
	    	driver=InitAndroidDriver.getDriver();	
	    }
	    @Test
	    public void homeTest()
	    {
	    	WebElement quxiao = driver.findElementById("android:id/button2");
	    	quxiao.click();
	    	TimeSleep.sleepSeconds(2);
	    	WebElement zhangdan = driver.findElementByName("账单");
	    	System.out.println(zhangdan.getText());
	    }
	    
	    @AfterClass
	    public void quitApp()
	    {
	    	driver.quit();
	    }
}
