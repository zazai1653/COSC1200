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
    final byte ALPHABET_MAX_INDEX_SIZE = 52;

    // the variable used to continue the cipher
    boolean continueCipher = true;

    // variables used to get user's choice of encryption or decryption, and the validation condition for it
    byte userChoiceOfEncryptionOrDecryptionMode = 0;
    boolean validationLoopForEncryptOrDecryptMode = true;

    // variables used to get user's choice of substitution or translation, and the validation condition for it
    byte userChoiceOfSubstitutionOrTranslation = 0;
    boolean validationLoopForSubstitutionOrTranslation = true;

    // variables used to get what the user wants to process, the shift key, the translated output
    String userInputToProcess = "\0";
    String translatedCipher = "\0";
    int shiftKey = 0;

    public CipherProgram(){
        System.out.println("Constructor called");
        if(userChoiceOfEncryptionOrDecryptionMode == 1){

        }
        else{
            
        }
        functionForGettingCipherModeOfSubstitutionOrTranslation();
    }

    void functionForGettingEncryptionOrDecryptionMode(){
        while (validationLoopForEncryptOrDecryptMode){
            System.out.println("Enter 1 to encrypt a message, or 2 to decrypt.");
            if (input.hasNextInt()){
                userChoiceOfEncryptionOrDecryptionMode = input.nextByte();
                System.out.println("You entered a valid input to encrypt/decrypt a message.");
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
                System.out.println("You didn't make a valid selection.");
                input.next();
            }
        }
    }

    void functionForGettingCipherModeOfSubstitutionOrTranslation(){
        while (validationLoopForSubstitutionOrTranslation){
            System.out.println("For the cipher, enter 1 to substitute or 2 to translate.");
            if (input.hasNextInt()){
                userChoiceOfSubstitutionOrTranslation = input.nextByte();
                System.out.println("You entered a valid input to encrypt/decrypt a message.");
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
                System.out.println("You didn't make a valid selection.");
                input.next();
            }
        }
    }

    void functionForEncryption(){
        System.out.println("Enter the value you would like to encrypt");
        userInputToProcess = input.nextLine();
    }
    void functionForDecryption(){
        System.out.println("Enter the value you would like to decrypt");
        userInputToProcess = input.nextLine();
    }
}

public class Main{

    public static void main(String[] args){
        System.out.println("hello world");
        CipherProgram cipherProgram = new CipherProgram();
    }
}
