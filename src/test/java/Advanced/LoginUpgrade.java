package Advanced;

import Unit.BaseDriver;
import Unit.GetByLocator;
import Unit.ProUnit;
import Unit.TestngListenerShotScreen;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Listeners({TestngListenerShotScreen.class})
public class LoginUpgrade  extends BaseDriver {

    private String url="http://www.imooc.com/";

    public LoginUpgrade(String browser) {
        super(browser);
    }


    @DataProvider(name = "user")
    public Object[][] provider(){
        return  new String[][]{
                {"LV_V","752602882@qq.com","5423110."},
                {"LV_V","752602882@qq.com","5423110."}
        };
    }

    @Test
    public void  init() throws InterruptedException {
/*        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver =new ChromeDriver();*/
        driver.get(url);
        driver.manage().window().maximize();

        //隐式等待，设置全局的等待时间
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("自动化开始啦~~");

    }

    /***
     *   封装方法目的：
     *   （1）参数化
     *   （2）以后框架改变，方法名字也改变，就要去改很多地方，现在统一规定一个方法，以后只需要修改一处
     *   ( 3) 重复出现的方法
     * @throws InterruptedException
     */
     @Test(dataProvider ="user",dependsOnMethods = {"init"})
     public  void login(String equal_name_str,String email_str,String password_str) throws InterruptedException, IOException {

/*
        String login_btn ="js-signin-btn";
        String email_btn ="email";
        String password_btn= "password";
        String red_btn="btn-red ";
        String header_avator_btn ="header-avator";
        String name_btn ="name";
        */

//        String equal_name_str ="LV_V";
//        String email_str= "752602882@qq.com";
//        String password_str= "5423110.";





         find_Element(driver, GetByLocator.getByLocator("login_btn")).click();
         //sleep(2000);


         /**
          *代码表示默认等待1-10s， 10内，若ExpectedConditions找到元素立刻返回，超过是10s报超时。
          */
        /*
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        */


        //检验输入框状态
         WebElement email=find_Element(driver, GetByLocator.getByLocator("email_btn"));
         WebElement password=find_Element(driver, GetByLocator.getByLocator("password_btn"));
         //这两句感觉是废话，如果是false会报错吗？需要检验吗？   ----->不需要
         System.out.println(email.isDisplayed());
         System.out.println(password.isDisplayed());



        email.sendKeys(email_str);
        password.sendKeys(password_str);
        find_Element(driver, GetByLocator.getByLocator("red_btn")).click();

        sleep(2000);
        WebElement  info = find_Element(driver, GetByLocator.getByLocator("header_avator_btn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(info).perform();

        sleep(2000);
        String name = find_Element(driver, GetByLocator.getByLocator("name_btn")).getText();
        Assert.assertEquals(name,equal_name_str);
        //sheetScreen();
        driver.close();

    }



    private WebElement find_Element(WebDriver driver, By by){

        return  driver.findElement(by);
    }



}
