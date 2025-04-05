import java.awt.*;
import java.awt.event.*;

public class MouseEventExample extends Frame implements MouseListener {

    // Variable to store the message to be displayed
    private String message = "";

    public MouseEventExample() {
        // Add the MouseListener to capture mouse events
        addMouseListener(this);

        // Add a WindowListener to handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0); // Close the application when the window is closed
            }
        });

        // Set the size and make the frame visible
        setSize(300, 200);
        setVisible(true);
    }

    // Override the paint method to draw messages on the window
    @Override
    public void paint(Graphics g) {
        super.paint(g);  // Call the superclass method to ensure proper painting
        g.drawString(message, 50, 100); // Draw the message at coordinates (50, 100)
    }

    // MouseListener methods

    // Mouse clicked event
    public void mouseClicked(MouseEvent me) {
        message = "Mouse Clicked at: " + me.getX() + ", " + me.getY();
        repaint();  // Repaint the window to update the message
    }

    // Mouse pressed event
    public void mousePressed(MouseEvent me) {
        message = "Mouse Pressed at: " + me.getX() + ", " + me.getY();
        repaint();  // Repaint  window to update the message
    }

    // Mouse released event (not used in this example)
    public void mouseReleased(MouseEvent me) { }

    // Mouse entered event
    public void mouseEntered(MouseEvent me) {
        message = "Mouse Entered the window!";
        repaint();  // Repaint the window to update the message
    }

    // Mouse exited event
    public void mouseExited(MouseEvent me) {
        message = "Mouse Exited the window!";
        repaint();  // Repaint the window to update the message
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new MouseEventExample(); // Create an instance of the Frame
    }
}