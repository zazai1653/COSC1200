// Name: Rustam Zazai
// Date: 2025-7-11
// Description: The main file

import java.util.*;
import java.time.LocalDate;;

public class Main {
    public static void main(String[] args) {
        System.out.println("Greetings! Welcome to Assignment 3, which covers class, inheritance and exception handling.\n");

        // Creates salaried staff instance and changes the attributes with exception handling incorporated in main
        try {
            SalariedStaff salariedStaffBruce = new SalariedStaff("Bruce Wayne", LocalDate.of(1900, 5, 19), "10102196", 150000);
            System.out.println(salariedStaffBruce.getFirstName() + ' ' + salariedStaffBruce.getLastName() + " makes $" + salariedStaffBruce.getYearlySalary() + " VBucks yearly");
            salariedStaffBruce.setYearlySalary(1000);
            System.out.println(salariedStaffBruce.getFirstName()  + ' ' + salariedStaffBruce.getLastName() + " makes $" + salariedStaffBruce.getYearlySalary() + " VBucks yearly");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("An unexpected error was thrown " + ex.getMessage());
        }

        // Creates hourly worker staff instance and changes the attributes with exception handling incorporated main
        try {
            HourlyWorker hourlyWorkerClark = new HourlyWorker("Clark Kent", LocalDate.of(1650, 8, 4), "12345678", 20, 40);
            System.out.println(hourlyWorkerClark.getFirstName()  + ' ' + hourlyWorkerClark.getLastName() + " has an hourly rate of " + hourlyWorkerClark.getHourlyRate() + " and has worked " + hourlyWorkerClark.hoursPerWeek + " hours this week");
            hourlyWorkerClark.setHourlyRate(16);
            hourlyWorkerClark.setHoursPerWeek(35);
            System.out.println(hourlyWorkerClark.getFirstName()  + ' ' + hourlyWorkerClark.getLastName() + " has an hourly rate of " + hourlyWorkerClark.getHourlyRate() + " and has worked " + hourlyWorkerClark.hoursPerWeek + " hours this week");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("An unexpected error was thrown " + ex.getMessage());
        }

        // Creates array including at least two new salaried staff objects and three new hourly worker objects.
        try {
            double totalAmountPaid = 0.0; // This double is used to keep track of the total amount paid to all employees
            String totalAmountPaidPlaceholder = "\0";
            Employee[] staffArray = new Employee[5];
            staffArray[0] = new SalariedStaff("Barry Allen", LocalDate.of(1992, 5, 1), "23456789", 1000);
            staffArray[1] = new SalariedStaff("Oliver Green", LocalDate.of(1970, 3, 8), "34567890", 150000);
            staffArray[2] = new HourlyWorker("Peter Parker", LocalDate.of(2001, 5, 19), "45678901", 16, 20);
            staffArray[3] = new HourlyWorker("Cat Woman", LocalDate.of(1995, 8, 23), "56789012", 20, 0);
            staffArray[4] = new HourlyWorker("Johnson Patel", LocalDate.of(2025, 7, 11), "67890123", 16, 0);

            System.out.println(); // New line to display info neatly
            for (Employee emp : staffArray){
                System.out.println("Employee ID: " + emp.getEmployeeID() + ", employee name: " + emp.getFirstName() + ' ' + emp.getLastName() + ", weekly salary: " + emp.calculatePayDay());
                totalAmountPaid += emp.calculatePayDay();
            }
            // Code below rounds up the value to the nearest cent
            totalAmountPaidPlaceholder = String.format("%.2f", totalAmountPaid);
            totalAmountPaid = Double.parseDouble(totalAmountPaidPlaceholder);
            System.out.println("\nTotal amount paid this week: " + totalAmountPaid);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("An unexpected error was thrown " + ex.getMessage());
        }

        try{
            // New line for improved readability
            System.out.println();
            Intern robin = new Intern("Robin Wayne", LocalDate.of(2000, 1, 1), "78901234", 25.4219869865251683951341451, 40.1245325634);
            System.out.println("Robin's ID: " + robin.getEmployeeID() + ", Robin's name: " + robin.getFirstName() + ' ' + robin.getLastName() + ", weekly salary: " + robin.calculatePayDay());
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("An unexpected error was thrown " + ex.getMessage());
        }

    }
}