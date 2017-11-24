package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SureOrderPage extends BasePage{
    public SureOrderPage(BaseDriver driver) {
        super(driver);
    }


    /**
     * 获取提交订单按钮
     */
    public WebElement getSubOrderElement(){
        return  element(GetByLocator.getByLocator("buy_sure"));
    }
}

