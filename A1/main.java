// Title: Assignment 1: Simple Java Application
// Author: Rustam Zazai
// Date: 2025-05-21
// Description: Assignment 1: Simple Java Application, writing code for a BMI calculator.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        // Used for getting the BMI
        final double CONVERSION_FACTOR = 703;
        double userBmi = 0;

        // BMI calculation process variables
        boolean loopForContinuingBmiCalculation = true;
        int userInputStartBmiCalculation = 0;

        // Height variables
        boolean validationLoopForHeightInInches = true;
        double userInputHeightInInches = 0;

        // Weight variables
        boolean validationLoopForWeightInPounds = true;
        double userInputWeightInPounds = 0;

        // Do while loop
        while (loopForContinuingBmiCalculation) {
            // Resetting all variables for every run of this do while loop
            loopForContinuingBmiCalculation = true;
            userInputStartBmiCalculation = 0;

            validationLoopForHeightInInches = true;
            userInputHeightInInches = 0;

            validationLoopForWeightInPounds = true;
            userInputWeightInPounds = 0;

            System.out.println("Type 1 to calculate BMI or 2 to stop");

            // Validation to get an int
            if (input.hasNextInt()) {
                userInputStartBmiCalculation = input.nextInt();

                // User inputs a valid int of 1 or 2
                if (userInputStartBmiCalculation == 1 || userInputStartBmiCalculation == 2) {

                    // User wants to continue
                    if (userInputStartBmiCalculation == 1) {

                        // Do while loop that repeats in case of invalid input
                        while (validationLoopForHeightInInches) {
                            System.out.println("Enter height in inches, no less than 24.0 and no more than 120.0");

                            if (input.hasNextDouble()) {
                                userInputHeightInInches = input.nextDouble();

                                //If the user entered a valid height meeting the range requirements
                                if (userInputHeightInInches >= 24  && userInputHeightInInches <= 120){

                                    // Do while loop for weight
                                    while (validationLoopForWeightInPounds){
                                        System.out.println("Enter weight in pounds, no less than 25");

                                        if (input.hasNextDouble()){
                                            userInputWeightInPounds = input.nextDouble();

                                            // User enters a double that is valid
                                            if (userInputWeightInPounds >= 25){
                                                // Get the BMI by using the emperical formula.
                                                userBmi = (userInputWeightInPounds / (userInputHeightInInches * userInputHeightInInches)) * CONVERSION_FACTOR;

                                                System.out.printf("The height you entered is %.1f, and the weight is %.1f, making your BMI %.1f%n", userInputHeightInInches, userInputWeightInPounds, userBmi);

                                                // If structure for all BMIs that may suggest weight loss/gain.
                                                if (userBmi < 16) {
                                                    System.out.println("You are severely underweight and need to gain weight");
                                                }
                                                else if (userBmi >= 16 && userBmi < 18.5) {
                                                    System.out.println("You are underweight and should gain weight");
                                                }
                                                else if (userBmi >= 18.5 && userBmi < 25) {
                                                    System.out.println("You are healthy and do not need to change weight");
                                                }
                                                else if (userBmi >= 25 && userBmi < 30) {
                                                    System.out.println("You are overweight and should lose weight");
                                                }
                                                else {
                                                    System.out.println("You are obese and need to lose weight");
                                                }

                                                //Extra new line to improve the format of the new calculation
                                                System.out.println(' ');

                                                // Falsifying all loop conditions to go back to initial prompt
                                                validationLoopForHeightInInches = false;
                                                validationLoopForWeightInPounds = false;
                                            }

                                            // User enters a double that is valid
                                            else {
                                                System.out.println("Enter a value equal to or greater than 25");
                                            }
                                        }

                                        else {
                                            System.out.println("You didn't enter a double");
                                        }
                                    }
                                }

                                else {
                                    System.out.println("Invalid input of " + userInputHeightInInches);
                                }

                            }

                            //Not a double
                            else{
                                System.out.println("Enter a double type number");
                            }
                        }
                    }

                    // Valid input by user who wants to exit
                    if (userInputStartBmiCalculation == 2) {
                        break;
                    }
                }

                // Valid double but input but is not 1 or 2
                else {
                    System.out.println("Invalid int");
                    loopForContinuingBmiCalculation = true;
                }
            }

            // User did not enter a double
            else {
                System.out.println("No int entered");
                loopForContinuingBmiCalculation = true;
                input.next();
            }
        }
    }
}