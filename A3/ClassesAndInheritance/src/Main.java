import java.util.*;
import java.time.LocalDate;;

public class Main {
    public static void main(String[] args) {
        System.out.println("Greetings! welcome to assignment 3, which covers class and inheritance.");
        Employee emp1 = new Employee("101021968", "Johnson", LocalDate.of(1900, 5, 19));
        System.out.println("EMP1 age" + emp1.getAge());
        // Create two Person instances
        Person p1 = new Person("Clark Kent", LocalDate.of(1900, 5, 19));

        // Print formatted names, birth dates, and ages
        System.out.println("Person 1: " + p1.getName() + ", born " + p1.getBirthDate() + ", age " + p1.getAge());

    }
}