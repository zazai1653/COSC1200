// Title: Assignment 2: Iteration and arrays
// Author: Rustam Zazai
// Date: 2025-06-13
// Description: Using classes and methods, encryption and decryption is performed using ciphers and/or shift values.

import java.util.*;

class CipherProgram {
    final Scanner input = new Scanner(System.in);

    // variables used for the character set used in the cipher
    final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final String COSC1200_ALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";
    final byte ALPHABET_MAX_INDEX_SIZE = 51;

    // the variable used to continue the cipher
    int continueCipher = 1;

    // variables used to get user's choice of encryption or decryption, and the validation condition for it
    byte userChoiceOfEncryptionOrDecryptionMode = 0;
    boolean validationLoopForEncryptOrDecryptMode = true;

    // variables used to get user's choice of substitution or translation, and the validation condition for it
    byte userChoiceOfSubstitutionOrTranslation = 0;
    boolean validationLoopForSubstitutionOrTranslation = true;

    // variables used to get what the user wants to process, the shift key, the translated output
    String userInputToProcess = "";
    String translatedCipher = "";

    // shift key variable used to input the shift key and the validation loop.
    // shiftKey is used for the shiftkey to determine how the program will encrypt/decrypt the program
    boolean validationForUserInputShiftKey = true;
    int userInputShiftKey = 0;
    byte shiftKey = 0;
    boolean validationForUserInputComplexityKey = true;
    int complexityKey = 0;

    public CipherProgram(){
        while (continueCipher == 1){
            userChoiceOfEncryptionOrDecryptionMode = 0;
            validationLoopForEncryptOrDecryptMode = true;
            userChoiceOfSubstitutionOrTranslation = 0;
            validationLoopForSubstitutionOrTranslation = true;
            userInputShiftKey = 0;
            validationForUserInputComplexityKey = true;
            complexityKey = 0;
            userInputToProcess = "";
            translatedCipher = "";
            validationForUserInputShiftKey = true;
            shiftKey = 0;

            System.out.println("Press 1 to run a cipher program, 2 to exit.");
            if(input.hasNextInt()){
                continueCipher = input.nextInt();
                input.nextLine();
                if (continueCipher == 1) {
                    funcGetModeOfEncryptionOrDecryption();

                    if (userChoiceOfEncryptionOrDecryptionMode == 1) {
                        System.out.println("Enter the value you would like to encrypt");
                        userInputToProcess = input.nextLine();
                        funcGetCipherModeOfSubstitutionOrTranslation();

                        if (userChoiceOfSubstitutionOrTranslation == 1) {
                            System.out.println("The user wants to encryp and use substitution");
                            funcGetComplexityKey();
                            funcEncryptAndSubstitute();
                        } else {
                            System.out.println("The user wants to encryp and use translation");
                            funcGetShiftKey();
                            funcEncryptAndTranslate();
                        }
                    } else {
                        System.out.println("Enter the value you would like to decrypt");
                        userInputToProcess = input.nextLine();
                        funcGetCipherModeOfSubstitutionOrTranslation();

                        if (userChoiceOfSubstitutionOrTranslation == 1) {
                            System.out.println("The user wants to decrypt and use substitution");
                            funcGetComplexityKey();
                            funcDecryptAndTranslate();
                        } else {
                            System.out.println("The user wants to decrypt and use translation");
                            funcGetShiftKey();
                            funcDecryptAndTranslate();
                        }
                    }
                    }
                }
            else{
                System.out.println("1 to encrypt/decrypt, 2 to exit");
                input.next();
            }
        }
    }

