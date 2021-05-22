package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName TestC
 * @Description TODO
 * @Author 11214
 * @Date 2021/5/22 17:25
 * @Version 1.0
 **/

@Setter
@Getter
@ToString
public class TestC {
    private String className;
    private TestA testA;

    public TestC(){
        this.className = "Class Name: testC";
        System.out.println("testC 无参构造器......");
    }

    public TestC(TestA testA){
        this.className = "Class Name: testC";
        System.out.println("testC 构造器......");
        this.testA = testA;
    }
}
