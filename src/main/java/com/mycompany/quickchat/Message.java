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
}