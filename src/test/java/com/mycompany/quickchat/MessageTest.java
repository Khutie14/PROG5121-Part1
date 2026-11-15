package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    Message msg = new Message();

    // Test Message Length (Success)
    @Test
    public void testMessageLengthSuccess() {
        String testMessage = "Hi Mike, can you join us for dinner tonight?";
        assertEquals("Message ready to send.", msg.checkMessageLength(testMessage));
    }

    // Test Message Length (Failure)
    @Test
    public void testMessageLengthFailure() {
        // Creating a message longer than 250 characters
        String longMessage = "A".repeat(255); 
        assertEquals("Message exceeds 250 characters by 5; please reduce the size.", msg.checkMessageLength(longMessage));
    }

    // Test Recipient Cell Number (Success)
    @Test
    public void testRecipientCellSuccess() {
        String testCell = "+27718693002";
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell(testCell));
    }

    // Test Recipient Cell Number (Failure)
    @Test
    public void testRecipientCellFailure() {
        String testCell = "08575975889"; // Missing international code
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell(testCell));
    }

    // Test Message Hash Generation
    @Test
    public void testCreateMessageHash() {
        // Test data from the brief: ID starts with 00, message num is 0, message is "Hi Mike... tonight?"
        String testID = "0012345678";
        int testNum = 0;
        String testMessage = "Hi Mike, can you join us for dinner tonight?";
        
        // Expected output: 00:0:HITONIGHT
        assertEquals("00:0:HITONIGHT", msg.createMessageHash(testID, testNum, testMessage));
    }
    
    // Test Message ID length
    @Test
    public void testMessageID() {
        assertTrue(msg.checkMessageID("1234567890")); // 10 characters
        assertFalse(msg.checkMessageID("12345678901")); // 11 characters
    }
}