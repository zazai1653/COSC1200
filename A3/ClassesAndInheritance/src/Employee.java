import java.time.LocalDate;

abstract public class Employee extends Person {

    // Attributes
    final String employeeID;

    // Class constructor
    public Employee(String fullNameArg, LocalDate birthDateArg, String employeeIDArg) throws IllegalArgumentException{
        super(fullNameArg, birthDateArg);
        this.employeeID = employeeIDArg;

        if (employeeID.length() != 8){ // If the employee id length isn't 8, throw an exception
            throw new IllegalArgumentException("Your employee ID must be exactly 8 digits long!");
        }
    }

    public String getEmployeeID(){
        return employeeID;
    }

    abstract public double calculatePayDay();

}
