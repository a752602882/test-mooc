package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Login {

    private String url="http://www.imooc.com/";
    private WebDriver driver;

    @BeforeClass
    public void  init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        //隐式等待，设置全局的等待时间
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

     @Test
     public  void login() throws InterruptedException {



         driver.findElement(By.id("js-signin-btn")).click();
         //sleep(2000);


         /**
          *代码表示默认等待1-10s， 10内，若ExpectedConditions找到元素立刻返回，超过是10s报超时。
          */
        /* WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
*/


        //检验输入框状态
         WebElement email=driver.findElement(By.name("email"));
         WebElement password=driver.findElement(By.name("password"));
         //这两句感觉是废话，如果是false会报错吗？需要检验吗？   ----->不需要
         System.out.println(email.isDisplayed());
         System.out.println(password.isDisplayed());



        email.sendKeys("752602882@qq.com");
        password.sendKeys("5423110.");
        driver.findElement(By.className("btn-red ")).click();

        sleep(2000);
        WebElement  info = driver.findElement(By.id("header-avator"));
        Actions actions = new Actions(driver);
        actions.moveToElement(info).perform();

        sleep(2000);
        String name =driver.findElement(By.className("name")).getText();
        Assert.assertEquals(name,"LV_V");
    }

}
