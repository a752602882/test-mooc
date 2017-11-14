package Page;

import Unit.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//封装的页面元素的操作,
/*
  好处1：封装这些操作无非是以后第三方库（selenium）方法名发生改变时不会对自己的项目产生影响
  好处2：使方法更健壮，提示信息....
 */
public class BasePage
{
    public BaseDriver driver;

   public  BasePage(BaseDriver driver){
       this.driver = driver;
   }


    /**
     *  封装定位
     * @param by
     * @return
     */
    public WebElement element(By by){
      WebElement element = driver.findElement(by);
      return element;
    }


    public  void click(WebElement element){
       if (element!=null) {
           element.click();
       }else {
           System.out.println("元素不存在");
       }
    }

    public void sendKey(WebElement element,String value){
        if (element!=null){
            element.sendKeys(value);
        }else{
            System.out.println("元素:"+element+"没有定位到，输入失败："+value);
        }
    }

    public  boolean isDisplay(WebElement element) {
        return element.isDisplayed();
    }

}
