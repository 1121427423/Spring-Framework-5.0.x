package com.example.beans.bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 *@ClassName CarPostProcessor
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/21 22:15
 *@Version 1.0
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 前置处理器
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println( beanName + " :  对象初始化之前.....postProcessBeforeInitialization······");
        return bean;
    }

    // 后置处理器 --- 此处具体的实现用的是Java中的动态代理
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println( beanName + " :  对象初始化之后.....postProcessAfterInitialization······");
        return bean;
    }
}
