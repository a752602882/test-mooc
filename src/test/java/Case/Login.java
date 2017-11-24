package Case;

import Pro.CoursePro;
import Pro.LoginPro;
import Pro.SureOrderPro;
import Unit.BaseDriver;
import Unit.GetByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class Login extends  CaseBase{

    public BaseDriver driver;
    public LoginPro loginPro;
    public CoursePro coursePro;
    public SureOrderPro sureOrderPro;
  //  public static Logger logger = Logger.getLogger(Login.class);


    @BeforeClass
    public void  init(){
        driver =   InitDriver("chrome");
        loginPro = new LoginPro(driver);
        coursePro = new CoursePro(driver);
        sureOrderPro = new SureOrderPro(driver);
       // getLoginHome();
    }

    @Test
    public  void getLoginHome(){
        driver.get("http://www.imooc.com");
        driver.findElement(By.id("js-signin-btn")).click();
        driver.driver.manage().window().maximize();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods={"getLoginHome"})
    @Parameters({"username","password"})
    public void login(String username,String password){
        loginPro.login(username,password);
    }


    /**
     * 添加购物车
     */
    @Test(dependsOnMethods={"login"})
    public void TestAddCart() {
        try {
            sleep(3000);
            driver.get("http://coding.imooc.com/class/157.html");
            coursePro.addCart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test(dependsOnMethods={"TestAddCart"})
    public void buyNow() {
      /*  try {
            sleep(3000);
            driver.get("http://coding.imooc.com/class/157.html");
            coursePro.addCart();
            System.out.println("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        sureOrderPro.buyNow();
    }



    /*
       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */


/*
       @Test(dependsOnMethods={"getLoginHome"})
    public void downOrder() throws InterruptedException {
        loginPro.login("752602882@qq.com","5423110.");
        sleep(3000);
        driver.get("http://coding.imooc.com/class/157.html");
        //sleep(3000);
        String currentText=buy_order();
        System.out.println("当前课程信息："+currentText);
        submit_order();
        sleep(3000);
        getOrder();
        String orderCurrentText= getOrderCourse();
        System.out.println("订单页面课程信息："+orderCurrentText);
        Assert.assertEquals(currentText,orderCurrentText);
    }*/

    /**
     *   提交订单
     */
    public String buy_order(){
       WebElement element =this.getElement(GetByLocator.getByLocator("path"));
       WebElement elementNode= this.getElementNode(element,GetByLocator.getByLocator("span"));
       String course=elementNode.getText();
       this.getElement(GetByLocator.getByLocator("buy_now")).click();
       return course;
    }
    /**
     *   确认订单
     */
    public void submit_order() throws InterruptedException {
        sleep(3000);
      this.getElement(GetByLocator.getByLocator("buy_sure")).click();

    }

    /**
     * 获取订单号
     */
    public  String getOrder(){

        return this.getElement(GetByLocator.getByLocator("order")).getText();



    }
    /**
     * 获取支付中心信息
     */
    public String getOrderCourse(){

        WebElement element =this.getElement(GetByLocator.getByLocator("item-left"));
        WebElement elementNode= this.getElementNode(element,GetByLocator.getByLocator("dt"));
        String orderText= getCourseText(elementNode);
        return orderText;
    }


    /**
     * 节点
     */
    public WebElement getElement(By by){
      return  driver.findElement(by);
    }
    /**
     * 子节点
     */
    public WebElement getElementNode(WebElement element,By by){
        return  element.findElement(by);
    }

    /**
     * 获取课程信息
     */
    public String getCourseText(WebElement element){
      return  element.getText();
    }
}
