package ru.azor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class HelloConfiguration {
//    @Bean
//    public MessageProvider provider(){
//        return new WantMessageProvider();
//    }
//
//    @Bean
//    public MessageRender render(){
//        MessageRender messageRender = new ConsoleMessageRender();
//        messageRender.setMessageProvider(provider());
//        return messageRender;
//    }
}
