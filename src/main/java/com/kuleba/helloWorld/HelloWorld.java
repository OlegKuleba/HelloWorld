package com.kuleba.helloWorld;

import com.kuleba.helloWorld.services.MessageService;
import org.apache.log4j.Logger;

import java.util.Locale;

public class HelloWorld {

    private static Logger logger = Logger.getLogger(HelloWorld.class.getSimpleName());

    public static void main(String[] args) {

        logger.info("App was started");

        Locale locale = Locale.getDefault();

        logger.info("Locale is " + locale);

        MessageService service = new MessageService();
        String partOfDay = service.getDayPart();
        String message = service.getMessageFromBundle(locale, partOfDay);
        service.printMessage(message);

        logger.info("App was ended");

    }

}
