package com.example.beans.bean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *@ClassName MyNamespaceHandler
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/19 0:19
 *@Version 1.0
 **/
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
