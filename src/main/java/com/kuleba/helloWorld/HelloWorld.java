package com.kuleba.helloWorld;

import com.kuleba.helloWorld.services.MessageService;
import com.kuleba.helloWorld.services.impl.MessageServiceImpl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class HelloWorld {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();

        MessageService service = new MessageServiceImpl();

        int hour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        String partOfDay = service.getDayPart(hour);
        String message = service.getMessageFromBundle(locale, partOfDay);
        service.printMessage(message);

    }

}
