package ru.azor;

import java.util.Properties;

public class MessageSupportFactory {
    private static final MessageSupportFactory instance;
    private MessageRender messageRender;

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRender getMessageRender() {
        return messageRender;
    }

    private MessageSupportFactory(){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/message-context.properties"));
            String renderClass = properties.getProperty("render.class");
            String providerClass = properties.getProperty("provider.class");
            messageRender = (MessageRender) Class.forName(renderClass).getDeclaredConstructor().newInstance();
            MessageProvider messageProvider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
//            messageRender.setMessageProvider(messageProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
