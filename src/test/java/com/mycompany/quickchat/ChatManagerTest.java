package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChatManagerTest {

    @Test
    public void testSentMessagesArrayPopulated() {
        ChatManager cm = new ChatManager();
        cm.sentMessages.add("Did you get the cake?");
        cm.sentMessages.add("It is dinner time!");
        
        assertEquals("Did you get the cake?", cm.sentMessages.get(0));
        assertEquals("It is dinner time!", cm.sentMessages.get(1));
    }

    @Test
    public void testLongestMessage() {
        ChatManager cm = new ChatManager();
        cm.storedMessages.add("+27834557896|Did you get the cake?");
        cm.storedMessages.add("+27838884567|Where are you? You are late! I have asked you to be on time.");
        cm.storedMessages.add("+27834484567|Yohoooo, I am at your gate.");
        
        String expected = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expected, cm.getLongestMessage());
    }

    @Test
    public void testSearchByMessageID() {
        ChatManager cm = new ChatManager();
        cm.messageIDs.add("0838884567");
        cm.storedMessages.add("Developer|It is dinner time!");
        
        String result = cm.searchByMessageID("0838884567");
        assertTrue(result.contains("It is dinner time!"));
    }

    @Test
    public void testDeleteByHash() {
        ChatManager cm = new ChatManager();
        cm.messageHashes.add("12:1:HITIME");
        cm.messageIDs.add("1234567890");
        cm.storedMessages.add("+27838884567|Where are you? You are late! I have asked you to be on time.");
        
        String result = cm.deleteByHash("12:1:HITIME");
        assertEquals("Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.", result);
        assertEquals(0, cm.storedMessages.size());
    }
}