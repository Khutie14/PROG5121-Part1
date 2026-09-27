/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

public boolean checkUserName(String username) {
    return username.contains("_") && username.length() <= 5;
}

public boolean checkPasswordComplexity(String password) {
    if (password.length() < 8) return false;

    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) hasCapital = true;
        else if (Character.isDigit(c)) hasNumber = true;
        else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
    }

    return hasCapital && hasNumber && hasSpecial;
}
}