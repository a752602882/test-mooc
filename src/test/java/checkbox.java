import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class checkbox {
    private WebDriver driver ;
    static   private String url="http://www.imooc.com/user/newlogin/from_url/";
    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium_driver\\chromedriver.exe");


    }

    @Test
    public  void check1() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement checkbox=  driver.findElement(By.className("auto-cbx"));

        Thread.sleep(2000);
        checkbox.click();
       // checkbox.click();
        if(checkbox.isSelected()){
            System.out.println("已经被选中");
        }else {
            System.out.println("没有被选中");
        }

        if(checkbox.isEnabled()==false){
            System.out.println("没有被隐藏");
        }else {
            System.out.println("没有被隐藏");
        }


        //checkbox.clear();


    }



}
