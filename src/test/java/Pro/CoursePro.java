package Pro;

import Handle.CoursePageHandle;
import Unit.BaseDriver;

import java.sql.Driver;

import static java.lang.Thread.sleep;

//业务
public class CoursePro  {
    public BaseDriver driver;
    public CoursePageHandle  cph;

    public CoursePro(BaseDriver driver){
        this.driver = driver;
        cph =  new CoursePageHandle(driver);
    }

    /**
     * 添加购物车
     */
    public void addCart()  {
       String courseNum  =  cph.getShopCartNum();
       int beforeNum;
       int afterNum;
        try {
          beforeNum =Integer.valueOf(courseNum);
      }catch (Exception o){
          beforeNum=0;
      }
      cph.clickAddCart();

        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //   driver.switchToMode();
      cph.clickReadBuy();



      courseNum= cph.getShopCartNum();


        try {
             afterNum = Integer.valueOf(courseNum);
             System.out.println("afterNum之前"+afterNum);
            sleep(2000);
        }catch (Exception o){
            afterNum=beforeNum;
        }


          System.out.println("afterNum之后"+afterNum);
          System.out.println("添加购物车成功");
          //cph.clickShopCart();

         //driver.switchToMode();
         cph.clickBuyNow();

    }
}
