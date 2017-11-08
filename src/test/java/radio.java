package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class radio {
    private WebDriver driver ;
    static   private String url="http://www.imooc.com/user/newlogin/from_url/";
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");


    }

    @Test
    public  void radio() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("752602882@qq.com");
        driver.findElement(By.name("password")).sendKeys("5423110.");
        driver.findElement(By.className("btn-red")).click();
        sleep(2000);
        driver.get("http://www.imooc.com/user/setprofile");
        //driver.findElement(By.linkText("个人设置")).click();
        driver.findElement(By.linkText("个人信息")).click();
        driver.findElement(By.className("pull-right")).click();

        List<WebElement> elements= driver.findElements(By.xpath(".//*[@id='profile']/div[4]/div/label"));

        sleep(2000);
        for (WebElement radio: elements) {

            if ( radio.findElement(By.name("sex")).isSelected()==false) {
                System.out.println(radio.getText());
                System.out.println("还没被选中");
                radio.click();
                break;
            }else{
                System.out.println(radio.getText());
                System.out.println("已经被选中");
                break;
            }
        }

    }



}
