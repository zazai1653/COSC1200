import javax.swing.*;
import java.util.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);

        // Greeting
        JPanel greetingPanel = new JPanel(new GridLayout(1,1));
        greetingPanel.add(new JLabel("Greetings! Welcome to the simple text editor app using swing."));

        frame.add(greetingPanel);
        frame.setVisible(true);
    }
}