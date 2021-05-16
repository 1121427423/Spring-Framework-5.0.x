package com.example.beans.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *@ClassName Student
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/16 17:35
 *@Version 1.0
 **/
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private String sex;
    private String School;
    private String className;
}