    void funcGetModeOfEncryptionOrDecryption(){
        while (validationLoopForEncryptOrDecryptMode){
            System.out.println("Enter 1 to encrypt a message, or 2 to decrypt.");
            if (input.hasNextInt()){
                userChoiceOfEncryptionOrDecryptionMode = input.nextByte();
                input.nextLine();
                if (userChoiceOfEncryptionOrDecryptionMode == 1){
                    validationLoopForEncryptOrDecryptMode = false;
                }
                else if (userChoiceOfEncryptionOrDecryptionMode == 2) {
                    validationLoopForEncryptOrDecryptMode = false;
                }
                else {
                    System.out.println("The options are 1 (encrypt) or 2 (decrypt).");
                }
            }
            else{
                System.out.println("The options are 1 (encrypt) or 2 (decrypt).");
                input.next();
            }
        }
    }

    void funcGetCipherModeOfSubstitutionOrTranslation(){
        while (validationLoopForSubstitutionOrTranslation){
            System.out.println("For the cipher, enter 1 to substitute or 2 to translate.");
            if (input.hasNextInt()){
                userChoiceOfSubstitutionOrTranslation = input.nextByte();
                input.nextLine();
                if (userChoiceOfSubstitutionOrTranslation == 1){
                    validationLoopForSubstitutionOrTranslation = false;
                }
                else if (userChoiceOfSubstitutionOrTranslation == 2) {
                    validationLoopForSubstitutionOrTranslation = false;
                }
                else {
                    System.out.println("The options are 1 (substitute) or 2 (translate).");
                }
            }
            else{
                System.out.println("The options are 1 (substitute) or 2 (translate).");
                input.next();
            }
        }
    }

    void funcGetShiftKey(){
        while(validationForUserInputShiftKey){
            System.out.println("Enter the shift key you would like to use");
            if(input.hasNextInt())
            {
                userInputShiftKey = input.nextInt();
                input.nextLine();
                validationForUserInputShiftKey = false;
            }
            else{
                System.out.println("Enter a number value between −2,147,483,648 to 2,147,483,647");
                input.next();
            }
        }
    }

    void funcGetComplexityKey(){
        while(validationForUserInputComplexityKey){
            System.out.println("Enter the shift key you would like to use");
            if(input.hasNextInt())
            {
                complexityKey = input.nextInt();
                input.nextLine();
                validationForUserInputComplexityKey = false;
            }
            else{
                System.out.println("Enter a number value between −2,147,483,648 to 2,147,483,647");
                input.next();
            }
        }
    }

    void funcEncryptAndTranslate(){
        if(userInputShiftKey < 0){
            for (int i = 0; i < userInputToProcess.length(); i++){
                shiftKey = (byte)ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
                for(int j = 0; j > userInputShiftKey; j--){
                    shiftKey--;
                    if (shiftKey < 0){
                        shiftKey = 51;
                    }
                }
                translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
            }
            System.out.printf("Your encrypted translated cipher is %s \n", translatedCipher);
        }
        else{
            for (int i = 0; i < userInputToProcess.length(); i++){
                shiftKey = (byte)ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
                for(int j = 0; j < userInputShiftKey; j++){
                    shiftKey++;
                    if (shiftKey > 51){
                        shiftKey = 0;
                    }
                }
                translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
            }
            System.out.printf("Your encrypted translated cipher is %s \n", translatedCipher);
        }
    }

    void funcEncryptAndSubstitute(){

    }

    void funcDecryptAndSubstitute(){

    }

    void funcDecryptAndTranslate() {
            if (userInputShiftKey < 0) {
                for (int i = 0; i < userInputToProcess.length(); i++) {
                    shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
                    for (int j = 0; j > userInputShiftKey; j--) {
                        shiftKey--;
                        if (shiftKey < 0) {
                            shiftKey = 51;
                        }
                    }
                    translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
                }
                System.out.printf("Your decrypted translated cipher is %s \n", translatedCipher);
            } else {
                for (int i = 0; i < userInputToProcess.length(); i++) {
                    shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
                    for (int j = 0; j < userInputShiftKey; j++) {
                        shiftKey++;
                        if (shiftKey > 51) {
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
        System.out.println("hello world");
        CipherProgram cipherProgram = new CipherProgram();
    }
}
