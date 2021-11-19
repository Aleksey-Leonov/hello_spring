package ru.azor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Scope("singleton")
public class ConsoleMessageRender implements MessageRender {

//@Qualifier("like")
//    private final MessageProvider messageProvider;

//    public ConsoleMessageRender(MessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }

    @Override
    public void render() {
        System.out.println(getMessageProvider().getMessage());
    }

    @Override
    @Lookup
    public MessageProvider getMessageProvider() {
        return null;
    }


}
