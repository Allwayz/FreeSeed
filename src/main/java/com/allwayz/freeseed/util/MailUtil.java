package com.allwayz.freeseed.util;

import io.github.biezhi.ome.OhMyEmail;
import io.github.biezhi.ome.SendMailException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static io.github.biezhi.ome.OhMyEmail.SMTP_QQ;

public class MailUtil {
    // 该邮箱修改为你需要测试的邮箱地址
    private static final String TO_EMAIL = "allwayzio@126.com";

    @Before
    public void before() {
        // 配置，一次即可
        OhMyEmail.config(SMTP_QQ(false), "2584491610@qq.com", "bbtmcybrvxbddhic");
        // 如果是企业邮箱则使用下面配置
        //OhMyEmail.config(SMTP_ENT_QQ(false), "xxx@qq.com", "*******");
    }

    @Test
    public void testSendText() throws SendMailException {
        OhMyEmail.subject("这是一封测试TEXT邮件")
                .from("小姐姐的邮箱")
                .to(TO_EMAIL)
                .text("信件内容")
                .send();
        Assert.assertTrue(true);
    }

    @Test
    public void testSendHtml() throws SendMailException {
        OhMyEmail.subject("这是一封测试HTML邮件")
                .from("小姐姐的邮箱")
                .to(TO_EMAIL)
                .html("<h1 font=red>信件内容</h1>")
                .send();
        Assert.assertTrue(true);
    }

    @Test
    public void testSendAttach() throws SendMailException {
        OhMyEmail.subject("这是一封测试附件邮件")
                .from("小姐姐的邮箱")
                .to(TO_EMAIL)
                .html("<h1 font=red>信件内容</h1>")
                .attach(new File("/Volumes/Macintosh/Document/git/FreeSeed/src/main/resources/static/asserts/img/FreeSeed.png"), "FreeSeed.png")
                .send();
        Assert.assertTrue(true);
    }

    @Test
    public void testSendAttachURL() throws SendMailException, MalformedURLException {
        OhMyEmail.subject("这是一封测试网络资源作为附件的邮件")
                .from("小姐姐的邮箱")
                .to(TO_EMAIL)
                .html("<h1 font=red>信件内容</h1>")
                .attachURL(new URL("https://avatars1.githubusercontent.com/u/2784452?s=40&v=4"), "测试图片.jpeg")
                .send();
        Assert.assertTrue(true);
    }

//    @Test
//    public void testPebble() throws IOException, PebbleException, SendMailException {
//        PebbleEngine engine = new PebbleEngine.Builder().build();
//        PebbleTemplate compiledTemplate = engine.getTemplate("register.html");
//
//        Map<String, Object> context = new HashMap<String, Object>();
//        context.put("username", "biezhi");
//        context.put("email", "admin@biezhi.me");
//
//        Writer writer = new StringWriter();
//        compiledTemplate.evaluate(writer, context);
//
//        String output = writer.toString();
//        System.out.println(output);
//
//        OhMyEmail.subject("这是一封测试Pebble模板邮件")
//                .from("小姐姐的邮箱")
//                .to(TO_EMAIL)
//                .html(output)
//                .send();
//        Assert.assertTrue(true);
//    }
//
//    @Test
//    public void testJetx() throws SendMailException {
//        JetEngine   engine   = JetEngine.create();
//        JetTemplate template = engine.getTemplate("/register.jetx");
//
//        Map<String, Object> context = new HashMap<String, Object>();
//        context.put("username", "biezhi");
//        context.put("email", "admin@biezhi.me");
//        context.put("url", "<a href='http://biezhi.me'>https://biezhi.me/active/asdkjajdasjdkaweoi</a>");
//
//        StringWriter writer = new StringWriter();
//        template.render(context, writer);
//        String output = writer.toString();
//        System.out.println(output);
//
//        OhMyEmail.subject("这是一封测试Jetx模板邮件")
//                .from("小姐姐的邮箱")
//                .to(TO_EMAIL)
//                .html(output)
//                .send();
//        Assert.assertTrue(true);
//    }
}
