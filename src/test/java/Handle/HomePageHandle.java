package Handle;

import Page.HomePage;
import Unit.BaseDriver;

public class HomePageHandle  {

    public HomePage homePage;
    public BaseDriver driver;

    public  HomePageHandle(BaseDriver driver) {
        this.driver=driver;
        homePage= new HomePage(driver);
        driver.get("http://www.imooc.com/user/newlogin/from_url/");
    }

    /**
     * 获取用户名
     */
   public  String   getUserName(){
      return  homePage.getText(homePage.getUserNameElement());
   }

}
