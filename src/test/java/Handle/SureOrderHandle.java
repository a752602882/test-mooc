package Handle;

import Page.SureOrderPage;
import Unit.BaseDriver;
import Unit.GetByLocator;

public class SureOrderHandle {

    public BaseDriver driver;
    public SureOrderPage sop;

    public SureOrderHandle(BaseDriver driver){
       this.driver = driver;
       sop= new SureOrderPage(driver);
    }

    /**
     * 点击确认订单element
     */
    public  void clickSureButton(){
        sop.click(sop.getSubOrderElement());
    }
}
