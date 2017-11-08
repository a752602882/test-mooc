import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class upfile {
    private WebDriver driver ;
    static   private String url="http://www.imooc.com/user/newlogin/from_url/";
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");


    }


    /*
    *    知识点：把隐藏的元素显示出来才能操作
    *            修改元素属性，通过js方式
    *
    *    未解决问题：
    *            弹出新窗口时候，如何获得当前窗口drive？
    *
    * */
    @Test
    public  void upfile() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("752602882@qq.com");
        driver.findElement(By.name("password")).sendKeys("5423110.");
        driver.findElement(By.className("btn-red")).click();


        String  jsString ="document.getElementsByClassName(\"g-user-card\")[0].style.visibility=\"visible\";";
        sleep(2000);

       /*//drive没定义到新的窗口句柄，展示不知道怎么解决
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript(jsString);
         driver.findElement(By.linkText("个人设置")).click();
       */



        driver.get("http://www.imooc.com/user/setbindsns");
        sleep(2000);
      //  driver.getWindowHandle();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        String js1String ="document.getElementsByClassName('update-avator')[0].style.bottom='0'";
        js1.executeScript(js1String);
       driver.findElement(By.linkText("更换头像")).click();
       driver.findElement(By.id("upload")).sendKeys("C:\\Users\\Administrator\\Desktop\\截图\\带手机框截图\\A1.png");


    }
}
