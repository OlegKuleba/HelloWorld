package com.kuleba.helloWorld.services;

import com.kuleba.helloWorld.services.impl.MessageServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MessageServiceTest {

    @Test
    public void testGetDayPart() throws Exception {
        MessageService messageService = new MessageServiceImpl();
        String partOfDay = messageService.getDayPart();
        Assert.assertTrue(partOfDay.matches("morning|day|evening|night"));
    }

    @Test
    public void testPrintMessage() throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        MessageService messageService = new MessageServiceImpl();
        messageService.printMessage("Test it");
        byteStream.flush();
        String printedMessage = new String(byteStream.toByteArray());
        Assert.assertTrue(printedMessage.contains("Test it"));
    }

    @Test
    public void testPrintNullMessage() throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        MessageService messageService = new MessageServiceImpl();
        messageService.printMessage(null);
        byteStream.flush();
        String printedMessage = new String(byteStream.toByteArray());
        Assert.assertTrue(printedMessage.isEmpty());
    }

    @Test
    public void testPrintEmptyMessage() throws Exception {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
        MessageService messageService = new MessageServiceImpl();
        messageService.printMessage("");
        byteStream.flush();
        String printedMessage = new String(byteStream.toByteArray());
        Assert.assertTrue(printedMessage.isEmpty());
    }

}
