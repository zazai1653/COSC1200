// Name: Rustam Zazai
// Date: 2025-7-11
// Description: The salaried staff file which is paid based on a yearly salary

import java.time.LocalDate;

public class SalariedStaff extends Employee {

    // Attributes
    double yearlySalary = 0.0;
    String weeklySalaryPlaceholder = "\0";
    double weeklySalary = 0.0;

    final int WEEKS_IN_A_YEAR = 52;

    public SalariedStaff(String fullNameArg, LocalDate birthDateArg, String employeeIDArg, double yearlySalaryArg) throws IllegalArgumentException {
        super(fullNameArg, birthDateArg, employeeIDArg);

        if (yearlySalaryArg < 0){
            throw new IllegalArgumentException("The yearly salary cannot be a negative value");
        }

        yearlySalary = yearlySalaryArg;
    }

    public void setYearlySalary(double yearlySalaryArg) throws IllegalArgumentException {
        if (yearlySalaryArg < 0) {
            throw new IllegalArgumentException("The yearly salary cannot be a negative value");
        }

        yearlySalary = yearlySalaryArg;
    }

    public double getYearlySalary (){
        return yearlySalary;
    }

    @Override
    public double calculatePayDay() {
        weeklySalary = yearlySalary / WEEKS_IN_A_YEAR;
        // Get the weekly salary rounded to 2 decimal places as a string
        weeklySalaryPlaceholder = String.format("%.2f", weeklySalary);
        // Parse the string used to round to the nearest cent to a double
        weeklySalary = Double.parseDouble(weeklySalaryPlaceholder);
        return weeklySalary;
    }
}
