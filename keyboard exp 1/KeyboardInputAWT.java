import java.awt.*;
import java.awt.event.*;

public class KeyboardInputAWT extends Frame implements ActionListener {
    private TextField inputField;
    private TextArea displayArea;

    public KeyboardInputAWT() {
        // Set up the frame
        setTitle("Keyboard Input AWT Example");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Create components
        inputField = new TextField(20);
        displayArea = new TextArea(10, 30);

        // Add components to the frame
        add(new Label("Enter text:"));
        add(inputField);
        add(displayArea);

        // Add action listener to the text field
        inputField.addActionListener(this);

        // Close the window when the close button is clicked
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the text from the input field and display it in the text area
        String inputText = inputField.getText();
        displayArea.append(inputText + "\n");
        inputField.setText("");
    }

    public static void main(String[] args) {
        new KeyboardInputAWT();
    }
}