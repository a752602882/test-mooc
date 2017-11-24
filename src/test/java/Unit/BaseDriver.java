package Unit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;


//封装的driver的操作
public class BaseDriver {


   public  WebDriver driver;

    public  BaseDriver(String browser){
        SelectDriver selectDriver  = new SelectDriver();
        this.driver= selectDriver.driverName(browser);

    }


    public  void stop(){
        System.out.println("关闭driver");
        driver.close();
    }

    /**
     * 封装get
     * @param url
     */
    public  void  get(String url){
        driver.get(url);
    }

    /**
     * 封装 element
     * @param by
     * @return
     */
     public  WebElement  findElement(By by){
       return  driver.findElement(by);
     }

    /**
     * 封装 elements
     * @param by
     * @return
     */
    public List<WebElement> findElements(By by){
        return  driver.findElements(by);
    }

    /**
     * 切换到alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    /**
     * 模态框切换
     */
    public void switchToMode(){
        driver.switchTo().activeElement();
    }

    /**
     * 返回上一个页面
     */
    public  void back(){
        driver.navigate().back();
    }
    /**
     * 截屏
     */
    public   void  takeSrceenShot() throws IOException {
        long date =  System.currentTimeMillis();
        String path = String.valueOf(date);
        //获取当前工作路径
        String curPath =System.getProperty("user.dir");
        path = path+".png";
        String screenPath = curPath+"/"+path;
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(screenPath));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void close() {
        driver.close();
    }

    public  void  action(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void setCookie(Cookie cookie) {
       driver.manage().addCookie(cookie);
    }

    public 	Set<Cookie> getCookie() {
   	    Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }
}
