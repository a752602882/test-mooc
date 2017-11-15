package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//封装登录
public class loginPage extends  BasePage{

    public loginPage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 获取用户Element
     * @return
     */
    public WebElement getUserElement(){
        return  element(GetByLocator.getByLocator("email_btn"));
    }

    /**
     * 获取密码Element
     * @return
     */
    public WebElement getPasswordElement(){
        return  element(GetByLocator.getByLocator("password_btn"));
    }
    /**
     * 获取登录按钮Element
     * @return
     */
    public WebElement getLoginButtonElement(){
        return  element(GetByLocator.getByLocator("red_btn"));
    }
}
