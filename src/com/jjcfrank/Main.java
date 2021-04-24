package com.jjcfrank;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to MicroBank. Microfinance is a form of banking and brings ways to borrow for low income individual or businesses.");
        System.out.println("If you would like to get a microloan, please follow the instructions below.\n");

        Scanner scanner = new Scanner(System.in);
        Applicant applicant = new Applicant();

        //App #1: Full Name
        System.out.print("Enter your Full Name: ");

        while (true) {
            String userFullName = scanner.nextLine();
            StringTokenizer tokens = new StringTokenizer(userFullName, " ");

            int numberOfTokens = tokens.countTokens();

            if (numberOfTokens > 2) {
                String[] userFullNameSplit = userFullName.split(" ", 3);

                applicant.firstName = userFullNameSplit[0] + " " + userFullNameSplit[1];
                applicant.lastName = userFullNameSplit[2];
                break;

            } else if (numberOfTokens == 2) {
                String[] userFullNameSplit = userFullName.split(" ");

                applicant.firstName = userFullNameSplit[0];
                //String userName = userFullNameSplit[0];

                applicant.lastName = userFullNameSplit[1];
                //String userLastname = userFullNameSplit[1];
                break;

            } else if (numberOfTokens == 0) {
                System.out.print("Please enter a valid name: ");
            } else {
                System.out.print("Please enter a *full* name: ");
            }
        }

        //App #2: Age

        String strInputAge;
        boolean validAge = false;

        while (validAge == false) {
            System.out.print("Enter your age: ");
            strInputAge = scanner.nextLine();
            try {
                applicant.age = Integer.parseInt(strInputAge);
                if (applicant.age > 16) {
                    validAge = true;
                } else {
                    System.out.println("You must be at least 17 years old to obtain a microloan.");
                    System.exit(0);
                }
            }
            catch (NumberFormatException e) {
                System.out.print("Error - enter a valid number. ");
            }
        }

        //App #3: Gender
        String strInputGender;
        boolean validGender = false;

        while (validGender == false) {
            System.out.print("Enter your gender (1 - Female; 2 - Male; 3 - Other): ");
            strInputGender = scanner.nextLine();
            try {
                applicant.gender = Byte.parseByte(strInputGender);
                if (applicant.gender > 3 || applicant.gender == 0) {
                    System.out.print("Error - enter a valid number. ");
                } else
                    validGender = true;
            }
            catch (NumberFormatException e) {
                System.out.print("Error - enter a valid number. ");
            }
        }

        //App #4: Income

        String strInputInc;
        boolean validInc = false;

        while (validInc == false) {
            System.out.print("Enter your earnings: ");
            strInputInc = scanner.nextLine();
            try {
                applicant.income = Integer.parseInt(strInputInc);
                if (applicant.income > 0) {
                    validInc = true;
                } else {
                    System.out.println("You must be in employment to obtain a microloan.");
                    System.exit(0);
                }
            }
            catch (NumberFormatException e) {
                System.out.print("Error - enter a valid number. ");
            }
        }

        //App #5: Willingness to go on training?
        //App #6: How much would you like to borrow?

        //Notes: MFIs need to add higher interest rates to continue running




    }
}

