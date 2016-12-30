package com.kuleba.helloWorld;

import com.kuleba.helloWorld.services.MessageService;
import com.kuleba.helloWorld.services.impl.MessageServiceImpl;

import java.util.Locale;

public class HelloWorld {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();

        MessageService service = new MessageServiceImpl();
        String partOfDay = service.getDayPart();
        String message = service.getMessageFromBundle(locale, partOfDay);
        service.printMessage(message);

    }

}
