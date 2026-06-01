//Cherry 
//Mr. Flower
//Final Lab
//June 3rd 20

// Swing for GUI component
import javax.swing.*;
//layout manager n dimension
import java.awt.*;
// event handling classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// regex for pattern matching
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sentenceFixer2 {

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String punctuate(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // Trim first to avoid trailing spaces
        str = str.trim();
        if (str.endsWith(".") || str.endsWith("!") || str.endsWith("?") || str.endsWith("\"")) {
            return str;
        }
        return str + ".";
    }

    // duplicate word remover
    public static String duplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // regex with word boundaries, case-insensitive, and handle multiple spaces
        Pattern pattern = Pattern.compile("(?i)\\b(\\w+)\\b(\\s+\\1\\b)+");
        Matcher matcher = pattern.matcher(str);
        String result = matcher.replaceAll("$1");
        // nothing changed, return original; otherwise clear extra space
        if (result.equals(str)) {
            return str;
        }
        return doubleSpace(result); // clear spaces after
    }

    public static String doubleSpace(String str) {
        if (str == null) return null;
        return str.replaceAll("\\s+", " ").trim();
    }

    // here is my ver of GUI mr flower :) swing is hard ;-;
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Sentence Fixer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // input box thing
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        JLabel inputLabel = new JLabel("Enter sentence:");
        JTextField inputField = new JTextField();
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);

        // out put pannel
        JPanel outputPanel = new JPanel(new BorderLayout(5, 5));
        outputPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        JLabel outputLabel = new JLabel("Fixed sentence:");
        JTextField outputField = new JTextField();
        outputField.setColumns(30);                   // the box thing was too small so I added this to make it taller
        outputField.setPreferredSize(new Dimension(500, 40)); //this and the thing on top
        outputField.setEditable(false);
        outputField.setBackground(Color.WHITE);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputField, BorderLayout.CENTER);
        
        // Button module (panel?) clear
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton fixButton = new JButton("Fix Sentence");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(fixButton);
        buttonPanel.add(clearButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(outputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // button action fix
        fixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String raw = inputField.getText();
                if (raw.trim().isEmpty()) {
                    outputField.setText("Please enter a sentence.");
                    return;
                }

                try {
                    // Applies my fixes in order
                    String step1 = capitalize(raw);
                    String step2 = punctuate(step1);
                    String step3 = duplicates(step2);
                    String step4 = doubleSpace(step3);
                    outputField.setText(step4);
                } catch (Exception ex) {
                    // error popup and also write to output field if there is an exception
                    JOptionPane.showMessageDialog(frame,
                        "Error while fixing sentence:\n" + ex.toString(),
                        "Processing Error",
                        JOptionPane.ERROR_MESSAGE);
                    outputField.setText("Error: " + ex.getMessage());
                    ex.printStackTrace(); // for debugging, because I caught an error ;-;
                }
            }
        });

        // button action for clear
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                outputField.setText("");
                inputField.requestFocus();
            }
        });

        //final window settigs
        frame.setSize(550, 200);
        frame.setLocationRelativeTo(null); // center to screen
        frame.setVisible(true); //abracadabra the window appears
    }

    public static void main(String[] args) {
    // SwingUtilities.invokeLater create GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI(); // its in the name :D
            }
        });
    }
}