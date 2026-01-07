import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {
    Button(String text, int x, int y) {
        setText(text);
        setFocusable(false);
        setForeground(new Color(46, 48, 145));
        setBackground(Color.WHITE);
        setFont(new Font("Calibri", Font.BOLD, 18));
        setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145),2));
        setBounds(x, y, 140, 50);
    }
}
