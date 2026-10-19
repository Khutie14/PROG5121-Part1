package com.mycompany.quickchat;

public class Message {

    // Check if Message ID is not more than 10 characters
    public boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    // Check recipient cell number (no more than 10 chars + intl code)
    public String checkRecipientCell(String recipient) {
        // Regex adapted from Zalatos (2016)
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        
        if (recipient.matches(regex)) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
// Check if message is not more than 250 characters
    public String checkMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    // Create Message Hash (e.g., 00:0:HITHANKS)
    public String createMessageHash(String messageID, int messageNum, String message) {
        String idPrefix = messageID.substring(0, 2);
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        
        return idPrefix + ":" + messageNum + ":" + firstWord + lastWord;
    }}