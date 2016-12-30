package com.kuleba.helloWorld.services;

import com.kuleba.helloWorld.services.impl.MessageServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class MessageServiceTest {

    @Test
    public void testGetDayPart() throws Exception {
        MessageService messageService = new MessageServiceImpl();
        String partOfDay = messageService.getDayPart();
        Assert.assertTrue(partOfDay.matches("morning|day|evening|night"));
    }


}
