//Final verification for Part 3 submission
package com.mycompany.quickchat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatManager chatManager = new ChatManager();
        
        // --- PART 1: Registration & Login ---
        System.out.println("=== Registration ===");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        Login login = new Login(firstName, lastName);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter SA cell number (+27...): ");
        String cell = scanner.nextLine();

        System.out.println(login.registerUser(username, password, cell));

        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine();

        boolean success = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(success));

        // --- PART 2 & 3: QuickChat Menu ---
        if (success) {
            System.out.println("\nWelcome to QuickChat.");
            System.out.print("How many messages do you wish to enter? ");
            int numMessages = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            boolean running = true;
            while (running) {
                System.out.println("\n--- MENU ---");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.println("4) Stored Messages"); // NEW OPTION
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        for (int i = 1; i <= numMessages; i++) {
                            System.out.println("\n--- Message " + i + " of " + numMessages + " ---");
                            long randomNum = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
                            String messageID = String.valueOf(randomNum);
                            
                            System.out.print("Enter recipient cell number: ");
                            String recipient = scanner.nextLine();
                            
                            Message msg = new Message();
                            System.out.println(msg.checkRecipientCell(recipient));
                            
                            System.out.print("Enter message (max 250 chars): ");
                            String messageText = scanner.nextLine();
                            
                            String lengthCheck = msg.checkMessageLength(messageText);
                            System.out.println(lengthCheck);
                            
                            if (messageText.length() <= 250) {
                                String hash = msg.createMessageHash(messageID, i, messageText);
                                System.out.println("\nMessage ID: " + messageID);
                                System.out.println("Message Hash: " + hash);
                                System.out.println("Recipient: " + recipient);
                                System.out.println("Message: " + messageText);
                                
                                String action = msg.SentMessage(scanner);
                                System.out.println(action);
                                
                                // PART 3: Array Integration
                                if (action.equals("Message successfully sent")) {
                                    chatManager.sentMessages.add(messageText);
                                } else if (action.equals("Message successfully stored")) {
                                    chatManager.storedMessages.add(recipient + "|" + messageText);
                                    chatManager.messageHashes.add(hash);
                                    chatManager.messageIDs.add(messageID);
                                    msg.storeMessage(messageID, recipient, messageText);
                                } else if (action.equals("Press 0 to delete the message")) {
                                    chatManager.disregardedMessages.add(messageText);
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Coming Soon.");
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        running = false;
                        break;
                    case 4:
                        // PART 3: STORED MESSAGES MENU
                        boolean subMenu = true;
                        while (subMenu) {
                            System.out.println("\n--- STORED MESSAGES ---");
                            System.out.println("1) Display sender and recipient");
                            System.out.println("2) Display longest message");
                            System.out.println("3) Search by Message ID");
                            System.out.println("4) Search by Recipient");
                            System.out.println("5) Delete message by Hash");
                            System.out.println("6) Display Report");
                            System.out.println("7) Back to Main Menu");
                            System.out.print("Choose: ");
                            int subChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (subChoice) {
                                case 1: chatManager.displayStoredMessages(loginUser); break;
                                case 2: System.out.println("Longest: " + chatManager.getLongestMessage()); break;
                                case 3:
                                    System.out.print("Enter ID: ");
                                    System.out.println(chatManager.searchByMessageID(scanner.nextLine()));
                                    break;
                                case 4:
                                    System.out.print("Enter Recipient: ");
                                    chatManager.searchByRecipient(scanner.nextLine());
                                    break;
                                case 5:
                                    System.out.print("Enter Hash: ");
                                    System.out.println(chatManager.deleteByHash(scanner.nextLine()));
                                    break;
                                case 6: chatManager.displayReport(); break;
                                case 7: subMenu = false; break;
                                default: System.out.println("Invalid.");
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
        scanner.close();
    }
}