// Title: Class Exercise 2: Iteration and Arrays
// Author: Rustam Zazai
// Date: 2025-05-27
// Description: Our second in-class activity where we code a program to get the monthly and semester average temperature.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        /* below are data types used to get the monthly and semester average */

        // for january
        final byte DAYS_IN_JANUARY = 31;
        byte validationLoopForLowestJanuaryTemperature = 0;
        double lowestJanuaryTemperature = 0;
        byte validationLoopForHighestJanuaryTemperature = 0;
        double highestJanuaryTemperature = 0;
        double[] dailyTemperatureForJanuary = new double[31];
        double totalTemperatureForJanuary = 0;
        double averageJanuaryTemperature = 0;

        // for february
        final byte DAYS_IN_FEBRUARY = 31;
        byte validationLoopForLowestFebruaryTemperature = 0;
        double lowestFebruaryTemperature = 0;
        byte validationLoopForHighestFebruaryTemperature = 0;
        double highestFebruaryTemperature = 0;
        double[] dailyTemperatureForFebruary = new double[28];
        double totalTemperatureForFebruary = 0;
        double averageFebruaryTemperature = 0;

        // for march
        final byte DAYS_IN_MARCH = 31;
        byte validationLoopForLowestMarchTemperature = 0;
        double lowestMarchTemperature = 0;
        byte validationLoopForHighestMarchTemperature = 0;
        double highestMarchTemperature = 0;
        double[] dailyTemperatureForMarch = new double[31];
        double totalTemperatureForMarch = 0;
        double averageMarchTemperature = 0;

        // for april
        final byte DAYS_IN_APRIL = 31;
        byte validationLoopForLowestAprilTemperature = 0;
        double lowestAprilTemperature = 0;
        byte validationLoopForHighestAprilTemperature = 0;
        double highestAprilTemperature = 0;
        double[] dailyTemperatureForApril = new double[30];
        double totalTemperatureForApril = 0;
        double averageAprilTemperature = 0;

        // for semester
        final byte MONTHS_IN_THE_SEMESTER = 4;
        double averageSemesterTemperature = 0;

        // for processing, generating random numbers
        double randomNumberGenerated = 0;

        /* above are data types used to get the monthly and semester average */



        /* below is the code for getting the average temperature in january */

        while (validationLoopForLowestJanuaryTemperature == 0){
            System.out.println("Enter the lowest temperature for January: ");

            if (input.hasNextDouble()){
                lowestJanuaryTemperature = input.nextDouble();

                // if the user enters a valid double for lowest january temperature, get the highest and validate it
                while (validationLoopForHighestJanuaryTemperature == 0){
                    System.out.println("Enter the highest temperature for January: ");

                    if (input.hasNextDouble()){
                        highestJanuaryTemperature = input.nextDouble();

                        // if the user enters a valid double for highest temperature in the month, generate 31 randomly generated numbers within a suitable range specified by the user
                        for (int i=0; i < 31; i++){
                            randomNumberGenerated = Math.random() * (highestJanuaryTemperature - lowestJanuaryTemperature) + lowestJanuaryTemperature;
                            // records the temperature every day
                            dailyTemperatureForJanuary[i] = randomNumberGenerated;
                            // adds the average temperature every day to find the sum
                            totalTemperatureForJanuary += dailyTemperatureForJanuary[i];
                        }
                        // exit the loop and move on
                        validationLoopForLowestJanuaryTemperature = 1;
                        validationLoopForHighestJanuaryTemperature = 1;
                    }
                }
            }
            else { // if the input isn't a double
                input.next();
                System.out.println("Enter a double");
            }
        }

        /* above is the code for getting the average temperature in january */



        /* below is the code for getting the average temperature in february */

        while (validationLoopForLowestFebruaryTemperature == 0){
            System.out.println("Enter the lowest temperature for February: ");

            if (input.hasNextDouble()){
                lowestFebruaryTemperature = input.nextDouble();

                // if the user enters a valid double for lowest month's temperature, get the highest and validate it
                while (validationLoopForHighestFebruaryTemperature == 0){
                    System.out.println("Enter the highest temperature for February: ");

                    if (input.hasNextDouble()){
                        highestFebruaryTemperature = input.nextDouble();

                        // if the user enters a valid double for highest temperature in the month, generate 28 randomly generated numbers within a suitable range specified by the user
                        for (int i=0; i < 28; i++){
                            randomNumberGenerated = Math.random() * (highestFebruaryTemperature - lowestFebruaryTemperature) + lowestJanuaryTemperature;
                            // records the temperature every day
                            dailyTemperatureForFebruary[i] = randomNumberGenerated;
                            // adds the average temperature every day to find the sum
                            totalTemperatureForFebruary += dailyTemperatureForFebruary[i];
                        }
                        // exit the loop and move on
                        validationLoopForLowestFebruaryTemperature = 1;
                        validationLoopForHighestFebruaryTemperature = 1;
                    }
                }
            }
            else { // if the input isn't a double
                input.next();
                System.out.println("Enter a double");
            }
        }

        /* above is the code for getting the average temperature in february */



        /* below is the code for getting the average temperature in march */

        while (validationLoopForLowestMarchTemperature == 0){
            System.out.println("Enter the lowest temperature for March: ");

            if (input.hasNextDouble()){
                lowestMarchTemperature = input.nextDouble();

                // if the user enters a valid double for lowest month's temperature, get the highest and validate it
                while (validationLoopForHighestMarchTemperature == 0){
                    System.out.println("Enter the highest temperature for March: ");

                    if (input.hasNextDouble()){
                        highestMarchTemperature = input.nextDouble();

                        // if the user enters a valid double for highest temperature in the month, generate 31 randomly generated numbers within a suitable range specified by the user
                        for (int i=0; i < 31; i++){
                            randomNumberGenerated = Math.random() * (highestMarchTemperature - lowestMarchTemperature) + lowestMarchTemperature;
                            // records the temperature every day
                            dailyTemperatureForMarch[i] = randomNumberGenerated;
                            // adds the average temperature every day to find the sum
                            totalTemperatureForMarch += dailyTemperatureForMarch[i];

                        }
                        // exit the loop and move on
                        validationLoopForLowestMarchTemperature = 1;
                        validationLoopForHighestMarchTemperature = 1;
                    }
                }
            }
            else { // if the input isn't a double
                input.next();
                System.out.println("Enter a double");
            }
        }

        /* above is the code for getting the average temperature in march */



        /* below is the code for getting the average temperature in april */

        while (validationLoopForLowestAprilTemperature == 0){
            System.out.println("Enter the lowest temperature for April: ");

            if (input.hasNextDouble()){
                lowestAprilTemperature = input.nextDouble();

                // if the user enters a valid double for lowest month's temperature, get the highest and validate it
                while (validationLoopForHighestAprilTemperature == 0){
                    System.out.println("Enter the highest temperature for April: ");

                    if (input.hasNextDouble()){
                        highestAprilTemperature = input.nextDouble();

                        // if the user enters a valid double for highest temperature in the month, generate 30 randomly generated numbers within a suitable range specified by the user
                        for (int i=0; i < 30; i++){
                            randomNumberGenerated = Math.random() * (highestAprilTemperature - lowestAprilTemperature) + lowestAprilTemperature;
                            // records the temperature every day
                            dailyTemperatureForApril[i] = randomNumberGenerated;
                            // adds the average temperature every day to find the sum
                            totalTemperatureForApril += dailyTemperatureForApril[i];
                        }
                        // exit the loop and move on
                        validationLoopForLowestAprilTemperature = 1;
                        validationLoopForHighestAprilTemperature = 1;
                    }
                }
            }
            else { // if the input isn't a double
                input.next();
                System.out.println("Enter a double");
            }
        }

        /* above is the code for getting the average temperature in april */



        /* below is the code for getting the monthly and semester average temperature */

        // find the sum of temperature for january and divide it by 31
        averageJanuaryTemperature = totalTemperatureForJanuary / DAYS_IN_JANUARY;

        // find the sum of temperature for february and divide it by 28
        averageFebruaryTemperature = totalTemperatureForFebruary / DAYS_IN_FEBRUARY;

        // find the sum of temperature for march and divide it by 31
        averageMarchTemperature = totalTemperatureForMarch / DAYS_IN_MARCH;

        // find the sum of temperature for april and divide it by 30
        averageAprilTemperature = totalTemperatureForApril / DAYS_IN_APRIL;

        // find the sum of temperature for the semester average and divide it by 4
        averageSemesterTemperature = (averageJanuaryTemperature + averageFebruaryTemperature + averageMarchTemperature + averageAprilTemperature) / MONTHS_IN_THE_SEMESTER;

        /* above is the code for getting the monthly and semester average temperature */



        /* below code prints the average temperature for the first 4 months, and the semester average*/

        System.out.printf("The average temperature for January is %.2f\n", averageJanuaryTemperature);
        System.out.printf("The average temperature for February is %.2f\n", averageFebruaryTemperature);
        System.out.printf("The average temperature for March is %.2f\n", averageMarchTemperature);
        System.out.printf("The average temperature for April is %.2f\n", averageAprilTemperature);
        System.out.printf("The average temperature for the semester is %.2f\n", averageSemesterTemperature);

        /* above code prints the average temperature for the first 4 months, and the semester average*/
    }
}