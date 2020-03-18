package com.allwayz.freeseed;

import com.allwayz.freeseed.util.MailUtil;
import com.allwayz.freeseed.util.OhMyEmailUtil.OhMyEmail;
import com.allwayz.freeseed.util.OhMyEmailUtil.SendMailException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.allwayz.freeseed.util.OhMyEmailUtil.OhMyEmail.SMTP_QQ;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMailUtil {
    @Before
    public void before() {
        // 配置，一次即可
        OhMyEmail.config(SMTP_QQ(true), "2584491610@qq.com", "bbtmcybrvxbddhic");
        // 如果是企业邮箱则使用下面配置
        //OhMyEmail.config(SMTP_ENT_QQ(false), "xxx@qq.com", "*******");
    }

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
