package Page;

import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.WebElement;

public class CoursePage extends  BasePage {

    public CoursePage(BaseDriver driver) {
        super(driver);
    }


    /**
     * 获取购买课程按钮
     */
    public  WebElement getBuytriggerElement(){
        return element(GetByLocator.getByLocator("buy_now"));
    }

    /**
     * 获取添加购物车element
     */
    public  WebElement getAddCartElement(){
        return element(GetByLocator.getByLocator("addCart"));
    }
    /**
     * 获取右上角购物车element
     */
    public  WebElement getShopCartElement(){
        return element(GetByLocator.getByLocator("shopCart"));
    }

    /**
     * 获取购物车数量element
     */
    public  String getShopCartNumElement(){
        return element(GetByLocator.getByLocator("cartNum")).getText();
    }
    /**
     * 获取课程详情页面左上角课程吗element
     */
    public  WebElement getCourseNameElement(){
        return element(GetByLocator.getByLocator("buy_now"));
    }

    /**
     * 通过子父节点定位已购买弹窗
     */
    public WebElement getReadBuy(){
      return elementNode(GetByLocator.getByLocator("moco-modal-layer"),GetByLocator.getByLocator("moco-btn"));
    }
}
