package Unit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseDriver {

   public  WebDriver driver;

    public  BaseDriver(String browser){
        SelectDriver selectDriver  = new SelectDriver();
        this.driver= selectDriver.driverName(browser);

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
