import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class input {
    private WebDriver driver ;
    static   private String url="http://www.imooc.com/user/newlogin/from_url/";
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);

    }

    @Test
    public  void input_word_clear_print() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("你好啊中国");
        sleep(2000L);
        driver.findElement(By.name("email")).clear();
        String s=driver.findElement(By.name("email")).getAttribute("placeholder");
        System.out.printf(s);
    }



}
