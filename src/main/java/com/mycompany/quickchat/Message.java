package com.mycompany.quickchat;
import java.util.Scanner;
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
    }// Step 5: Allow user to choose to send, disregard, or store
    public String SentMessage(Scanner scanner) {
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                return "Message successfully sent";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return "Message successfully stored";
            default:
                return "Invalid selection.";
        }
    }}