package com.ljj.springboot_email.enums;

/**
 * @Auther: ljj
 * @Date: 2019/6/3 20:51
 * @Description:
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;
    MailContentTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
