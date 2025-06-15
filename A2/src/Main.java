// Title: Assignment 2: Iteration and arrays
// Author: Rustam Zazai
// Date: 2025-06-13
// Description: Using classes and methods, encryption and decryption is performed using ciphers and/or shift values.

import java.util.*;

class CipherProgram
{
    final Scanner input = new Scanner(System.in);

    // Constants used for the character set used in the cipher.
    final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final String COSC1200_ALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";

    // The loop condition that will be used to repeat the program, so long as the user wishes.
    byte continueCipher = 1;

    // Variables used to get user's choice of encryption or decryption, and the validation loop condition for it.
    byte userChoiceOfEncryptionOrDecryptionMode = 0;
    boolean validationLoopForEncryptOrDecryptMode = true;

    // Variables used to get user's choice of substitution or translation, and the validation loop condition for it.
    byte userChoiceOfSubstitutionOrTranslation = 0;
    boolean validationLoopForSubstitutionOrTranslation = true;

    // Variables used to get the user input to decrypt/encrypt, and the translated output which will be based off the input.
    String userInputToProcess = "";
    String translatedCipher = "";

    // Validation loop condition for shift key, and the user's desired shift key, followed by the final processed shift key which will determine the index to be used.
    boolean validationForUserInputShiftKey = true;
    int userInputShiftKey = 0;
    byte shiftKey = 0;
    // Validation loop condition for complexity key
    boolean validationForUserInputComplexityKey = true;
    int complexityKey = 0;
    // Placeholder which is used to store the processed character for each character in the user's string. Initialization for substitution helps to process the translated cipher correctly.
    char placeHolderToUseInConversion = 0;
    boolean initializationForSubstitution = true;

    // Constructor which will call all the methods required to complete the program.
    public CipherProgram()
    {
        // Do while loop which will process a cipher if the user desires.
        while (continueCipher == 1)
        {
            // All variables are initialized to their default state after each processed cipher.
            userChoiceOfEncryptionOrDecryptionMode = 0;
            validationLoopForEncryptOrDecryptMode = true;
            userChoiceOfSubstitutionOrTranslation = 0;
            validationLoopForSubstitutionOrTranslation = true;
            userInputShiftKey = 0;
            validationForUserInputComplexityKey = true;
            complexityKey = 0;
            placeHolderToUseInConversion = 0;
            initializationForSubstitution = true;
            userInputToProcess = "";
            translatedCipher = "";
            validationForUserInputShiftKey = true;
            shiftKey = 0;

            System.out.println("Press 1 to run a cipher program, 2 to exit.");
            if (input.hasNextInt())
            {
                continueCipher = input.nextByte();
                input.nextLine(); // Clears input buffer.

                // If the user wants to run the program.
                if (continueCipher == 1)
                {
                    // Calls the function to get the user's desired mode.
                    funcGetModeOfEncryptionOrDecryption();

                    // If the user wants to encrypt and enters 1, invokes the function to get the mode of substitution or translation.
                    if (userChoiceOfEncryptionOrDecryptionMode == 1)
                    {
                        System.out.println("Enter the value you would like to encrypt");
                        userInputToProcess = input.nextLine();
                        funcGetCipherModeOfSubstitutionOrTranslation();

                        // If the user wants to encrypt and use substitution, get the complexity key and call the function to process the request.
                        if (userChoiceOfSubstitutionOrTranslation == 1)
                        {
                            funcGetComplexityKey();
                            funcEncryptAndSubstitute();
                        }
                        else // If the user wants to encrypt and use translation, get the shift key and call the function to process the request.
                        {
                            funcGetShiftKey();
                            funcEncryptAndTranslate();
                        }
                    }
                    else // If the user wants to decrypt and enters 2, invokes the function to get the mode of substitution or translation.
                    {
                        System.out.println("Enter the value you would like to decrypt");
                        userInputToProcess = input.nextLine();
                        funcGetCipherModeOfSubstitutionOrTranslation();

                        // If user wants to decrypt and use substitution, get the complexity key and call the function to process the request.
                        if (userChoiceOfSubstitutionOrTranslation == 1)
                        {
                            System.out.println("The user wants to decrypt and use substitution");
                            funcGetComplexityKey();
                            funcDecryptAndSubstitute();
                        }
                        else // If the user wants to decrypt and use translation, get the shift key and call the function to process the request.
                        {
                            System.out.println("The user wants to decrypt and use translation");
                            funcGetShiftKey();
                            funcDecryptAndTranslate();
                        }
                    }
                }
                else // If the user enters 2 and wants to end the program.
                {
                    System.out.println("Au revoir!");
                }
            }
            else // If the user does not enter a valid int.
            {
                System.out.println("1 to encrypt/decrypt, 2 to exit");
                input.next();
            }
        }
    }

