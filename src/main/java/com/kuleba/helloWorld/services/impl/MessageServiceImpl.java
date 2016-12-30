package com.kuleba.helloWorld.services.impl;

import com.kuleba.helloWorld.services.MessageService;
import org.apache.log4j.Logger;

import java.util.*;

public class MessageServiceImpl implements MessageService {

    public static final int END_OF_NIGHT = 6;
    public static final int END_OF_MORNING = 9;
    public static final int END_OF_DAY = 19;
    public static final int END_OF_EVENING = 23;

    private static Logger logger = Logger.getLogger(MessageServiceImpl.class.getSimpleName());

    public MessageServiceImpl() {
    }

    public String getDayPart() {
        int hour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        String partOfDay;
        if (hour >= END_OF_NIGHT && hour < END_OF_MORNING) {
            partOfDay = "morning";
        } else if (hour < END_OF_DAY) {
            partOfDay = "day";
        } else if (hour < END_OF_EVENING) {
            partOfDay = "evening";
        } else {
            partOfDay = "night";
        }
        logger.info("Got a part of a day");
        return partOfDay;
    }

    public String getMessageFromBundle(Locale locale, String partOfDay) {
        String message = null;
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
            message = resourceBundle.getString(partOfDay);
            logger.info("Got a message from a bundle");
        } catch (MissingResourceException ex) {
            logger.error("Exception: ", ex);
        }
        return message;
    }

    public void printMessage(String message) {
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
            logger.info("Message was printed to console");
        } else {
            logger.warn("Nothing to print");
        }
    }

}
