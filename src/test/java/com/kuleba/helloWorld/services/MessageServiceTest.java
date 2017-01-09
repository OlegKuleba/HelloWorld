package com.kuleba.helloWorld.services;

import com.kuleba.helloWorld.services.impl.MessageServiceImpl;
import org.easymock.EasyMockRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.Locale;

@RunWith(EasyMockRunner.class)
public class MessageServiceTest {

    // getDayPart(int hour) tests
    @Test
    public void testGetMorning() {
        MessageService messageService = new MessageServiceImpl();
        int hour = 7;
        String partOfDay = messageService.getDayPart(hour);
        Assert.assertEquals("morning", partOfDay);
    }
    @Test
    public void testGetMorningBorder() {
        MessageService messageService = new MessageServiceImpl();
        int hour = 6;
        String partOfDay = messageService.getDayPart(hour);
        Assert.assertEquals("morning", partOfDay);
    }

    @Test
    public void testGetDay() {
        MessageService messageService = new MessageServiceImpl();
        int hour = 12;
        String partOfDay = messageService.getDayPart(hour);
        Assert.assertEquals("day", partOfDay);
    }

    @Test
    public void testGetEvening() {
        MessageService messageService = new MessageServiceImpl();
        int hour = 20;
        String partOfDay = messageService.getDayPart(hour);
        Assert.assertEquals("evening", partOfDay);
    }

    @Test
    public void testGetNight() {
        MessageService messageService = new MessageServiceImpl();
        int hour = 0;
        String partOfDay = messageService.getDayPart(hour);
        Assert.assertEquals("night", partOfDay);
    }

    // getMessageFromBundle(Locale locale, String partOfDay) tests
    @Test
    public void testPrintMessage() throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        MessageService messageService = new MessageServiceImpl();
        String message = "Good day, World!";
        messageService.printMessage(message);
        byteStream.flush();
        String printedMessage = new String(byteStream.toByteArray());
        Assert.assertTrue(printedMessage.contains(message));
    }

    @Test
    public void testPrintNullMessage() throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        MessageService messageService = new MessageServiceImpl();
        messageService.printMessage(null);
        byteStream.flush();
        String printedMessage = new String(byteStream.toByteArray());
        Assert.assertTrue("Nothing to print", printedMessage.isEmpty());
    }

    @Test
    public void testPrintEmptyMessage() throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        MessageService messageService = new MessageServiceImpl();
        messageService.printMessage("");
        byteStream.flush();
        String printedMessage = new String(byteStream.toByteArray());
        Assert.assertTrue("Nothing to print", printedMessage.isEmpty());
    }

    // printMessage(String message) tests
    @Test
    public  void testEnLocale() {
        Locale.setDefault(Locale.ENGLISH);
        String partOfDay = "day";
        String msg = new MessageServiceImpl().getMessageFromBundle(Locale.getDefault(), partOfDay);
        Assert.assertEquals("Good day, World!", msg);
    }

    @Test
    public  void testRuLocale() {
        Locale.setDefault(new Locale("ru"));
        String partOfDay = "day";
        String msg = new MessageServiceImpl().getMessageFromBundle(Locale.getDefault(), partOfDay);
        Assert.assertEquals("Добрый день, Мир!", msg);
    }

    @Test
    public  void testDefaultLocale() {
        Locale.setDefault(new Locale("es"));
        String partOfDay = "day";
        String msg = new MessageServiceImpl().getMessageFromBundle(Locale.getDefault(), partOfDay);
        Assert.assertEquals("Good day, World!", msg);
    }

}
