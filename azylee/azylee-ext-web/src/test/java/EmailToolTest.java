import com.yuzhyn.azylee.ext.web.mails.EmailTool;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import java.util.Arrays;

public class EmailToolTest {
    public static void main(String[] args) throws Exception {
        EmailTool emailTool = new EmailTool("hi_notice@163.com","系统邮箱","",994,true,"smtp.163.com");
        emailTool.createSession();
        Address[] addresses = emailTool.createAddress(Arrays.asList("yuzhyn@163.com"));
        emailTool.sendMessage(addresses,"注册邮件-测试","验证码为：10023");
    }
}
