import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class to represent a person. Contains first, last and any number of middle
 * names, as well as well as a birth date. This is a 'concrete' class, meaning
 * that objects of class Person may be instantiated.
 *
 * ADD THIS CLASS TO YOUR LAB PROJECT. DO NOT MODIFY THIS CLASS.
 *
 * @author Thom MacDonald {thom.macdonald@durhamcollege.ca}
 * @since version 0.1 (2018-11-30).
 */
public class Person {

    // ATTRIBUTES
    private ArrayList<String> myNames; // Stores the person's names
    private LocalDate myBirthDate; // the person's birth date
    //public final int MAXIMUM_AGE = 150; //

    /**
     * Initializes a person object based on parameters.
     *
     * @param fullName - the intended full name, in order, separated by spaces.
     * @param birthDate - the intended birth date.
     * @throws IllegalArgumentException when fullName contains less than one
     * character or when fullName contains something other than letters, spaces,
     * hyphens, or apostrophes.
     */
    public Person(String fullName, LocalDate birthDate) {
        myBirthDate = birthDate;
        this.setNames(fullName);
    }

    /**
     * Sets the birth date based on a parameter. No class specific validation.
     * @param birthDate the intended birth date
     */
    public void setBirthDate(LocalDate birthDate) {
        myBirthDate = birthDate;
    }

    /**
     * Returns the birth date.
     *
     * @return this birth date.
     */
    public LocalDate getBirthDate() {
        return myBirthDate;
    }


    /**
     * Returns the person's current age in years.
     * @return age in years.
     */
    public int getAge() {
        return (myBirthDate.until(LocalDate.now())).getYears();
    }

    /**
     * Sets person's names based on a full string.
     *
     * @param fullName
     * @throws IllegalArgumentException when fullName contains less than one
     * character or when fullName contains something other than letters, spaces,
     * hyphens, or apostrophes.
     */
    final public void setNames(String fullName) {

        // trim any leading or trailing spaces
        fullName = fullName.trim();
        // if there are no characters, throw an exception
        if (fullName.length() < 1) {
            throw new IllegalArgumentException("Person names must be at least "
                    + "one character.");
        }
        // check that all the characters are legal...
        // for each character position,
        for (int index = 0; index < fullName.length(); index++) {
            // extract the character at this position
            char letter = fullName.charAt(index);
            // if the character is not a letter...
            if (!Character.isAlphabetic(letter)) {
                // if the character is not a space, apostrophe or hyphen...
                if (letter != ' ' && letter != '\'' && letter != '-') {
                    // throw an exception.
                    throw new IllegalArgumentException(String.format("\"%s\" "
                                    + "is invalid. Person names can only contain "
                                    + "letters, spaces, hyphens, and apostrophes.",
                            fullName));
                }
            }
        }
        // set/reset myNames to a new ArrayList
        myNames = new ArrayList<>();
        // split fullNames on spaces and add all the resulting strings to myNames
        myNames.addAll(Arrays.asList(fullName.split(" +")));
    }

    /**
     * Gets the person's last name. If the person has one name, it is returned.
     *
     * @return last name
     */
    public String getLastName() {
        return myNames.get(myNames.size() - 1);
    }

    /**
     * Gets the person's first name. If the person has one name, it is returned.
     *
     * @return first name
     */
    public String getFirstName() {
        return myNames.get(0);
    }

    /**
     * Gets the person's name as a formatted string. The last name followed by a
     * coma, then the first name, followed by a list of as many middle initials
     * as are needed. If the person has one name only, it is returned.
     * @return the formatted name.
     */
    public String getName() {
        // starts with last name
        StringBuilder builder = new StringBuilder(getLastName());
        // if there is more than one name...
        if (myNames.size() > 1) {
            // add a coma and the first name
            builder.append(", ");
            builder.append(getFirstName());
            // if there are more than two names...
            if (myNames.size() > 2) {
                // loop for each middle name position...
                for (int index = 1; index < myNames.size() - 1; index++) {
                    // add the initial.
                    builder.append(String.format(" %c.",
                            myNames.get(index).charAt(0)));
                }
            }
        }
        // return the formatted name
        return builder.toString();
    }

}
