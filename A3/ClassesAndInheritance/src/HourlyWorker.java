// Name: Rustam Zazai
// Date: 2025-7-11
// Description: The hourly worker file which implements an hourly rate and hours worked per week

import java.time.LocalDate;

public class HourlyWorker extends Employee {

    // Attributes
    double hourlyRate = 0.0;
    double hoursPerWeek = 0.0;
    double weeklySalary = 0.0;
    String weeklySalaryPlaceholder = "\0";

    public HourlyWorker(String fullNameArg, LocalDate birthDateArg, String employeeIDArg, double hourlyRateArg, double hoursPerWeekArg) throws IllegalArgumentException {
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
        weeklySalary = hoursPerWeek * hourlyRate;
        // Get the weekly salary rounded to 2 decimal places as a string
        weeklySalaryPlaceholder = String.format("%.2f", weeklySalary);
        // Parse the string used to round to the nearest cent to a double
        weeklySalary = Double.parseDouble(weeklySalaryPlaceholder);
        return weeklySalary;
    }
}
