package Unit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


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
}
