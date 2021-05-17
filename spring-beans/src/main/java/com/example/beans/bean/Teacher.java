package com.example.beans.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *@ClassName Teacher
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/16 17:33
 *@Version 1.0
 **/
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Teacher extends User{
    private String name;
    private Integer age;
    private String sex;
    private String School;
    private String className;

    //覆盖父类User showMe()方法
    public void showMe(){
        System.out.println("I am teacher");
    }
}
