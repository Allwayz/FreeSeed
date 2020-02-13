package com.allwayz.freeseed;

import com.allwayz.freeseed.util.MailUtil;
import io.github.biezhi.ome.SendMailException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMailUtil {

//    @Autowired
//    private MailUtil mailUtil;

    /**
     * 配置的是465端口，但是还是显示 25端口拒绝链接
     *
     * @throws SendMailException
     */
    @Test
    public void testWelcome() throws SendMailException {
        String email = "allwayzio@126.com";
        String username = "Allwayz";
        MailUtil.sendWelcomeEmail(email,username);
    }

    @Test
    public void testAuthorizationCode() throws SendMailException {
        String email = "allwayzio@126.com";
        MailUtil.sendAuthorizationCodeEmail(email);
    }

}
