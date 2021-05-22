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
public class CyclePostProcessor implements BeanPostProcessor {

    // 前置处理器
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        if (beanClass == Cycle.class) {
            System.out.println("bean 对象初始化之前······");
        }
        return bean;
    }

    // 后置处理器 --- 此处具体的实现用的是Java中的动态代理
    public Object postProcessAfterInitialization(final Object beanInstance, String beanName) throws BeansException {
    // 为当前 bean 对象注册监控代理对象，负责增强 bean 对象方法的能力
        Class beanClass = beanInstance.getClass();
        if (beanClass == Cycle.class) {
//            Object proxy = Proxy.newProxyInstance(beanInstance.getClass().getClassLoader(),beanInstance.getClass().getInterfaces(), (proxy1, method, args) -> {
//                System.out.println("Cycle 中的 doSome() 被拦截了···");
//                String result = (String) method.invoke(beanInstance, args);
//                return result.toUpperCase();
//            });
//            return proxy;
            System.out.println("bean 对象初始化之后······");
        }
        return beanInstance;
    }
}
