package com.kuleba.helloWorld.services;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MessageServiceTest {

    @Test
    public void testGetDayPart() throws Exception {
        MessageService messageService = new MessageService();
        String partOfDay = messageService.getDayPart();
        assertTrue(partOfDay.matches("morning|day|evening|night"));
    }

}
