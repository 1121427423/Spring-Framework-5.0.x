package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName Rabbit
 * @Description TODO
 * @Author 11214
 * @Date 2021/5/27 23:11
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
public class Rabbit implements InitializingBean, DisposableBean {
    private String name;
    private String age;
    private String type;

    public Rabbit(){
        System.out.println("Rabbit : constructor");
    };

    @Override
    public void destroy() throws Exception {
        System.out.println("Rabbit : DisposableBean接口的destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Rabbit : InitializingBean接口的afterPropertiesSet method");
    }
}
