package com.boc.android;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**    
* 项目名称：ZhongYinYiShang   
* 类名称：AndroidDriverApi   
* 类描述：   
* 创建人：Administrator   
* 创建时间：2015年8月16日 下午2:25:14   
* 修改人：Administrator   
* 修改时间：2015年8月16日 下午2:25:14   
* 修改备注：   
* @version    
*
 */
public class AndroidDriverApi extends io.appium.java_client.android.AndroidDriver {
    private static Logger logger = LogManager.getLogger(AndroidDriverApi.class);

   /**
    * 
   
   * <p>Title: </p> 
   
   * <p>初始化构造方法: </p> 
   
   * @param remoteAddress
   * @param desiredCapabilities
    */
    public AndroidDriverApi(URL remoteAddress, DesiredCapabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        logger.info("appium server启动成功，url为：" + remoteAddress);
    }

    /**
     * 重写findElementById方法，加入Log
     *
     * @param id
     * @return
     */
    @Override
    public WebElement findElementById(String id) {
        try {
            WebElement element = super.findElementById(id);
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.error("id 为 " + id + "的元素没有找到");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 重写findElementByName
     *
     * @param name
     * @return
     */
    @Override
    public WebElement findElementByName(String name) {
        try {
            WebElement element = super.findElementByName(name);
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.error("id 为 " + name + "的元素没有找到");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 重写findElementByClassName方法，加入log
     *
     * @param className
     * @return
     */
    @Override
    public WebElement findElementByClassName(String className) {
        try {
            WebElement element = super.findElementByClassName(className);
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + className + "的控件");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 重写findElementByXpath方法
     *
     * @param using
     * @return
     */
    @Override
    public WebElement findElementByXPath(String using) {
        try {
            WebElement element = super.findElementByXPath(using);
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + using + "的控件");
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 重写FindElementByAccessibilityId方法，加入日志
     */
    public WebElement FindElementByAccessibilityId(String desc)
    {
    	try {
    		WebElement element=super.findElementByAccessibilityId(desc);
        	logger.info("找到AccessibilityId的控件："+element.getText());
        	return element;
			
		} catch (ElementNotFoundException e) {
			logger.info("无法找到"+desc+"控件");
			e.printStackTrace();
			return null;
		}
    	
    }
    
    /**
     * 重写findelementsbyid方法，加入log
     */
    @Override
    public List<WebElement> findElementsById(String using) {
        try {
            List<WebElement> elementList = super.findElementsById(using);
            logger.info("共找到" + elementList.size() + "个控件");
            for (int i = 0; i < elementList.size(); i++) {
                logger.info("第" + i + "个控件名为：" + elementList.get(i).getText());
            }
            return elementList;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + using + "的控件");
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 重写findElementsByName方法，加入log
     */
    @Override
    public List<WebElement> findElementsByName(String name)
    {
    	try {
    		List<WebElement> elements =super.findElementsByName(name);
    		logger.debug("共找到控件："+elements.size()+"个");
    		for(int i=0;i<elements.size();i++)
    		{
    			logger.info("第"+i+"个控件是："+elements.get(i).getText());
    		}
    		return elements;
			
		} catch (ElementNotFoundException e) {
			logger.info("没有定位到Name为" + name + "的控件");
			return null;
		}
		
    }

    /**
     * 重写findElementsByXPath方法
     *
     * @param using
     * @return
     */
    @Override
    public List<WebElement> findElementsByXPath(String using) {
        try {
            List<WebElement> elementList = super.findElementsByXPath(using);
            logger.info("共找到" + elementList.size() + "个控件");
            for (int i = 0; i < elementList.size(); i++) {
                logger.info("第" + i + "个控件名为：" + elementList.get(i).getText());
            }
            return elementList;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + using + "的控件");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<WebElement> findElementsByClassName(String using) {

        try {
            List<WebElement> elementList = super.findElementsByClassName(using);
            logger.info("共找到" + elementList.size() + "个控件");
            for (int i = 0; i < elementList.size(); i++) {
                logger.info("第" + i + "个控件名为：" + elementList.get(i).getText());
            }
            return elementList;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + using + "的控件");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找button并点击，适合页面只有一个button的情形或者只需要点击页面中第一个button的情形
     */
    public void findElementByButtonOnClick() {
        findElementByButton().click();
    }

    /**
     * 查找button并点击，适合页面只有一个button的情形或者只需要查找页面中第一个button的情形
     *
     * @return Button对象
     */
    public WebElement findElementByButton() {
        return findElementByClassName(AndroidClassName.BUTTON);
    }

    /**
     * 查找页面上所有的button
     *
     * @return Button对象List
     */
    public List<WebElement> findElementsByButton() {
        return findElementsByClassName(AndroidClassName.BUTTON);

    }

    /**
     * 查找RadioButton并点击，适合页面只有一个RadioButton并点击的情形或者只需要点击页面中第一个RadioButton并点击的情形
     */
    public void findElementByRadioButtonOnClick() {
        findElementByRadioButton().click();
    }

    /**
     * 查找RadioButton并点击，适合页面只有一个RadioButton并点击的情形或者只需要查找页面中第一个RadioButton的情形
     *
     * @return RadioButton对象
     */
    public WebElement findElementByRadioButton() {
        return findElementByClassName(AndroidClassName.RADIO_BUTTON);
    }

    /**
     * 查找页面上的所有RadioButton
     *
     * @return RadioButton对象List
     */
    public List<WebElement> findElementsByRadioButton() {
        return findElementsByClassName(AndroidClassName.RADIO_BUTTON);
    }

    /**
     * 查找文本输入框，适合页面只有一个文本输入框并点击的情形或者只需要查找页面中第一个文本输入框的情形
     *
     * @return EditText对象
     */
    public WebElement findElementByEditText() {
        return findElementByClassName(AndroidClassName.EDITTEXT);
    }

    /**
     * 查找页面中所有的文本输入框架
     *
     * @return EditText对象List
     */
    public List<WebElement> findElementsByEditText() {
        return findElementsByClassName(AndroidClassName.EDITTEXT);
    }

    /**
     * 查找ImageView，适用于页面只有一个IMageView或者只需要查找页面中第一个ImageView的情况
     *
     * @return ImageView对象
     */
    public WebElement findElementByImgView() {
        return findElementByClassName(AndroidClassName.IMG_VIEW);
    }

    /**
     * 查找并点击ImageView，适用于页面只有一个IMageView或者只需要点击页面中第一个ImageView的情况
     */
    public void findElementByImgViewOnClick() {
        findElementByImgView().click();
    }

    /**
     * 查找页面中所有的ImageView对象
     *
     * @return ImageView对象List
     */
    public List<WebElement> findElementsByImgView() {
        return findElementsByClassName(AndroidClassName.IMG_VIEW);
    }

    /**
     * 通过ClassName查找元素对象并返回指定的一个
     *
     * @param className
     *         Android类名
     * @param index
     *         要返回的对象的索引
     * @return 元素对象
     * @see AndroidClassName
     */
    public WebElement findElementByClassNameAndIndex(String className, int index) {
        try {
            WebElement element = super.findElementByAndroidUIAutomator("new UISelector.className(" + className + ").index(" + index + ")");
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + className + "的控件");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过ClassName查找可点击的元素对象并返回指定的一个
     *
     * @param className
     *         Android类名
     * @param instance
     *         要返回对象的索引
     * @return 元素对象
     */
    public WebElement findElementByClassAndClickable(String className, int instance) {
        try {
            WebElement element = super.findElementByAndroidUIAutomator("new UISelector.className(" + className + ").instance(" + instance + ")");
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到className为" + className + "的控件");
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查找LinearLayout
     *
     * @return LinearLayout对象
     */
    public WebElement findElementByLinearLayout() {
        return findElementByClassName(AndroidClassName.LINEAR_LAYOUT);
    }

    /**
     * 查找并点击LinearLayout对象
     */
    public void findElementByLinearLayoutOnClick() {
        findElementByLinearLayout().click();
    }

    /**
     * 查找页面中所有的LinearLayout对象
     *
     * @return LinearLayout对象List
     */
    public List<WebElement> findElementsByLinearLayout() {
        return findElementsByClassName(AndroidClassName.LINEAR_LAYOUT);
    }

    /**
     * 查找TextView对象
     *
     * @return TextView对象
     */
    public WebElement findElementByTextView() {
        return findElementByClassName(AndroidClassName.TEXT_VIEW);
    }

    /**
     * 查找并点击TextView对象
     */
    public void findElementByTextViewOnClick() {
        findElementByTextView().click();
    }

    /**
     * 查找所有TextView对象
     *
     * @return TextView对象List
     */
    public List<WebElement> findElementsByTextView() {
        return findElementsByClassName(AndroidClassName.TEXT_VIEW);
    }

    /**
     * 查找RelativeLayout对象
     *
     * @return RelativeLayout对象
     */
    public WebElement findElementByRelativeLayout() {
        return findElementByClassName(AndroidClassName.RELATIVELAYOUT);
    }

    /**
     * 查找并点击RelativeLayout对象
     */
    public void findElementByRelativeLayoutOnClick() {
        findElementByRelativeLayout().click();
    }

    /**
     * 查找所有RelativeLayout对象
     *
     * @return RelativeLayout对象List
     */
    public List<WebElement> findElementsByRelativeLayout() {
        return findElementsByClassName(AndroidClassName.RELATIVELAYOUT);

    }

    /**
     * 查找CheckBox对象
     *
     * @return CheckBox对象
     */
    public WebElement findElementByCheckbox() {
        return findElementByClassName(AndroidClassName.CHECKBOX);
    }

    /**
     * 查找并点击CheckBox对象
     */
    public void findElementByCheckboxOnClick() {
        findElementByCheckbox().click();
    }

    /**
     * 查找当前页面上所有的CheckBox对象
     *
     * @return CheckBox对象List
     */
    public List<WebElement> findElementsByCheckbox() {
        return findElementsByClassName(AndroidClassName.CHECKBOX);
    }
    
    /**
     * 通过UiSelector().className()定位控件
     */
    public WebElement findElementByUiSelectorClassName(String classname)
    {
    	try {
    		WebElement element = super.findElementByAndroidUIAutomator("new UiSelector().className("+"\""+classname+"\""+")");
        	logger.info("找到控件"+element.getText());
        	return element;	
		} catch (ElementNotFoundException e) {
			logger.info("没有找到控件"+classname);
			e.printStackTrace();
			return null;
			
		}
    	
    }

    
    /**
     * 通过UiSelector().resourceId()定位控件
     *
     * @param id
     * @return
     */
    public WebElement findElementByUiSelectorId(String id) {
        try {
            WebElement element = super.findElementByAndroidUIAutomator("new UiSelector().resourceId(" + "\"" + id + "\"" + ")");
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到id为" + id + "的控件");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 通过UiSelector().text()定位
     *
     * @param text
     *         需要查找的文本信息
     * @return
     */
    public WebElement findElementByUiSelectorText(String text) {
        try {
            WebElement element = super.findElementByAndroidUIAutomator("new UiSelector().text(" + "\"" + text + "\"" + ")");
            logger.info("找到控件：" + element.getText());
            return element;
        } catch (ElementNotFoundException e) {
            logger.info("没有定位到text为" + text + "的控件");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 点击物理返回键
     */
    public void goBack() {
        super.sendKeyEvent(AndroidKeyCode.BACK);
    }

    /**
     * 返回手机主屏
     */
    public void goToDeviceHome() {
        super.sendKeyEvent(AndroidKeyCode.HOME);
    }

    /**
     * 获取屏幕的宽度
     *
     * @return 屏幕宽度
     */
    private int getScreenWidth() {
        return this.manage().window().getSize().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @return 屏幕高度
     */
    private int getScreenHeight() {
        return this.manage().window().getSize().getHeight();
    }

    /**
     * 获取屏幕的二分之一宽度
     *
     * @return 屏幕的二分之一宽度
     */
    private int getHalfWidth() {
        return getScreenWidth() / 2;
    }

    /**
     * 获取屏幕的二分之一高度
     *
     * @return 屏幕的二分之一高度
     */
    private int getHalfHeight() {
        return getScreenHeight() / 2;
    }

    /**
     * 从屏幕的中间向左边滑动
     */
    public void swipeFromCenterToLeft() {
        int halfWidth = getHalfWidth();
        int halfHeight = getHalfHeight();
        logger.info("half width:" + halfWidth + "\nhalf Height: " + halfHeight);
        super.swipe(getHalfWidth(), getHalfHeight(), 1, getHalfHeight(), 200);
    }

    /**
     * 从屏幕的中间向右边滑动
     */
    public void swipeFromCenterToRight() {
        super.swipe(getHalfWidth(), getHalfHeight(), getScreenWidth() - 1, getHalfHeight(), 200);
    }

    /**
     * 从屏幕的最右边向左边滑动
     */
    public void swipeFromRightToLeft() {
        super.swipe(getScreenWidth() - 1, getHalfHeight(), 1, getHalfHeight(), 200);
    }

    /**
     * 从屏幕的最左边向左右滑动
     */
    public void swipeFromLeftToRight() {
        super.swipe(1, getHalfHeight(), getScreenWidth() - 1, getHalfHeight(), 200);
    }

    /**
     * 从屏幕的中间向上滑动
     */
    public void swiperFromCenterToTop() {
        super.swipe(getHalfWidth(), getHalfHeight(), getHalfWidth(), 1, 200);
    }

    /**
     * 从屏幕的中间向下滑动
     */
    public void swipeFromCenterToBottom() {
        super.swipe(getHalfWidth(), getHalfHeight(), getHalfWidth(), getScreenHeight() - 1, 2000);
    }

    /**
     * 从屏幕的最底部向上滑动
     */
    public void swipeFromBottomToTop() {
        super.swipe(getHalfWidth(), getScreenHeight() - 1, getHalfWidth(), 1, 200);
    }

    /**
     * 从屏幕的最顶部向下滑动
     */
    public void swipeFromTopToBottom() {
        super.swipe(getHalfWidth(), 1, getHalfWidth(), getScreenHeight() - 1, 2000);
    }

    /**
     * 逐字删除文本框中的文字
     *
     * @param element
     *         文本框架控件
     */
    public void clearText(WebElement element) {

        String text = element.getText();
        super.sendKeyEvent(AndroidKeyCode.KEYCODE_MOVE_END);
        for (int i = 0; i < text.length(); i++) {
            super.sendKeyEvent(AndroidKeyCode.DEL);
        }
    }

    /**
     * 获取屏幕截图，截图保存在项目根目录下的snapshot文件夹中
     *
     * @param screenShotName
     *         保存截图的名字
     */
    public void takeScreenShot(String screenShotName) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        File classpathRoot = new File(System.getProperty("user.dir"));
        File snapShotDirectory = new File(classpathRoot, "snapshots");
        if(!snapShotDirectory.exists())
        {
        	snapShotDirectory.mkdir();
        }
        File snapshot = super.getScreenshotAs(OutputType.FILE);
        String name = screenShotName + "-" + date + ".png";
        try {
            FileUtils.copyFile(snapshot, new File(snapShotDirectory, name));

        } catch (IOException e) {
            logger.error("截图失败");
            e.printStackTrace();
        }
    }
}
