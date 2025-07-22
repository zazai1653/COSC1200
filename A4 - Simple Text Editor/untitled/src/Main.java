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
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // greeting panel
        JPanel greetingPanel = new JPanel(new GridLayout(1, 1));
        greetingPanel.add(new JLabel("Greetings! Welcome to the simple text editor app using swing."));

        // button panel (Open, Save, Exit) code below
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        JButton openButton = new JButton("Open");
        buttonPanel.add(openButton);

        JButton saveButton = new JButton("Save");
        buttonPanel.add(saveButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the frame
            }
        });
        buttonPanel.add(exitButton);

        // button panel code above (Open, Save, Exit) code below

        // wrapper panel with vertical BoxLayout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(greetingPanel);
        wrapper.add(buttonPanel);

        // add wrapper
        frame.add(wrapper);

        frame.setVisible(true);
    }
}

