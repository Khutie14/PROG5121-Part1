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
public String registerUser(String username, String password, String cellPhoneNumber) {
    if (!checkUserName(username)) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }
    if (!checkPasswordComplexity(password)) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    if (!checkCellPhoneNumber(cellPhoneNumber)) {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    this.username = username;
    this.password = password;
    this.cellPhoneNumber = cellPhoneNumber;

    return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
}
}