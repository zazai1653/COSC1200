import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // even though java.awt.* is imported, my code wont work without specification
import java.awt.event.ActionListener;
import java.io.*;

public class Main {
    private static void appendFile(String userInputFilename) {
        System.out.println("Hi");
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JFileChooser fileChooser = new JFileChooser();
        File currentFile = null;

        // greeting panel
        JPanel greetingPanel = new JPanel(new GridLayout(1, 1));
        greetingPanel.add(new JLabel("Greetings! Welcome to the simple text editor app using swing."));

        // button panel (Open, Save, Exit) code below
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        JButton openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        buttonPanel.add(openButton);

        JButton saveButton = new JButton("Save");
        buttonPanel.add(saveButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonPanel.add(exitButton);

        // JTextArea used to write and read to and from files
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        JPanel textAreaPanel = new JPanel(new GridLayout(2,1));
        textAreaPanel.add(new JLabel("In the text area below you can write what you'd like to the file, or see the contents of the file chosen."));
        textAreaPanel.add(textArea);

        // wrapper panel with vertical BoxLayout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(greetingPanel);
        wrapper.add(buttonPanel);
        wrapper.add(textAreaPanel);

        // Secret sauce: fortune teller

        // add wrapper
        frame.add(wrapper);
        frame.setVisible(true);
    }
}

