package com.example.beans.bean;

/**
 *@ClassName GetBeanTest
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/17 21:24
 *@Version 1.0
 **/
public abstract class GetBeanTest {
    public void showMe(){
        this.getBean().showMe();
    }

    public abstract User getBean();
}
