import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton {
    Button(String text, int x, int y, int width, int height, ActionListener c, int borderThickness) {
        setText(text);
        setFocusable(false);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
        setFont(new Font("Calibri", Font.BOLD, 18));
        setBounds(x, y, width, height);
        addActionListener(c);
    }
}
