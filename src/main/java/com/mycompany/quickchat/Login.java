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

/**
 * Regex pattern adapted from Zalatos (2016).
 * Validates South African cell numbers with international country code.
 * 
 * In-text citation: (Zalatos, 2016)
 * 
 * Reference:
 * Zalatos. 2016. South African Cell numbers. [online] Regex101.
 * Available at: <https://regex101.com/r/oE1bQ2/1> [Accessed 27 September 2026].
 */
public boolean checkCellPhoneNumber(String cellPhoneNumber) {
    String regex = "^\\+\\d{1,3}\\d{1,10}$";
    return cellPhoneNumber.matches(regex);
}
}