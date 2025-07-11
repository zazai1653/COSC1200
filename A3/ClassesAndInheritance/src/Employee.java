import java.time.LocalDate;

public class Employee extends Person {

    // Attributes
    final String employeeId;

    /**
     * Initializes a person object based on parameters.
     *
     * @param fullName  - the intended full name, in order, separated by spaces.
     * @param birthDate - the intended birth date.
     * @throws IllegalArgumentException when fullName contains less than one
     *                                  character or when fullName contains something other than letters, spaces,
     *                                  hyphens, or apostrophes.
     */
    public Employee(String employeeId, String fullName, LocalDate birthDate) {
        super(fullName, birthDate);
        this.employeeId = employeeId;
        if (employeeId.length() == 8){
            System.out.println("Your employee ID must be 8 digits long, instead it is " + employeeId.length());
        }
    }
}
