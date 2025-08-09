import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

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
        JPanel buttonPanel = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 5));
        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setToolTipText("Click/Alt+E to encrypt the text");
        encryptButton.setMnemonic(KeyEvent.VK_E);
        buttonPanel.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setToolTipText("Click to decrypt the text");
        buttonPanel.add(decryptButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setToolTipText("Click to exit the GUI");
        buttonPanel.add(encryptButton);

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

        /*
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

        */


        // Wrapper with vertical BoxLayout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(instructionsAndErrorsPanel);
        wrapper.add(alphabetsPanel);
        wrapper.add(radioButtonsTranslateSubstitutePanel);
        wrapper.add(shiftAndComplexityKeyPanel);

        frame.add(wrapper);
        frame.setVisible(true);
    }
    // OUTSIDE OF MAIN
}
