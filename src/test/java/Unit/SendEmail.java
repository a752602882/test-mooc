package Unit;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

    public static void sendToEmail(String connect) {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("18780113305@163.com", "5423110ppp");
        try {

            email.setFrom("18780113305@163.com");
            email.addCc("18780113305@163.com");
            email.addTo("752602882@qq.com");
            email.setSubject("自动化测试邀请函");
            email.setContent(connect, "text/html;charset=utf-8");
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s ="sssssss";
        sendToEmail(s);
    }
}
