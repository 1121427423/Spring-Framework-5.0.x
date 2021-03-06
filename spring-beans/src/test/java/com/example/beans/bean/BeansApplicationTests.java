package com.example.beans.bean;

import com.example.beans.bean.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootTest
class BeansApplicationTests {
    /**
     * 默认标签的解析
     */
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

    /**
     * 解析子元素qualifier
     */
    @Test
    void testBeanInQualifier() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        Teacher teacher = (Teacher) bf.getBean("teacher2");
        System.out.println(teacher);
    }

    /**
     * alias标签的解析
     * 注册 alias的method: processAliasRegistration
     * 将beanName与alias组成一对一同注册
     */
    @Test
    void testBeanInAlias() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        User user = (User) bf.getBean("user2");//使用user的别名user2，user3,user4也一样。
        System.out.println(user);
    }

    /**
     * import标签的解析
     * 解析步骤
     * 1、获取resource属性所表示的路径
     * 2、解析路径中的系统属性，格式"${user.dir}"
     * 3、判断location是 绝对路径还是相对路径
     * 4、如果是绝对路径递归调用bean的解析过程，进行另一次的解析
     * 5、如果是相对路径则计算出绝对路径并进行解析
     * 6、通知监听器，解析完成
     */
    @Test
    void testBeanInImport() {
        //不直接解析mybatis.xml,在beanFactoryTest.xml中用import导入mybatis.xml
        ApplicationContext bf1 = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        DataSource dataSource1 = (DataSource) bf1.getBean("dataSource");
        System.out.println(dataSource1);
        //直接解析mybatis.xml
        ApplicationContext bf2 = new ClassPathXmlApplicationContext("mybatis.xml");
        DataSource dataSource2 = (DataSource) bf2.getBean("dataSource2");//使用别名
        System.out.println(dataSource2);
    }

    /**
     * 嵌入式beans标签的解析
     * 与单独的配置文件没有区别，与import功能类似
     * 解析过程采用递归调用bean的解析过程
     */
    @Test
    void testBeanInBeans() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        DataSource dataSource3 = (DataSource) bf.getBean("dataSource3");
        System.out.println(dataSource3);
    }

    /**
     * 扩展自定义标签（需spring-core包）
     * 步骤:
     *    1、创建一个需要扩展的组件
     *    2、定义一个XSD文件描述组件内容
     *    3、创建一个文件，实现BeanDefinitionParser接口，用来解析XSD文件中的定义和组件定义
     *    4、创建一个Handle文件，扩展自NamespaceHandlerSupport,目的是将组件注册到Spring容器
     *    5、编写Spring.handlers和Spring.schemas
     */
    @Test
    void testBeanInCustom() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("Custom.xml");
        User user = (User) bf.getBean("testBean");
        System.out.println(user);
    }

    /**car
     * FactoryBean 测试及使用
     */
    @Test
    void testFactoryBean() throws Exception {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        //获取Car实例,直接调用CarFactoryBean.getObject() 方法返回Car实例
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
        //获取CarFactoryBean实例 返回的是CarFactoryBean
        CarFactoryBean carFactoryBean = (CarFactoryBean) bf.getBean("&car");
        System.out.println(carFactoryBean);  //获取CarFactoryBean实例
        System.out.println(carFactoryBean.getObject());  //获取Car实例
    }

    /**
     * FactoryBean 前置后置处理器的测试及使用
     */
    @Test
    void testBeanPostProcessor() throws Exception {
        AbstractApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        //获取Car实例,直接调用CarFactoryBean.getObject() 方法返回Car实例
        Cycle cycle = (Cycle) bf.getBean("cycle");
        System.out.println(cycle.doSome());
        bf.close();
        //销毁cycle bean
        //cycle.destroy();
    }

    /**
     * 三种方式形成的循环依赖，构造器注入，Setter注入单例，Setter注入原型
     * 构造器注入，Setter注入原型（scope="prototype"）形成的循环依赖无法解决，抛出BeanCurrentlyInCreationException异常
     * Setter注入单例（scope="singleton"）形成的循环依赖可被spring解决，成功创建bean。
     * Constructor Circular Dependency
     * FactoryBean 构造器循环依赖 testA.testB,testC
     */
    @Test
    void testConstructorCircularDependency() throws Exception {

        //构造器注入形成的循环依赖无法解决，抛出异常：BeanCurrentlyInCreationException
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        TestA testA = (TestA) bf.getBean("testA");
        System.out.println(testA);
    }

    /**
     * Setter Circular Dependency
     * Setter方式单例，默认
     * Scope: "singleton"
     * FactoryBean Setter方式循环依赖 testD.testE,testF
     */
    @Test
    void testSetterCircularDependency() throws Exception {
        //setter注入形成的循环依赖,指定testD,testE,testF。 bean的scope属性都为singleton，可解决循环依赖，创建bean成功
        //打印结果：com.example.beans.bean.TestD@1b812421
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        TestD testD = (TestD) bf.getBean("testD");
        System.out.println(testD);
    }

    /**
     * Setter Circular Dependency
     * Setter方式原型，prototype
     * Scope: "prototype"
     * FactoryBean Setter方式循环依赖 testD.testE,testF
     */
    @Test
    void testSetterCircularDependency2() throws Exception {
        //setter注入形成的循环依赖,指定testD,testE,testF。 bean的scope属性都为prototype，抛出异常：BeanCurrentlyInCreationException
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        TestD testD = (TestD) bf.getBean("testD");
        System.out.println(testD);
    }

    /**
     * The lifecycle of the bean
     * Test Bean :Dog,Cat,Rabbit
     * 总结：
     *      @Component标注的bean比在XML中使用<bean></bean>注册的bean先创建，也最后销毁
     *      先创建的bean最迟销毁，类似于出入栈，先入栈的反而越后出栈
     *      bean宏观的生命周期：创建bean----->初始化----->销毁方法
     *      bean细分的生命周期：url:https://www.javazhiyin.com/wp-content/uploads/2019/05/java0-1558500658.jpg
     *                        本地路径：src/main/resources/static/photo/bean的生命周期.jpg
     *      @PostConstruct， @PreDestroy 这两个注解只对使用@Component注解方式有效，XMLz中<bean></bean>注册的bean无效
     *      在初始化bean阶段用户可以加入自己的业务逻辑处理方法————
     *      有以下三种方式 BeanPostProcessor,(InitializingBean, DisposableBean),(@PostConstruct， @PreDestroy)
     *      BeanPostProcessor：拦截所有的bean,可在BeanPostProcessor中对你需要调整的bean自定义，在return bean
     *      InitializingBean: 重写afterPropertiesSet()方法，运行时期：postProcessBeforeInitialization-->afterPropertiesSet-->postProcessAfterInitialization
     *      用注解方式注册的bean 不会走BeanPostProcessor:
     */
    @Test
    void testBeanLifecycle() throws Exception {
        //
        AbstractApplicationContext bf = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        bf.close();
    }
}
