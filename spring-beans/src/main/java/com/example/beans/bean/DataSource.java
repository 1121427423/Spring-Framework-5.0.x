package com.example.beans.bean;

import lombok.*;

/**
 *@ClassName DataSource
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/18 23:17
 *@Version 1.0
 **/

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DataSource {
    private String host;
    private String name;
    private String password;
}
