import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class CypherGui {
    public static void main(String[] args){
        JFrame frame = new JFrame("Cipher program using a GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));

        JFileChooser fileChooser = new JFileChooser();
        File fileChosen = null;

        // Instructions/error
        JPanel instructionPanel = new JPanel(new BorderLayout(5,5));

        JTextArea instructionsAndErrors = new JTextArea("Greetings! Welcome to the cipher application using a GUI. Write what you would like to process as a cipher below, choose the alphabet, the method to be used (substitution/translation), the shift and complexity key and then select whether you would like to encrypt or decrypt the message.", 3,30);
        instructionsAndErrors.setLineWrap(true);
        instructionsAndErrors.setWrapStyleWord(true);
        instructionsAndErrors.setEditable(false);
        instructionsAndErrors.setFocusable(false);
        wrapper.add(instructionsAndErrors, BorderLayout.NORTH);

        JTextArea userInput = new JTextArea(5,40);
        userInput.setLineWrap(true);
        userInput.setWrapStyleWord(true);
        userInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        wrapper.add(userInput, BorderLayout.CENTER);

        //2/6 Alphabets area
        JTextArea alphabets = new JTextArea(2,40);
        alphabets.setLineWrap(true);
        alphabets.setWrapStyleWord(true);
        wrapper.add();

        frame.getContentPane().add(wrapper);
        frame.pack();
        frame.setVisible(true);
    }

    // OUTSIDE OF MAIN
    private JPanel wrapWithLabel(String labelText, JComponent comp) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel(labelText), BorderLayout.NORTH);
        panel.add(comp, BorderLayout.CENTER);
        return panel;
    }

    private JPanel wrapComponent(JComponent comp) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(comp, BorderLayout.CENTER);
        return panel;
    }
}