    // This is the function used to get the desired mode (encryption or decryption), and validates it.
    void funcGetModeOfEncryptionOrDecryption()
    {
        while (validationLoopForEncryptOrDecryptMode) // Exception handling loop to get valid input.
        {
            System.out.println("Enter 1 to encrypt a message, or 2 to decrypt.");
            if (input.hasNextInt())
            {
                userChoiceOfEncryptionOrDecryptionMode = input.nextByte();
                input.nextLine(); // Clears input buffer.
                if (userChoiceOfEncryptionOrDecryptionMode == 1) // If the user wants to encrypt, valid input has been entered, exit the loop/function.
                {
                    validationLoopForEncryptOrDecryptMode = false;
                }
                else if (userChoiceOfEncryptionOrDecryptionMode == 2) // If the user wants to decrypt, valid input has been entered, exit the loop/function.
                {
                    validationLoopForEncryptOrDecryptMode = false;
                }
                else // If the user enters a valid integer but not the options presented.
                {
                    System.out.println("The options are 1 (encrypt) or 2 (decrypt).");
                }
            }
            else // If the user does not enter an integer.
            {
                System.out.println("The options are 1 (encrypt) or 2 (decrypt).");
                input.next();
            }
        }
    }

    // Function used to get the mode to substitute or translate.
    void funcGetCipherModeOfSubstitutionOrTranslation()
    {
        while (validationLoopForSubstitutionOrTranslation) // Exception handling loop to get valid input.
        {
            System.out.println("For the cipher, enter 1 to substitute or 2 to translate.");
            if (input.hasNextInt())
            {
                userChoiceOfSubstitutionOrTranslation = input.nextByte();
                input.nextLine(); // Clears input buffer.
                if (userChoiceOfSubstitutionOrTranslation == 1) // If the user wants to substitute, valid input has been entered, exit the loop/function.
                {
                    validationLoopForSubstitutionOrTranslation = false;
                }
                else if (userChoiceOfSubstitutionOrTranslation == 2) // If the user wants to translate, valid input has been entered, exit the loop/function.
                {
                    validationLoopForSubstitutionOrTranslation = false;
                }
                else // If the user enters an integer, but it's not 1 or 2.
                {
                    System.out.println("The options are 1 (substitute) or 2 (translate).");
                }
            }
            else // If the user does not enter an integer.
            {
                System.out.println("The options are 1 (substitute) or 2 (translate).");
                input.next();
            }
        }
    }

    // Function used to get the shift key and validate it.
    void funcGetShiftKey()
    {
        while (validationForUserInputShiftKey) // Exception handling loop to get valid input.
        {
            System.out.println("Enter the shift key you would like to use");
            if (input.hasNextInt())
            {
                userInputShiftKey = input.nextInt();
                input.nextLine(); // Clears input buffer.
                validationForUserInputShiftKey = false; // If the user enters a valid shift key, exit the loop/function.
            }
            else // If the user doesn't enter an int.
            {
                System.out.println("Enter a number value between −2,147,483,648 to 2,147,483,647");
                input.next();
            }
        }
    }

    // Function used to get the complexity key.
    void funcGetComplexityKey()
    {
        while (validationForUserInputComplexityKey)
        {
            System.out.println("Enter the complexity key to use (whole number greater than 0)");
            if (input.hasNextInt())
            {
                complexityKey = input.nextInt();
                input.nextLine(); // Clears input buffer.
                // Ensures that a valid complexity key is entered.
                if (complexityKey > 0)
                {
                    validationForUserInputComplexityKey = false; // If a valid complexity key is entered, exit the loop/function.
                }
            }
            else // The user does not enter an integer.
            {
                System.out.println("Enter a number value between −2,147,483,648 to 2,147,483,647");
                input.next();
            }
        }
    }

