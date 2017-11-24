package Pro;

import Handle.SureOrderHandle;
import Unit.BaseDriver;

import java.sql.Driver;

public class SureOrderPro {

    public BaseDriver driver;
    public SureOrderHandle soh;

    public SureOrderPro(BaseDriver driver){
        this.driver=driver;
        soh= new SureOrderHandle(driver);
    }

    /**
     *  确认流程
     */
    public  void buyNow(){
        soh.clickSureButton();
    }

}
