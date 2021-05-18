package com.example.beans.bean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 *@ClassName UserBeanDefinitionParser
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/19 0:09
 *@Version 1.0
 **/
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    //Element对应的类
    protected Class getBeanClass(Element element){
        return User.class;
    }

    //从element中解析并提取对应的元素
    protected void doParse(Element element, BeanDefinitionBuilder bean){
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");

        if(StringUtils.hasText(name)){
            bean.addPropertyValue("name",name);
        }

        if(StringUtils.hasText(age)){
            bean.addPropertyValue("age",age);
        }

    }
}
