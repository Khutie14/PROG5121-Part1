package com.mycompany.quickchat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registration ===");
        System.out.print("Enter first name: Kyle");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: Smith");
        String lastName = scanner.nextLine();

        Login login = new Login(firstName, lastName);

        System.out.print("Enter username:kyl_1 ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password:Ch&sec@ke99! ");
        String password = scanner.nextLine();
        System.out.print("Enter SA cell number (+27...): +27838976");
        String cell = scanner.nextLine();

        System.out.println(login.registerUser(username, password, cell));

        System.out.println("\n=== Login ===");
        System.out.print("Enter username:kyl_1 ");
        String loginUser = scanner.nextLine();
        System.out.print("Enter password:Ch&sec@ke99 ");
        String loginPass = scanner.nextLine();

        boolean success = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(success));

        scanner.close();
    }
}
