package ru.azor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class HelloSpring {
    public static void main(String[] args) {
//       MessageRender messageRender = MessageSupportFactory.getInstance().getMessageRender();
//        messageRender.render();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        for (int i = 0; i < 5; i++) {
            MessageRender messageRender = context.getBean(MessageRender.class);
            messageRender.render();
        }
        context.close();
    }
}
