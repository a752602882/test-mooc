package Handle;

import Page.loginPage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

//业务层
public class LoginPageHandle {
    public BaseDriver driver;
    public loginPage lp;
    public  LoginPageHandle(BaseDriver driver){
       this.driver = driver;
        lp=new loginPage(driver);
    }

    public  void  sendkeyUsername(String username){
       lp.sendKey(lp.getUserElement(),username);
    }

    public  void  sendkeyPassword(String password){
        lp.sendKey(lp.getPasswordElement(),password);
    }

    public void clickButton(){
        lp.click(lp.getLoginButtonElement());
    }


    /**
     * 判断页面是否显示
     * @return
     */
    public  boolean isDisplay() {
        return  lp.isDisplay(lp.getUserElement());
    }
}
