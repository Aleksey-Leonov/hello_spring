package ru.azor;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component//("like")
@Profile("like")
public class LikeMessageProvider implements MessageProvider {
    @InjectFoodStuff
    private String foodStuff;

    @Override
    public String getMessage() {
        return "I like " + foodStuff;
    }
}
