package com.kuleba.helloWorld.services;

import java.util.Locale;

public interface MessageService {

    String getDayPart();
    String getMessageFromBundle(Locale locale, String partOfDay);
    void printMessage(String message);

}
