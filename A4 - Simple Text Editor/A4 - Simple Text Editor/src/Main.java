// Name: Rustam Zazai
// Date: 2025-7-22
// Description: Simple text editor created using swing and awt in java.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // even though java.awt.* is imported, my code won't work without specification
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JFileChooser fileChooser = new JFileChooser();
        File fileChosen = null;
        JScrollPane scrollPane;

        Random rand = new Random();

        // greeting panel
        JPanel greetingPanel = new JPanel(new GridLayout(1, 1));
        greetingPanel.add(new JLabel("Greetings! Welcome to the simple text editor app using swing."));

        // JTextArea used to write and read to and from files, I included it in a scrollPane to improve clarity
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel textAreaPanel = new JPanel(new GridLayout(2,1));
        textAreaPanel.add(new JLabel("Once you open a file, the text area below will show the contents of the file chosen and you can write what you'd like to add."));
        textAreaPanel.add(scrollPane);

        // button panel (Open, Save, Exit) code below
        JPanel buttonPanel = new JPanel(new FlowLayout (FlowLayout.CENTER, 10, 5));

        // labelled textbox creation
        File fileForLabelledTextBox = fileChooser.getSelectedFile();
        JTextField pathTextField = new JTextField("No path file selected");
        JPanel pathPanel = new JPanel(new GridLayout(1,1));
        pathPanel.add(pathTextField);

        // open button
        JButton openButton = new JButton("Open");
        openButton.setToolTipText("Click to select a file for editing");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                int openedAFile = fileChooser.showOpenDialog(frame);
                if(openedAFile == JFileChooser.APPROVE_OPTION){
                    try{
                        BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                        String fileContent = "";
                        String fileLine;
                        while((fileLine = br.readLine()) != null){
                            fileContent += fileLine;
                            fileContent += '\n';
                        }
                        textArea.setText(fileContent);
                        // labelled textbox displaying the name and path of the file being edited
                        File fileForLabelledTextBox = fileChooser.getSelectedFile();
                        if(fileForLabelledTextBox != null) {
                            fileForLabelledTextBox.getAbsolutePath();
                            String absolutePath = fileForLabelledTextBox.getAbsolutePath();
                            String fileName = fileForLabelledTextBox.getName();
                            pathTextField.setText("The file name is " + fileName + " and the file's absolute path is: " + absolutePath);
                        }
                        else {
                            pathTextField.setText("No file selected yet");
                        }
                        br.close(); // I closed the BufferedReader at the end to avoid extra lines
                    }
                    catch (IOException ioex){
                        ioex.printStackTrace();
                        textArea.setText("An IOException was caught.");
                    }
                    catch (Exception ex){
                        ex.getMessage();
                        textArea.setText("An exception was thrown");
                    }
                }
                else{
                    textArea.setText("You didn't open a file, hesitation leads to defeat!");
                }
            }
        });
        buttonPanel.add(openButton);

        // save button
        JButton saveButton = new JButton("Save");
        saveButton.setToolTipText("Click to save what you have written to the file");
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    File file1 = fileChooser.getSelectedFile();
                    String fileContent = textArea.getText();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                    bw.write(fileContent);
                    bw.close(); // I closed the BufferedWriter at the end to avoid extra lines
                }
                catch (NullPointerException ne){
                    textArea.setText("Slow your roll cowboy, you've gotta select a file first.");
                }
                catch (IOException ex){
                    ex.printStackTrace();
                    textArea.setText("An IOException was caught.");
                }
                catch (Exception ex){
                    ex.getMessage();
                    textArea.setText("An exception was thrown");
                }
            }
        });
        buttonPanel.add(saveButton);

        // exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setToolTipText("Click to exit the UI");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonPanel.add(exitButton);

        // Secret sauce - fortune teller: you type what action you want to perform and RNG will tell you how it would turn out, talks baseless nonsense just like a real fortune teller
        JPanel fortuneTellerPanel = new JPanel(new GridLayout(3, 1));
        // I used chatGPT to learn how to create newlines in a JLabel
        JLabel fortuneTellerLabel = new JLabel("<html>I am a fortune teller, you'd listen to my divinations to live a life that's stellar.<br>Tell me your heart's desire, and I will tell you what action you require.</html>");
        fortuneTellerLabel.setForeground(Color.red);
        fortuneTellerPanel.setBackground(Color.yellow);
        fortuneTellerPanel.add(fortuneTellerLabel);
        JTextArea fortuneTellerTextArea = new JTextArea();
        fortuneTellerTextArea.setLineWrap(true);
        fortuneTellerTextArea.setWrapStyleWord(true);
        fortuneTellerTextArea.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,2));

        JButton fortuneTellerButton = new JButton("Divinate");
        fortuneTellerButton.setToolTipText("Click to know what awaits!");
        fortuneTellerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (!fortuneTellerTextArea.getText().isEmpty()){
                    int randomNumber = rand.nextInt(5 - 1 + 1) + 1;
                    switch(randomNumber){
                        case 1:
                            fortuneTellerTextArea.setBackground(Color.blue);
                            fortuneTellerTextArea.setForeground(Color.green);
                            fortuneTellerTextArea.setText("The spirits tell me great things await you if you \"" + fortuneTellerTextArea.getText() + "\"");
                            break;
                        case 2:
                            fortuneTellerTextArea.setBackground(Color.blue);
                            fortuneTellerTextArea.setForeground(Color.green);
                            fortuneTellerTextArea.setText("Good things await you if you \"" + fortuneTellerTextArea.getText() + "\"");
                            break;
                        case 3:
                            fortuneTellerTextArea.setBackground(Color.white);
                            fortuneTellerTextArea.setForeground(Color.black);
                            fortuneTellerTextArea.setText("The spirits are unsure of the outcome for\"" + fortuneTellerTextArea.getText() + "\"");
                            break;
                        case 4:
                            fortuneTellerTextArea.setBackground(Color.black);
                            fortuneTellerTextArea.setForeground(Color.red);
                            fortuneTellerTextArea.setText("If you \"" + fortuneTellerTextArea.getText() + "\" it will not go in your favour");
                            break;
                        case 5:
                            fortuneTellerTextArea.setBackground(Color.black);
                            fortuneTellerTextArea.setForeground(Color.red);
                            fortuneTellerTextArea.setText("The spirits strongly protest against \"" + fortuneTellerTextArea.getText() + "\"");
                            break;
                    }
                }
                else{
                    fortuneTellerTextArea.setText("Hold your horses, my power to tell require sources, write something and I can divinate using supernatural forces.");
                }
            }
        });
        fortuneTellerPanel.add(fortuneTellerTextArea);
        fortuneTellerPanel.add(fortuneTellerButton);

        // wrapper panel with vertical BoxLayout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(greetingPanel);
        wrapper.add(textAreaPanel);
        wrapper.add(buttonPanel);
        wrapper.add(pathPanel);
        wrapper.add(fortuneTellerPanel);

        // add wrapper
        frame.add(wrapper);
        frame.setVisible(true);
    }
}

