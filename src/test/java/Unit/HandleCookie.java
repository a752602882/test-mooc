package Unit;

import org.openqa.selenium.Cookie;

import java.util.Set;

public class HandleCookie {

    public  BaseDriver driver;
    public  ProUnit proUnit;

    public  HandleCookie(BaseDriver driver){
        this.driver = driver;
        proUnit =new ProUnit("cookie.properties");
    }

    public void setCookie(){
        String value = proUnit.getPro("apsid");
        Cookie cookie = new Cookie("apsid",value,"imooc.com","/",null);
        driver.setCookie(cookie);
    }

    /**
     * 获取cookie
     * */
    public void writeCookie(){
        Set<Cookie> cookies  = driver.getCookie();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("apsid")){
                proUnit.WritePro(cookie.getName(),cookie.getValue());
            }
        }
    }
}
