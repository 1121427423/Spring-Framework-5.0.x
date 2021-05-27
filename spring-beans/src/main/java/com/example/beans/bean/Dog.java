package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName dog
 * @Description TODO
 * @Author 11214
 * @Date 2021/5/27 23:10
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
public class Dog {
    private String name;
    private String age;
    private String type;


    public Dog(){
        System.out.println("Dog : constructor");
    };

    public void init(){
        System.out.println("Dog  : init method");
    }

    public void destroy(){
        System.out.println("Dog  : destroy method");
    }
}
