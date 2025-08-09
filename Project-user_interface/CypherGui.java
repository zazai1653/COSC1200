import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;


public class CypherGui {

    class CipherProgram {
        final Scanner input = new Scanner(System.in);
        final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final String COSC1200_ALPHABET = "YWLRASKTEZGMVHQBXNCDIJFUOPywlrasktezgmvhqbxncdijfuop";

        String userInputToProcess = "";
        String translatedCipher = "";
        int userInputShiftKey = 0;
        byte shiftKey = 0;
        int complexityKey = 0;
        char placeHolderToUseInConversion = 0;
        boolean initializationForSubstitution = true;


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
                if(translateButton.isSelected()){
                    CipherProgram cipher = new CipherProgram();
                    funcEncryptAndTranslate();
                }
                else{

                }
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
