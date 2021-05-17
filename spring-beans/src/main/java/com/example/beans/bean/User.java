package com.example.beans.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 *@ClassName User
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/16 17:29
 *@Version 1.0
 **/

@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String sex;
    private List hobbies;

    public void showMe(){
        System.out.println("I am user");
    }
}
