package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

public class HomePage extends  BasePage {
    public HomePage(BaseDriver driver) {
        super(driver);
    }







    /**
     * 获得右上角登录角色用户名element
     */
    public WebElement getUserNameElement() {
       action(element(GetByLocator.getByLocator("header_avator_btn")));
       return element(GetByLocator.getByLocator("name_btn"));
    }

}
