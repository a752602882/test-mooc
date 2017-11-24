package Handle;

import Page.BasePage;
import Page.CoursePage;
import Unit.BaseDriver;
import org.openqa.selenium.WebElement;

//对该页面的操作
public class CoursePageHandle
{

    public BaseDriver driver;
    public CoursePage coursePage;

    public CoursePageHandle(BaseDriver driver){
        this.driver= driver;
        coursePage = new CoursePage(driver);
    }


    /**
     * 在商品详情页面点击购买elements
     */
    public void clickBuyNow(){
        coursePage.click(coursePage.getBuytriggerElement());
     //    coursePage.getBuytriggerElement().click();
    }

    /**
     * 在商品详情页面点击添加购物车elements
     */
    public void clickAddCart(){
        coursePage.click(coursePage.getAddCartElement());
    }

    /**
     * 点击右上角购物车
     */
    public void clickShopCart(){
        coursePage.click(coursePage.getShopCartElement());
    }
    /**
     * 获取购物车数量
     * */
    public String getShopCartNum(){
      return   coursePage.getShopCartNumElement();
    }
    /**
     * 获取课程名称
     * */
    public String getCourseName(){
      return coursePage.getText(coursePage.getCourseNameElement());
    }
    /**
     * 去结算
     * */
    public void clickGoPay(){
        //coursePage.ge
    }
    /**
     * 点击已经购买弹窗的确定按钮
     * */
    public void clickReadBuy(){
       coursePage.click(coursePage.getReadBuy());
    }

}
