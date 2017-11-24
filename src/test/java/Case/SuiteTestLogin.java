package Case;

import Pro.HomePagePro;
import Pro.LoginPro;
import Unit.BaseDriver;
import Unit.ProUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import static java.lang.Thread.sleep;

public class SuiteTestLogin extends CaseBase {

    public BaseDriver driver;
    public ProUnit proUnit;
    public LoginPro loginPro;
    public HomePagePro homePagePro;

    @BeforeClass
    public  void init()
    {
        driver= InitDriver("chrome");
        proUnit = new ProUnit("loginTest.properties");
        driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.imooc.com/user/newlogin/from_url/");
        loginPro = new LoginPro(driver);
        homePagePro = new HomePagePro(driver);
    }




    @Test
    public  void testLogin() throws InterruptedException {
        loginPro.login(proUnit.getPro("username"),proUnit.getPro("password"));
         homePagePro.AssertUserNameEquals(proUnit.getPro("yq"));
    }

    @AfterClass
    public  void close(){
        driver.close();
    }

}
