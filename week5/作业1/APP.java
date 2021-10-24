package com.tgt.common.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
    public static void main(String[] args) {
        //启动spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //1. 根据类的空参构造函数构建简单的bean实例,默认是单例的(在这个容器中)
        Boy dogSimple=(Boy) context.getBean("dogSimple");

        System.out.println(dogSimple.show());
        Boy dogSimple2=(Boy) context.getBean("dogSimple");

        System.out.println(dogSimple2==dogSimple);

        //2.根据类的带参构造函数构建简单的bean实例,参数为简单类型
        Boy dogConstructor=(Boy) context.getBean("dogConstructor");

        System.out.println(dogConstructor.show());

        //3.根据类的带参构造函数构建简单的bean实例,参数为集合类型
        Boy dogConstructorList=(Boy) context.getBean("dogConstructorList");

        System.out.println(dogConstructorList.show());

        //4. 根据根据类的带参构造函数构建简单的bean实例,参数为引用类型
        Actor actorConstructorRef=(Actor) context.getBean("actorConstructorRef");

        System.out.println(actorConstructorRef.dog.show());

        //5.根据类的静态方法构建bean实例,这里用工厂方法模拟了程序内单例的实现
        Stage stage=(Stage) context.getBean("stage");

        System.out.println(stage.show());
        Stage stage2=(Stage) context.getBean("stage");

        System.out.println(stage==stage2);

        //6.根据类的空参构造函数构建简单的bean实例,在这个spring容器内是非单例的,每次获取bean的时候都会重新构建一个新的实例
        Person personPrototype = (Person) context.getBean("personPrototype");
        Person personPrototype2 = (Person) context.getBean("personPrototype");
        //false
        System.out.println(personPrototype==personPrototype2);

        //7.根据类的空参构造函数构建简单的bean实例,并且初始化属性设置
        Person personProperty = (Person) context.getBean("personProperty");

        System.out.println(personProperty);



    }
}
