package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *@ClassName testA
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/22 17:17
 *@Version 1.0
 **/

@Setter
@Getter
@ToString
public class TestA {
    private String className;
    private TestB testB;

    public TestA(){
        this.className = "Class Name: testA";
        System.out.println("testA 无参构造器......");

    }

    public TestA(TestB testB){
        this.className = "Class Name: testA";
        System.out.println("testA 有参构造器......");
        this.testB = testB;
    }
}
