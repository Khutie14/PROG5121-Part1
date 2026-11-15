package com.mycompany.quickchat;

import java.util.ArrayList;

public class ChatManager {
    public ArrayList<String> sentMessages = new ArrayList<>();
    public ArrayList<String> disregardedMessages = new ArrayList<>();
    public ArrayList<String> storedMessages = new ArrayList<>();
    public ArrayList<String> messageHashes = new ArrayList<>();
    public ArrayList<String> messageIDs = new ArrayList<>();

    public void displayStoredMessages(String sender) {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        for (int i = 0; i < storedMessages.size(); i++) {
            System.out.println("Sender: " + sender + " | Recipient: " + storedMessages.get(i).split("\\|")[0]);
        }
    }

    public String getLongestMessage() {
        String longest = "";
        for (String msg : storedMessages) {
            String[] parts = msg.split("\\|");
            if (parts.length > 1 && parts[1].length() > longest.length()) {
                longest = parts[1];
            }
        }
        return longest.isEmpty() ? "No messages found." : longest;
    }

    public String searchByMessageID(String id) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(id)) {
                return "Recipient: " + storedMessages.get(i).split("\\|")[0] + 
                       " | Message: " + storedMessages.get(i).split("\\|")[1];
            }
        }
        return "Message ID not found.";
    }

    public void searchByRecipient(String recipient) {
        boolean found = false;
        for (String msg : storedMessages) {
            String[] parts = msg.split("\\|");
            if (parts.length > 1 && parts[0].equals(recipient)) {
                System.out.println("Message: " + parts[1]);
                found = true;
            }
        }
        if (!found) System.out.println("No messages found for " + recipient);
    }

    public String deleteByHash(String hash) {
        int index = messageHashes.indexOf(hash);
        if (index != -1) {
            String deletedMsg = storedMessages.get(index).split("\\|")[1];
            storedMessages.remove(index);
            messageHashes.remove(index);
            messageIDs.remove(index);
            return "Message: \"" + deletedMsg + "\" successfully deleted.";
        }
        return "Message hash not found.";
    }

    public void displayReport() {
        System.out.println("\n--- STORED MESSAGES REPORT ---");
        for (int i = 0; i < storedMessages.size(); i++) {
            System.out.println("Hash: " + messageHashes.get(i));
            System.out.println("ID: " + messageIDs.get(i));
            System.out.println("Recipient & Message: " + storedMessages.get(i));
            System.out.println("------------------------------");
        }
    }
}