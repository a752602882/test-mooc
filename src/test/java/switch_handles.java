package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class switch_handles {

    String url ="http://www.imooc.com/user/newlogin/from_url/";

    private   WebDriver driver;
    @BeforeClass
     public  void init() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("752602882@qq.com");
        driver.findElement(By.name("password")).sendKeys("5423110.");
        driver.findElement(By.className("btn-red")).click();

    }
    /**
     *   使用switchTo()  把dirver定位到 iframe副文本
     */
    @Test
    public  void iframe_switch() throws InterruptedException {
        sleep(2000);
        driver.get("http://www.imooc.com/wiki/create");
        WebElement iframe = driver.findElement(By.id("ueditor_0"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.tagName("body")).sendKeys("你好，副文本");
    }
    /**
     * gethandles()获得句柄
     */
    @Test
    public void driver_getHandles() throws InterruptedException {
        sleep(2000);
        driver.get(" http://www.imooc.com/");
        WebElement menu=  driver.findElement(By.className("menuContent"));
        List<WebElement> items=menu.findElements(By.className("item"));

        Actions actions = new Actions(driver);
        actions.moveToElement(items.get(0)).perform();

        //在还没有生成新窗口前，获得handle
        String handle_old= driver.getWindowHandle();
        driver.findElement(By.linkText("HTML/CSS")).click();

        //方案2
        Set<String> handles =driver.getWindowHandles();
        for (String handle:handles){
            if (handle.equals(handle_old)){
                continue;
            }
            driver.switchTo().window(handle);
        }

    /* 方案1
     Set<String> handles= driver.getWindowHandles();
      for (String handle:handles){
           driver.switchTo().window(handle);
      }*/



      

       driver.findElement(By.linkText("案例")).click();
    }

}
