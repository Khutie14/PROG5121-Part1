package com.mycompany.quickchat;

import java.util.Scanner;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class Message {

    public boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    public String checkRecipientCell(String recipient) {
        // Regex adapted from Zalatos (2016)
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        if (recipient.matches(regex)) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    public String createMessageHash(String messageID, int messageNum, String message) {
        String idPrefix = messageID.substring(0, 2);
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        return idPrefix + ":" + messageNum + ":" + firstWord + lastWord;
    }

    public String SentMessage(Scanner scanner) {
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message to send later");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1: return "Message successfully sent";
            case 2: return "Press 0 to delete the message";
            case 3: return "Message successfully stored";
            default: return "Invalid selection.";
        }
    }

    // Store message in a JSON file
    public String storeMessage(String messageID, String recipient, String message) {
        MessageData data = new MessageData(messageID, recipient, message);
        Gson gson = new Gson();
        
        try (FileWriter writer = new FileWriter("stored_messages.json", true)) {
            gson.toJson(data, writer);
            writer.write("\n"); // Add a newline for the next message
            return "Message successfully stored";
        } catch (IOException e) {
            return "Error storing message: " + e.getMessage();
        }
    }

    // A small helper class for Gson to format our JSON
    class MessageData {
        String messageID;
        String recipient;
        String message;
        
        MessageData(String id, String rec, String msg) {
            this.messageID = id;
            this.recipient = rec;
            this.message = msg;
        }
    }
}