package Pro;

import Handle.HomePageHandle;
import Unit.BaseDriver;
import Unit.GetByLocator;
import Unit.ProUnit;
import org.testng.Assert;

public class HomePagePro {
    public BaseDriver driver;
    public HomePageHandle hph;

    public  HomePagePro(BaseDriver driver){
        this.driver =driver;
        hph = new HomePageHandle(driver);
    }

    /**
     * 用返回的用户名对比配置文件的用户名
     */
    public void  AssertUserNameEquals(String read_name){

       String prop_name =hph.getUserName();
       Assert.assertEquals(read_name,prop_name);

    }
}
