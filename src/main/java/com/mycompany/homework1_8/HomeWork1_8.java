/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.homework1_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeWork1_8 {
    
    public static List<Passport> passports = new ArrayList<>();

    public static void printPassports(List<Passport> passportsList) {
        for (Passport passport : passportsList) {
            System.out.println(passport.fullName + ", " + passport.number + ", " + passport.position + ", " + passport.access);
        }
    }

    public static void addPassport(int number, String fullName, String position, boolean access) {
        int existingPassportIndex = -1;
        for (int i = 0; i < passports.size(); i++) {
            if (passports.get(i).number == number) {
                existingPassportIndex = i;
                break;
            }
        }
        if (existingPassportIndex != -1) {
            if (!passports.get(existingPassportIndex).fullName.equals(fullName)) {
                passports.remove(existingPassportIndex);
            } else {
                System.out.println("A pass with the same number and full name already exists.");
                return;
            }
        }
        passports.add(new Passport(number, fullName, position, access));
        Collections.sort(passports, Comparator.comparing(p -> p.fullName));
        System.out.println("List of passes sorted by full name:");
        printPassports(passports);
        Collections.sort(passports, Comparator.comparingInt(p -> p.number));
        System.out.println("\nList of passes sorted by pass number:");
        printPassports(passports);
    }

    public static void main(String[] args) {
        
        System.out.println("Skip list initial values:");
        printPassports(passports);

        
        addPassport(123456, "New Employee", "Engineer", false);
        
        System.out.println("Practical task 1.8, Student Pavel Grigorev, RIBO-01-22, Variant 4");
    }
}
