package com.ljj.springboot_email.test;

import com.ljj.springboot_email.core.MailSender;
import com.ljj.springboot_email.enums.MailContentTypeEnum;

import java.util.ArrayList;

/**
 * @Auther: ljj
 * @Date: 2019/6/3 22:28
 * @Description:
 */
public class TestMail {
    public static void main(String[] args) throws Exception {
        new MailSender()
                .title("测试邮件发送")
                .content("这儿是文本内容")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){
                    {add("2693986772@qq.com");}
                })
                .send();
    }
}
