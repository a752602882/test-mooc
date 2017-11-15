package Case;

import Pro.LoginPro;
import Unit.BaseDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Login extends  CaseBase{

    public  BaseDriver driver;
    public LoginPro loginPro;
    public Login(){
    driver =   InitDriver("chrome");
    loginPro = new LoginPro(driver);
    }

    @Test
    public  void getLoginHome() throws InterruptedException {
        driver.get("http://www.imooc.com");
        driver.findElement(By.id("js-signin-btn")).click();
        sleep(5000);
    }
    @Test(dependsOnMethods = {"getLoginHome"})
    public void testLogin(){
        loginPro.login("752602882@qq.com","5423110.");
    }
}
