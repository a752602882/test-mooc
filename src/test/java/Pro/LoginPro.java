package Pro;

import Handle.LoginPageHandle;
import Unit.BaseDriver;

public class LoginPro {

    public LoginPageHandle lph;
    public  LoginPro(BaseDriver driver){
        lph = new LoginPageHandle(driver);
    }

    public  void login(String username,String password){
      // if (lph.lp.isDisplay(lph.lp.getUserElement()))
        if (lph.isDisplay()) {
            lph.sendkeyUsername(username);
            lph.sendkeyPassword(password);
            lph.clickButton();
        }else {
            System.out.println("没有检查到元素");
        }

    }
}
