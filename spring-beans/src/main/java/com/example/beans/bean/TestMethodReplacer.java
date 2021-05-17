package com.example.beans.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 *@ClassName TestMethodReplacer
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/17 21:57
 *@Version 1.0
 **/
public class TestMethodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("我替换了teacher的showMe方法");
        return null;
    }
}
