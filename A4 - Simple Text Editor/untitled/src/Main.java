import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // even though java.awt.* is imported, my code won't work without specification
import java.awt.event.ActionListener;
import java.io.*;

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

        // greeting panel
        JPanel greetingPanel = new JPanel(new GridLayout(1, 1));
        greetingPanel.add(new JLabel("Greetings! Welcome to the simple text editor app using swing."));

        // JTextArea used to write and read to and from files
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
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        // labelled textbox creation
        File fileForLabelledTextBox = fileChooser.getSelectedFile();
        JTextField pathTextField = new JTextField("");
        JPanel pathPanel = new JPanel(new GridLayout(1,1));
        pathPanel.add(pathTextField);
        if (fileForLabelledTextBox == null){
            pathTextField.setText("No path file detected");
        }


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

                        br.close(); // closed in the try to avoid additional lines
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
                    bw.close();
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

        // wrapper panel with vertical BoxLayout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(greetingPanel);
        wrapper.add(textAreaPanel);
        wrapper.add(buttonPanel);
        wrapper.add(pathPanel);

        // Secret sauce: fortune teller

        // add wrapper
        frame.add(wrapper);
        frame.setVisible(true);
    }
}

