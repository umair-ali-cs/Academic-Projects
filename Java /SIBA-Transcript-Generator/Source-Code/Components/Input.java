import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Input extends JTextField {

    Input(int x, int y) {
        setLayout(new BorderLayout());
        setHorizontalAlignment(10);
        setMargin(new Insets(0, 10, 0, 0));
        setBounds(x, y, 430, 50);
        setFont(new Font("Calibri", Font.PLAIN, 21));
        setForeground(Color.BLACK);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(new Color(46, 48, 145), 2));
    }
}
