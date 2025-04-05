import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPressSwingExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Press Example");
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        Font font = new Font("Arial", Font.PLAIN, 24);
        textArea.setFont(font);

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                textArea.setText("Key Pressed: " + KeyEvent.getKeyText(keyCode));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                textArea.append("\nKey Released: " + KeyEvent.getKeyText(keyCode));
            }
        });

        frame.add(new JScrollPane(textArea));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        textArea.requestFocusInWindow();
    }
}