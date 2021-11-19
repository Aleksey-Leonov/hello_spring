package ru.azor;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component//("want")
//@Primary
@Profile("want")
@Scope("prototype")
public class WantMessageProvider implements MessageProvider {
    @InjectFoodStuff
    private String foodStuff;

    public WantMessageProvider(){
        System.out.println("foodStuff from constructor: " + foodStuff);
    }

    @PostConstruct
    public void init(){
        System.out.println("foodStuff from init: " + foodStuff);

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy");
    }

    @Override
    public String getMessage() {
        return "I want " + foodStuff;
    }
}
