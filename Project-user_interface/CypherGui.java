import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

class CipherProgram {
    final Scanner input = new Scanner(System.in);
    final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final String COSC1200_ALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";

    byte continueCipher = 1;
    byte userChoiceOfEncryptionOrDecryptionMode = 0;
    boolean validationLoopForEncryptOrDecryptMode = true;
    byte userChoiceOfSubstitutionOrTranslation = 0;
    boolean validationLoopForSubstitutionOrTranslation = true;
    String userInputToProcess = "";
    String translatedCipher = "";
    boolean validationForUserInputShiftKey = true;
    int userInputShiftKey = 0;
    byte shiftKey = 0;
    boolean validationForUserInputComplexityKey = true;
    int complexityKey = 0;
    char placeHolderToUseInConversion = 0;
    boolean initializationForSubstitution = true;

    public CipherProgram() {
        while (continueCipher == 1) {
            // Reset all state variables
            userChoiceOfEncryptionOrDecryptionMode = 0;
            validationLoopForEncryptOrDecryptMode = true;
            userChoiceOfSubstitutionOrTranslation = 0;
            validationLoopForSubstitutionOrTranslation = true;
            validationForUserInputShiftKey = true;
            userInputShiftKey = 0;
            validationForUserInputComplexityKey = true;
            complexityKey = 0;
            initializationForSubstitution = true;
            placeHolderToUseInConversion = 0;
            userInputToProcess = "";
            translatedCipher = "";

            System.out.println("Press 1 to run a cipher program, 2 to exit.");
            if (input.hasNextInt()) {
                continueCipher = input.nextByte();
                input.nextLine();

                if (continueCipher == 1) {
                    funcGetModeOfEncryptionOrDecryption();

                    System.out.println((userChoiceOfEncryptionOrDecryptionMode == 1)
                            ? "Enter the value you would like to encrypt"
                            : "Enter the value you would like to decrypt");

                    userInputToProcess = input.nextLine();
                    funcGetCipherModeOfSubstitutionOrTranslation();

                    if (userChoiceOfSubstitutionOrTranslation == 1) {
                        funcGetComplexityKey();
                        if (userChoiceOfEncryptionOrDecryptionMode == 1) {
                            funcEncryptAndSubstitute();
                        } else {
                            funcDecryptAndSubstitute();
                        }
                    } else {
                        funcGetShiftKey();
                        if (userChoiceOfEncryptionOrDecryptionMode == 1) {
                            funcEncryptAndTranslate();
                        } else {
                            funcDecryptAndTranslate();
                        }
                    }
                } else {
                    System.out.println("Au revoir!");
                }
            } else {
                System.out.println("1 to encrypt/decrypt, 2 to exit");
                input.next();
            }
        }
    }

    void funcGetModeOfEncryptionOrDecryption() {
        while (validationLoopForEncryptOrDecryptMode) {
            System.out.println("Enter 1 to encrypt a message, or 2 to decrypt.");
            if (input.hasNextInt()) {
                userChoiceOfEncryptionOrDecryptionMode = input.nextByte();
                input.nextLine();
                if (userChoiceOfEncryptionOrDecryptionMode == 1
                        || userChoiceOfEncryptionOrDecryptionMode == 2) {
                    validationLoopForEncryptOrDecryptMode = false;
                } else {
                    System.out.println("The options are 1 (encrypt) or 2 (decrypt).");
                }
            } else {
                System.out.println("The options are 1 (encrypt) or 2 (decrypt).");
                input.next();
            }
        }
    }

    void funcGetCipherModeOfSubstitutionOrTranslation() {
        while (validationLoopForSubstitutionOrTranslation) {
            System.out.println("For the cipher, enter 1 to substitute or 2 to translate.");
            if (input.hasNextInt()) {
                userChoiceOfSubstitutionOrTranslation = input.nextByte();
                input.nextLine();
                if (userChoiceOfSubstitutionOrTranslation == 1
                        || userChoiceOfSubstitutionOrTranslation == 2) {
                    validationLoopForSubstitutionOrTranslation = false;
                } else {
                    System.out.println("The options are 1 (substitute) or 2 (translate).");
                }
            } else {
                System.out.println("The options are 1 (substitute) or 2 (translate).");
                input.next();
            }
        }
    }

