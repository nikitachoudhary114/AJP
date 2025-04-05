import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarksFrame extends JFrame implements ActionListener {
    private JTextField nameField, markField1, markField2, markField3;
    private JButton showResult;

    public StudentMarksFrame() {
        setTitle("Student Marks Entry");
        setSize(350, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Student Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("English:"));
        markField1 = new JTextField(5);
        add(markField1);

        add(new JLabel("Math:"));
        markField2 = new JTextField(5);
        add(markField2);

        add(new JLabel("Science:"));
        markField3 = new JTextField(5);
        add(markField3);

        showResult = new JButton("Show Result");
        showResult.addActionListener(this);
        add(showResult);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText().trim();
            int mark1 = Integer.parseInt(markField1.getText());
            int mark2 = Integer.parseInt(markField2.getText());
            int mark3 = Integer.parseInt(markField3.getText());

            int total = mark1 + mark2 + mark3;
            double average = total / 3.0;
            boolean isPass = average >= 40;

            showResultWindow(name, total, average, isPass);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Marks! Enter numbers between 0-100.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showResultWindow(String name, int total, double average, boolean isPass) {
        JFrame resultFrame = new JFrame("Result");
        resultFrame.setSize(250, 150);
        resultFrame.setLayout(new GridLayout(5, 1));

        resultFrame.add(new JLabel("Student: " + name));
        resultFrame.add(new JLabel("Total Marks: " + total));
        resultFrame.add(new JLabel("Average: " + String.format("%.2f", average)));

        JLabel resultLabel = new JLabel(isPass ? "PASS" : "FAIL");
        resultLabel.setForeground(isPass ? Color.GREEN : Color.RED);
        resultFrame.add(resultLabel);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> resultFrame.dispose());
        resultFrame.add(closeButton);

        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentMarksFrame();
    }
}
