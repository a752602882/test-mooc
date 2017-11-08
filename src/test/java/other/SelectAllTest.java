package other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SelectAllTest {
    private WebDriver driver ;
    static   private String url="http://www.imooc.com/user/newlogin/from_url/";
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");


    }

    //以表单的形式登录，看是否会成功
    @Test
    public  void form() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("752602882@qq.com");
        driver.findElement(By.name("password")).sendKeys("5423110.");
        String url5 = "http://www.imooc.com/u/3041832/courses";
        driver.get(url5);
       WebElement wikiMenu = driver.findElement(By.className("slider")).findElement(By.tagName("ul"));
        List<WebElement> items1 = wikiMenu.findElements(By.tagName("a"));
        for(WebElement item:items1){

           //item

        }
        items1.get(3).click();



      //driver.findElement(By.linkText("猿问")).click();


        //没有登录成功,
        //http://www.imooc.com/user/newlogin/from_url/?email=752602882%40qq.com&password=5423110.&verify=

    }
}
