package com.example.beans;

import com.example.beans.bean.GetBeanTest;
import com.example.beans.bean.Student;
import com.example.beans.bean.Teacher;
import com.example.beans.bean.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootTest
class BeansApplicationTests {

    //XML方式注册bean
    @Test
    void testXMLBeanFactory() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        User userBean = (User) bf.getBean("user");
        System.out.println(userBean);
    }
    //XML方式注册bean,解析子元素meta
    @Test
    void testBeanInMeta() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        User userBean = (User) bf.getBean("userForMeta");
        System.out.println("不理解meta标签的用法");
    }

    /**XML方式注册bean,解析子元素look-method,  获取器注入是一种特殊的方法注入，它把一个方法声明为返回某种类型的bean
     *类GetBeanTest中getBean抽象方法未实现，却可以直接调用，这是为什么？答案在xml的bean配置中
     *<lookup-method name="getBean" bean="teacher"/> 返回的是bean是teacher
     *如果teacher的业务有调整换为student，只要修改xml配置 <lookup-method name="getBean" bean="student"/> 返回的是bean是student
     */
    @Test
    void testBeanInLookUpMethod() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        GetBeanTest test = (GetBeanTest) bf.getBean("getBeanTest");
        test.showMe();
    }

    /**解析子元素Replaced-method
     * 方法替换：可以在运行时用新的的方法替换现有的方法，与lookup-method不同的是，replace-method不但可以动态的返回实体bean
     * 而且还能动态的更改原有方法的逻辑
     */
    @Test
    void testBeanInReplacedMethod() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        Teacher teacher = (Teacher) bf.getBean("teacher");
        teacher.showMe();
    }

    /**
     * 解析子元素constructor-arg
     * constructor-arg:通过构造方法注入
     */
    @Test
    void testBeanInConstructor() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        Student student = (Student) bf.getBean("student");
        System.out.println(student);
    }

    /**
     * 解析子元素property
     * property:是通过setter方法注入
     */
    @Test
    void testBeanInProperty() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        User user = (User) bf.getBean("user");
        System.out.println(user);
    }
}
