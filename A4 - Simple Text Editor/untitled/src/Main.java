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
        textAreaPanel.add(new JLabel("In the text area below you can write what you'd like to the file, or see the contents of the file chosen."));
        textAreaPanel.add(scrollPane);

        // button panel (Open, Save, Exit) code below
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        JButton openButton = new JButton("Open");
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
                        br.close(); // closed in the try to avoid additional lines
                    }
                    catch (IOException ioex){
                        ioex.printStackTrace();
                        textArea.setText("An IOException was caught.");
                    }
                    catch (Exception ex){
                        textArea.setText("An exception was thrown");
                    }
                }
                else{
                    textArea.setText("You didn't open a file, hesitation leads to defeat!");
                }
            }
        });
        buttonPanel.add(openButton);

        JButton saveButton = new JButton("Save");
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
                    textArea.setText("An exception was thrown");
                }
            }
        });
        buttonPanel.add(saveButton);

        JButton exitButton = new JButton("Exit");
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

        // Secret sauce: fortune teller

        // add wrapper
        frame.add(wrapper);
        frame.setVisible(true);
    }
}