    // Function used to encrypt and translate.
    void funcEncryptAndTranslate()
    {
        if (userInputShiftKey < 0) // If the user enters a negative shift key, the alphabet will be shifted backwards.
        {
            for (int i = 0; i < userInputToProcess.length(); i++) // Repeat the shift key for every character in the input.
            {
                shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i)); // The shift key will be used for every character, it gets the index of each character.
                for (int j = 0; j > userInputShiftKey; j--) // The user's input is used to get the shift key.
                {
                    shiftKey--;
                    if (shiftKey < 0) // If the shift index falls out of the valid range, it starts from the other side.
                    {
                        shiftKey = 51;
                    }
                }
                translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey); // Each character is added to the translated cipher character by character.
            }
            System.out.printf("Your encrypted translated cipher is %s \n", translatedCipher);
        }
        else // If a positive shift key is entered, the above code is executed backwards.
        {
            for (int i = 0; i < userInputToProcess.length(); i++)
            {
                shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
                for (int j = 0; j < userInputShiftKey; j++)
                {
                    shiftKey++;
                    if (shiftKey > 51)
                    {
                        shiftKey = 0;
                    }
                }
                translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
            }
            System.out.printf("Your encrypted translated cipher is %s \n", translatedCipher);
        }
    }

    // Function used to encrypt and substitute.
    void funcEncryptAndSubstitute()
    {
        for (int i = 0; i < userInputToProcess.length(); i++) // Runs for the entirety of the string.
        {
            initializationForSubstitution = true;
            for (int j = 0; j < complexityKey; j++) // This loop will repeat the encryption process depending on the users complexity key.
                {
                    if (initializationForSubstitution == true)
                    {
                        if (initializationForSubstitution == true && complexityKey > 1) // If the user has a complexity key greater than 1, the encryption process is repeated as required.
                        {
                            placeHolderToUseInConversion = (char) COSC1200_ALPHABET.charAt(ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i)));
                            initializationForSubstitution = false;
                        }
                        else // If the user has a complexity key of 1, it will translate based on the indexes between the sets.
                        {
                            placeHolderToUseInConversion = (char) COSC1200_ALPHABET.charAt(ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i)));
                        }
                    }
                    else // This code repeats the encryption process, each character is encrypted based on the complexity key.
                    {
                        placeHolderToUseInConversion = COSC1200_ALPHABET.charAt(ENGLISH_ALPHABET.indexOf(placeHolderToUseInConversion));
                    }
                }
            translatedCipher += placeHolderToUseInConversion; // The encrypted cipher is created character by character, when each character is processed.
        }
        System.out.printf("Your encrypted substituted cipher is %s \n", translatedCipher);
    }

    void funcDecryptAndSubstitute()
    {
        for (int i = 0; i < userInputToProcess.length(); i++) // Run for the length of the string.
        {
            initializationForSubstitution = true;
            for (int j = 0; j < complexityKey; j++) // Decrypt based on the complexity key.
            {
                if (initializationForSubstitution == true )
                {
                    if (initializationForSubstitution == true && complexityKey > 1) // If the user has a complexity key greater than 1, the encryption process is repeated as required.
                    {
                        placeHolderToUseInConversion = (char) ENGLISH_ALPHABET.charAt(COSC1200_ALPHABET.indexOf(userInputToProcess.charAt(i)));
                        initializationForSubstitution = false;
                    }
                    else // If the user has a complexity key of 1, substitute based on the index.
                    {
                        placeHolderToUseInConversion = (char) ENGLISH_ALPHABET.charAt(COSC1200_ALPHABET.indexOf(userInputToProcess.charAt(i)));
                    }
                }
                else // This will use the complexity key to continuously encrypt the output.
                {
                    placeHolderToUseInConversion = ENGLISH_ALPHABET.charAt(COSC1200_ALPHABET.indexOf(placeHolderToUseInConversion));
                }
            }
            translatedCipher += placeHolderToUseInConversion;
        }
        System.out.printf("Your encrypted substituted cipher is %s \n", translatedCipher);
    }

    void funcDecryptAndTranslate()
    {
            if (userInputShiftKey < 0) // If the user enters a negative shift key.
            {
                for (int i = 0; i < userInputToProcess.length(); i++) // Run to process every character.
                {
                    shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i)); // The shift key will be used for every character, it gets the index of each character.
                    for (int j = 0; j > userInputShiftKey; j--) // This will update the shift key based on the users input.
                    {
                        shiftKey--;
                        if (shiftKey < 0) // If the shift key falls out of the valid range, go to the other side of the index value.
                        {
                            shiftKey = 51;
                        }
                    }
                    translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
                }
                System.out.printf("Your decrypted translated cipher is %s \n", translatedCipher);
            }
            else // If the user enters a positive shift key, repeat the above process backwards.
            {
                for (int i = 0; i < userInputToProcess.length(); i++)
                {
                    shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
                    for (int j = 0; j < userInputShiftKey; j++)
                    {
                        shiftKey++;
                        if (shiftKey > 51)
                        {
                            shiftKey = 0;
                        }
                    }
                    translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
                }
                System.out.printf("Your decrypted translated cipher is %s \n", translatedCipher);
            }
        }
    }


public class Main{

    public static void main(String[] args){
        CipherProgram cipherProgram = new CipherProgram(); // Create an instance of the class, which will call its constructor.
    }
}