    void funcGetShiftKey() {
        while (validationForUserInputShiftKey) {
            System.out.println("Enter the shift key you would like to use");
            if (input.hasNextInt()) {
                userInputShiftKey = input.nextInt();
                input.nextLine();
                validationForUserInputShiftKey = false;
            } else {
                System.out.println("Enter a number value between −2,147,483,648 to 2,147,483,647");
                input.next();
            }
        }
    }

    void funcGetComplexityKey() {
        while (validationForUserInputComplexityKey) {
            System.out.println("Enter the complexity key to use (whole number greater than 0)");
            if (input.hasNextInt()) {
                complexityKey = input.nextInt();
                input.nextLine();
                if (complexityKey > 0) {
                    validationForUserInputComplexityKey = false;
                }
            } else {
                System.out.println("Enter a number value between −2,147,483,648 to 2,147,483,647");
                input.next();
            }
        }
    }

    void funcEncryptAndTranslate() {
        translatedCipher = "";
        for (int i = 0; i < userInputToProcess.length(); i++) {
            shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
            if (userInputShiftKey < 0) {
                for (int j = 0; j > userInputShiftKey; j--) {
                    shiftKey--;
                    if (shiftKey < 0) shiftKey = (byte) (ENGLISH_ALPHABET.length() - 1);
                }
            } else {
                for (int j = 0; j < userInputShiftKey; j++) {
                    shiftKey++;
                    if (shiftKey >= ENGLISH_ALPHABET.length()) shiftKey = 0;
                }
            }
            translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
        }
        System.out.printf("Your translated cipher is %s\n", translatedCipher);
    }

    void funcEncryptAndSubstitute() {
        translatedCipher = "";
        for (int i = 0; i < userInputToProcess.length(); i++) {
            char current = userInputToProcess.charAt(i);
            char result = current;
            for (int j = 0; j < complexityKey; j++) {
                result = COSC1200_ALPHABET.charAt(ENGLISH_ALPHABET.indexOf(result));
            }
            translatedCipher += result;
        }
        System.out.printf("Your encrypted substituted cipher is %s\n", translatedCipher);
    }

    void funcDecryptAndSubstitute() {
        translatedCipher = "";
        for (int i = 0; i < userInputToProcess.length(); i++) {
            char current = userInputToProcess.charAt(i);
            char result = current;
            for (int j = 0; j < complexityKey; j++) {
                result = ENGLISH_ALPHABET.charAt(COSC1200_ALPHABET.indexOf(result));
            }
            translatedCipher += result;
        }
        System.out.printf("Your decrypted substituted cipher is %s\n", translatedCipher);
    }

    void funcDecryptAndTranslate() {
        translatedCipher = "";
        for (int i = 0; i < userInputToProcess.length(); i++) {
            shiftKey = (byte) ENGLISH_ALPHABET.indexOf(userInputToProcess.charAt(i));
            if (userInputShiftKey < 0) {
                for (int j = 0; j > userInputShiftKey; j--) {
                    shiftKey--;
                    if (shiftKey < 0) shiftKey = (byte) (ENGLISH_ALPHABET.length() - 1);
                }
            } else {
                for (int j = 0; j < userInputShiftKey; j++) {
                    shiftKey++;
                    if (shiftKey >= ENGLISH_ALPHABET.length()) shiftKey = 0;
                }
            }
            translatedCipher += ENGLISH_ALPHABET.charAt(shiftKey);
        }
        System.out.printf("Your decrypted translated cipher is %s\n", translatedCipher);
    }
}

