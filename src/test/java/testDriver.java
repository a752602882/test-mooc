import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class testDriver {

    private WebDriver driver ;
  static   private String url="https://www.baidu.com";
    @BeforeClass
    public void init(){


    }


    @Test
    public void test_firefox(){
      //  System.setProperty("webdriver.firefox.bin","D:\\Program Files\\selenium_driver\\geckodriver.exe");
       driver = new FirefoxDriver();
       driver.get("https://www.baidu.com");
      // driver.quit();

        //在火狐浏览器中css样式 #代表是个id   .(点)代表class
       //driver.findElement(By.id("kw")).sendKeys("selenium");
       //driver.findElement(By.name("wd")).sendKeys("webDrive");
       //driver.findElement(By.className("s_ipt")).sendKeys("s_ipt");
       //driver.findElement(By.tagname)
       // driver.findElement(By.linkText("地图")).click();
       // driver.findElement(By.partialLinkText("图")).click();

       //xpath定位
    //   driver.findElement(By.xpath(".//*[@id='kw']")).sendKeys("这是一个小伙伴");
       //css定位方式
       driver.findElement(By.cssSelector("#kw")).sendKeys("xbox");

       //table的定位 ,假如页面 有一个table
        WebElement table = driver.findElement(By.tagName("table"));
        //有多个tr，要用findElements来定位
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        for (WebElement row:rows){
         List<WebElement> tds= row.findElements(By.tagName("td"));
            for (WebElement td:tds){
              //  ........
            }
        }
    }
    @Test
    public void test_chrome(){
         System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/");
        driver.findElement(By.name("email")).sendKeys("752602882@qq.com");
        List<WebElement>  elements = driver.findElements(By.tagName("rlf-group"));
       for (WebElement element:elements){
           element.findElement(By.tagName("input")).sendKeys("5423110.");
       }


        driver.findElement(By.id("auto-signin")).click();
        driver.findElement(By.linkText("立即注册")).click();
        driver.findElement(By.partialLinkText("直接")).click();
       // driver.findElement(By.cssSelector()).click();
        driver.quit();
    }

    @Test
    public void test_IE(){
        System.setProperty("webdriver.ie.driver","D:\\Program Files\\selenium_driver\\MicrosoftWebDriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    //    driver.quit();
    }


}
