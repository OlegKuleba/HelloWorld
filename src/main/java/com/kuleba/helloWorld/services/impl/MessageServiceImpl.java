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
        logger.info("Receiving a part of a day");
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
        logger.info("Receiving a part of a day: " + partOfDay);
        return partOfDay;
    }

    public String getMessageFromBundle(Locale locale, String partOfDay) {
        logger.info("Receiving a message from a bundle");
        String message = null;
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
            message = resourceBundle.getString(partOfDay);
            logger.info("Receiving a message from a bundle: " + message);
        } catch (MissingResourceException ex) {
            logger.error("Exception: ", ex);
        }
        return message;
    }

    public void printMessage(String message) {
        logger.info("Printing message to console");
        if (message != null && !message.isEmpty()) {
            System.out.println(message);
            logger.info("Printing message to console: " + message);
        } else {
            logger.warn("Nothing to print");
        }
    }

}
