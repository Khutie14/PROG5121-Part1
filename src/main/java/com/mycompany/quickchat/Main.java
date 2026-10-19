package com.mycompany.quickchat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Registration & Login (From Part 1)
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

        String regMessage = login.registerUser(username, password, cell);
        System.out.println(regMessage);

        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine();

        boolean success = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(success));

        // If login is successful, show the QuickChat menu
        if (success) {
            System.out.println("\nWelcome to QuickChat.");
            
            // 2. Ask how many messages they want to enter
            System.out.print("How many messages do you wish to enter? ");
            int numMessages = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            // 3. Menu Loop
            boolean running = true;
            while (running) {
                System.out.println("\n--- MENU ---");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Send Messages selected (Feature coming in next step!)");
                        break;
                    case 2:
                        System.out.println("Coming Soon.");
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
            }
        }
        scanner.close();
    }
}