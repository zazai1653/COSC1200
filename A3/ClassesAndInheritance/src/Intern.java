// Name: Rustam Zazai
// Date: 2025-7-11
// Description: The file to go beyond and above by creating an intern class which is paid a stipend

import java.time.LocalDate;

public class Intern extends Employee {

    // Attributes
    double hourlyRate = 0.0;
    double hoursPerWeek = 0.0;
    final double STIPEND = 500;
    double weeklySalary = 0.0;
    String weeklySalaryPlaceholder = "\0";

    public Intern(String fullNameArg, LocalDate birthDateArg, String employeeIDArg, double hourlyRateArg, double hoursPerWeekArg) throws IllegalArgumentException {
        super(fullNameArg, birthDateArg, employeeIDArg);

        if (hourlyRateArg < 16){
            throw new IllegalArgumentException("The hourly rate must be $16 or higher");
        }
        if(hoursPerWeekArg < 0 || hoursPerWeekArg > 48){
            throw new IllegalArgumentException("The hours worked per week must not be negative or greater than 48");
        }

        hourlyRate = hourlyRateArg;
        hoursPerWeek = hoursPerWeekArg;
    }


    public double getHourlyRate(){
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRateArg) throws IllegalArgumentException {
        if (hourlyRateArg < 16){
            throw new IllegalArgumentException("The hourly rate cannot be less than 16");
        }

        hourlyRate = hourlyRateArg;
    }

    public double getHoursPerWeek(){
        return hoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeekArg) throws IllegalArgumentException {
        if (hoursPerWeekArg < 0 || hoursPerWeekArg > 48){
            throw new IllegalArgumentException("The hours worked per week must not be negative or greater than 48");
        }
        hoursPerWeek = hoursPerWeekArg;
    }

    @Override
    public double calculatePayDay() {
        // Nominal weekly stipend is added for the intern
        weeklySalary = (hoursPerWeek * hourlyRate) + STIPEND;
        // Get the weekly salary rounded to 2 decimal places as a string
        weeklySalaryPlaceholder = String.format("%.2f", weeklySalary);
        // Parse the string used to round to the nearest cent to a double
        weeklySalary = Double.parseDouble(weeklySalaryPlaceholder);
        return weeklySalary;
    }
}