public class CypherGui {
    public static void main(String[] args) {
        final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final String COSC1200_ALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";

        JFrame frame = new JFrame("Cipher program using a GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JFileChooser fileChooser = new JFileChooser();
        File fileChosen = null;

        JScrollPane scrollPane;

        // label 1/6 - instructions and errors panel and the text area
        JPanel instructionsAndErrorsPanel = new JPanel(new GridLayout(2, 1));
        JTextArea instructionsAndErrorsLabel = new JTextArea("Greetings! Welcome to the cipher application using a GUI. Write what you would like to process as a cipher below, choose the alphabet, the method to be used (substitution/translation), the shift and complexity key and then select whether you would like to encrypt or decrypt the message.");
        instructionsAndErrorsLabel.setLineWrap(true);
        instructionsAndErrorsLabel.setWrapStyleWord(true);
        instructionsAndErrorsLabel.setFocusable(false);
        instructionsAndErrorsLabel.setEditable(false);
        instructionsAndErrorsPanel.add(instructionsAndErrorsLabel);

        JTextArea userInput = new JTextArea();
        userInput.setLineWrap(true);
        userInput.setWrapStyleWord(true);
        userInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        scrollPane = new JScrollPane(userInput);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        instructionsAndErrorsPanel.add(scrollPane);

        // labels 2+3/6 - Alphabets
        JPanel alphabetsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        alphabetsPanel.add(new JLabel("<html>English alphabet: " + ENGLISH_ALPHABET + "<br> COSC1200 alphabet: " + COSC1200_ALPHABET + "</html>"));
        // 2 radio buttons for substitution/translation
        JPanel radioButtonsTranslateSubstitutePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JRadioButton translateButton = new JRadioButton("Translate", true);
        JRadioButton substitutionButton = new JRadioButton("Substitute");
        radioButtonsTranslateSubstitutePanel.add(translateButton);
        radioButtonsTranslateSubstitutePanel.add(substitutionButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(translateButton);
        buttonGroup.add(substitutionButton);

        // label 4+5/6 - shift key and complexity key
        JPanel shiftAndComplexityKeyPanel = new JPanel(new GridLayout(2, 2));
        shiftAndComplexityKeyPanel.add(new JLabel("Enter the shift key you would like to use:"));
        shiftAndComplexityKeyPanel.add(new JLabel("Enter the complexity key you would like to use:"));

        JTextField shiftKeyTextField = new JTextField();
        shiftAndComplexityKeyPanel.add(shiftKeyTextField);
        JTextField complexityKeyTextField = new JTextField();
        shiftAndComplexityKeyPanel.add(complexityKeyTextField);

        // 3 buttons of encrypt, decrypt and exit
        JPanel buttonsPanel = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 5));
        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setToolTipText("Click/Alt+E to encrypt the text");
        encryptButton.setMnemonic(KeyEvent.VK_E);
        buttonsPanel.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setToolTipText("Click/Alt+D to decrypt the text");
        encryptButton.setMnemonic(KeyEvent.VK_D);
        buttonsPanel.add(decryptButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setToolTipText("Click/Alt+L to exit the GUI");
        exitButton.setMnemonic(KeyEvent.VK_L);
        buttonsPanel.add(exitButton);

        // label 6/6 - result area
        JPanel resultPanel = new JPanel(new GridLayout(1, 1));
        resultPanel.add(new JLabel("The processed output is: "));


        // Buttons logic
        encryptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                System.out.println();
            }
        });

        decryptButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                System.out.println();
            }
        });

        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                frame.dispose();
            }
        });

        // Wrapper with vertical BoxLayout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(instructionsAndErrorsPanel);
        wrapper.add(alphabetsPanel);
        wrapper.add(radioButtonsTranslateSubstitutePanel);
        wrapper.add(shiftAndComplexityKeyPanel);
        wrapper.add(buttonsPanel);
        wrapper.add(resultPanel);

        frame.add(wrapper);
        frame.setVisible(true);
    }
    // OUTSIDE OF MAIN
}
