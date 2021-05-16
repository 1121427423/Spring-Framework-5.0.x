package com.example.beans;

import com.example.beans.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

@SpringBootTest
class BeansApplicationTests {

    @Test
    void testXMLBeanFactory() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        User userBean = (User) bf.getBean("User");
        System.out.println(userBean);
    }

}
