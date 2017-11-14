package Unit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

    public WebDriver driver;
    public WebDriver driverName(String brower){
        if (brower.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.bin","D:\\Program Files\\selenium_driver\\geckodriver.exe");
             return new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
            return  new ChromeDriver();
        }
    }
}
