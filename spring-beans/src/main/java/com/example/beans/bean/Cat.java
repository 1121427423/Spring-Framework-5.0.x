package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author 11214
 * @Date 2021/5/27 23:07
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
@Component
public class Cat {

    private String name;
    private String age;
    private String type;

    public Cat(){
        System.out.println("Cat : constructor");
    };

    @PostConstruct
    public void init(){
        System.out.println("Cat : @PostConstruct注解标注的init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Cat : @PreDestroy注解标注的destroy method");
    }
}
