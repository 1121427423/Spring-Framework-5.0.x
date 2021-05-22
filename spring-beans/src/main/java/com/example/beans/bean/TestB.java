package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName testB
 * @Description TODO
 * @Author 11214
 * @Date 2021/5/22 17:23
 * @Version 1.0
 **/

@Setter
@Getter
@ToString
public class TestB {
    private String className;
    private TestC testC;

    public TestB(){
        this.className = "Class Name: testB";
        System.out.println("testB 无参构造器......");
    }

    public TestB(TestC testC){
        this.className = "Class Name: testB";
        System.out.println("testB 有参构造器......");
        this.testC = testC;
    }
}
