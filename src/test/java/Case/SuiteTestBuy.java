package Case;

import Pro.SureOrderPro;
import Unit.BaseDriver;
import Unit.HandleCookie;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SuiteTestBuy extends  CaseBase{

    public BaseDriver driver;
    public SureOrderPro sureOrderPro;
    public HandleCookie cookie;
    @BeforeClass
    public void init(){
        driver= InitDriver("chrome");
        sureOrderPro = new SureOrderPro(driver);
        cookie = new HandleCookie(driver);
       driver.get("http://order.imooc.com/pay/confirm/goods_ids/1-157");

    }

    @Test
    public  void testLoginBuy(){

       // cookie.writeCookie();  还是要登录后在读的到cookie
        cookie.setCookie();
        driver.get("http://order.imooc.com/pay/confirm/goods_ids/1-157");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sureOrderPro.buyNow();
    }
}
