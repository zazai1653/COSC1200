import java.util.*;


public class Main {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        // Used for getting the BMI
        final float CONVERSION_FACTOR = 703;
        float userBmi = 0;

        // BMI calculation process variables
        boolean loopForContinuingBmiCalculation = true;
        int userInputStartBmiCalculation = 0;

        // Height variables
        boolean validationLoopForHeightInInches = true;
        float userInputHeightInInches = 0;

        // Weight variables
        boolean validationLoopForWeightInPounds = true;
        float userInputWeightInPounds = 0;

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

            // Validation to get an int of 1 or 2
            if (input.hasNextInt()) {
                userInputStartBmiCalculation = input.nextInt();

                //If valid float
                if (userInputHeightInInches >= 24  && userInputHeightInInches <= 120){

                }

                else {
                    System.out.println("Invalid input of " + userInputHeightInInches);
                }
            // User did not enter a float
            else {
                System.out.println("No int entered");
                loopForContinuingBmiCalculation = true;
                input.next();
            }
    }
}