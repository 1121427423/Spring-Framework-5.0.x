package com.example.beans.bean;

import lombok.*;

/**
 *@ClassName cycle
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/20 23:54
 *@Version 1.0
 **/
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Cycle {
    private String brand;
    private Double price;

    public Cycle(){
        System.out.println("cycle 构造器······");
    }

    public void init(){
        System.out.println("Cycle init");
    }

    public void destroy(){
        System.out.println("Cycle destroy");
    }

    public String doSome(){
        return "我是凤凰牌自行车！！！";
    }
}
